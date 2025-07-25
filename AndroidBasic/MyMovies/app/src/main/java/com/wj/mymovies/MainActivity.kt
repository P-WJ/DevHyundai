package com.wj.mymovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.wj.mymovies.ui.theme.MyMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var movies = remember {
                mutableStateListOf(
                Movie("잼창우", R.drawable.poster1),
                Movie("업창우", R.drawable.poster2),
                Movie("우창우", R.drawable.poster3),
                )
            }
            MyMoviesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(movies) { movie ->
                            MovieView(
                                movie = movie,
                                onTabFavorite = {
//                                    movie.isFavorite= !movie.isFavorite
                                    val index = movies.indexOf(movie)
                                    movies[index] = movie.copy(isFavorite = !movie.isFavorite)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

data class Movie(
    val title: String,
    val imageRes: Int,
    var isFavorite: Boolean = false
)


@Composable
fun MovieView(
    movie: Movie,
    onTabFavorite: ()-> Unit
) {
    Column {
        Text(
            movie.title,
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = movie.imageRes),
                    contentDescription = "부산행",
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopEnd
                ) {
                    IconButton(
                        onClick = onTabFavorite,
                    ) {
                        Icon(
                            imageVector = if (movie.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "재생",
                            tint = Color.Red
                        )
                    }
                }
            }
        }
    }
}
