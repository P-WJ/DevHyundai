package com.example.clazzi.ui.components

import android.Manifest
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.compose.material3.*

@Composable
private fun PermissionPickerLauncher(
    permission: String,
    rationale: String,
    onLaunchPicker: () -> Unit,
    onResult: (Boolean) -> Unit = {}
) {
    val context = LocalContext.current
    var showRationale by remember { mutableStateOf(false) }
    var launched by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            onLaunchPicker()
        } else {
            showRationale = true
        }
        onResult(isGranted)
    }

    LaunchedEffect("Unit") {
        if (!launched) {
            launched = true
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
                onLaunchPicker()
                onResult(true)
            } else {
                permissionLauncher.launch(permission)
            }
        }
    }

    if (showRationale) {
        AlertDialog(
            onDismissRequest = { showRationale = false },
            title = { Text("권한 요청") },
            text = { Text(rationale) },
            confirmButton = {
                TextButton(onClick = { showRationale = false} ) {
                    Text("확인")
                }
            },
        )
    }
}

@Composable
fun ImagePickerWithPermission(
    onImagePicked: (Uri?) -> Unit
) {
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        onImagePicked(uri)
    }
    val imagePermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        android.Manifest.permission.READ_MEDIA_IMAGES
    } else {
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    }
    PermissionPickerLauncher(
        permission = imagePermission,
        rationale = "이미지를 사용하기 위해서는 갤러리 접근 권한이 필요합니다.",
        onLaunchPicker = { galleryLauncher.launch("image/*") }
    )
}

@Composable
fun CameraPickerWithPermission(
    onImageCaptured: (Uri?) -> Unit
) {
    val context = LocalContext.current
    var cameraImageUri by remember { mutableStateOf<Uri?>(null)}
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success: Boolean ->
        if (success) {
            onImageCaptured(cameraImageUri)
        }
    }
    val cameraPermission = Manifest.permission.CAMERA

    PermissionPickerLauncher(
        permission = cameraPermission,
        rationale = "사진을 촬영하려면 카메라 권한이 필요합니다.",
        onLaunchPicker = {
            cameraImageUri = createImageUri(context)
            cameraImageUri?.let { cameraLauncher.launch(it)}
        }

    )
}

fun createImageUri(context: Context): Uri? {
    val contentValues = ContentValues().apply {
        put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        put(MediaStore.Images.Media.DISPLAY_NAME, "vote_${System.currentTimeMillis()}.jpg")
    }
    return context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
}