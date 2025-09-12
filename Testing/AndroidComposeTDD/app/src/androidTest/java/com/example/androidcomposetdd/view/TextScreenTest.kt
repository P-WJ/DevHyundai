package com.example.androidcomposetdd.view

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.androidcomposetdd.viewmodel.TextViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TextScreenTest {
    // JUnit 4의 TestRule 어노테이션. setup/teardown 역할
    @get:Rule
    // 안드로이드 에뮬레이터나 디바이스에서 실제 UI처럼 테스트 지원
    val composeTestRule = createComposeRule()

    @Test
    fun testUpdateTextScreen() {
        // Given: TextScreen 렌더링
        // 컴포즈에서 메인 액티비티에서 setContent 해주는 것처럼
        // UI 테스트에서도 실제 UI 렌더링
        composeTestRule.setContent {
            // 레드: TextScreen 없음
            // 그린: TextScreen 스켈레톤 생성
            TextScreen(viewModel = hiltViewModel())
//            TextScreen(viewModel = TextViewModel())
        }

        // When: TextField에 텍스트 입력
        composeTestRule.onNodeWithTag("textInput").performTextInput("Hello, TDD!")
        composeTestRule.waitForIdle()  // UI 업데이트 대기

        // Then: 표시된 텍스트 확인
        composeTestRule.onNodeWithTag("displayText").assertTextEquals("Hello, TDD!")
    }
}