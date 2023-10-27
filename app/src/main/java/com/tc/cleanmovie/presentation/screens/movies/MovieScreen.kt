package com.tc.cleanmovie.presentation.screens.movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.tc.cleanmovie.framework.data.model.movie.MovieItemModel
import com.tc.cleanmovie.presentation.screens.navigation.Screens

@Composable
fun MovieScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<MovieViewModel>()
    val schoolData by viewModel.movieData.collectAsState()

    val navigateToDetails: (String) -> Unit = { movieId ->
        navController.navigate("${Screens.MovieDetails.route}/$movieId")
    }

    LazyColumn(
        modifier = Modifier
            .padding(top = 64.dp, bottom = 56.dp)
            .fillMaxSize()
    ) {
        items(schoolData) { movie ->
            MovieItem(movie, navigateToDetails)
        }
    }
}

@Composable
fun MovieItem(movie: MovieItemModel, navigateToDetails: (String) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxSize()
            .clickable { navigateToDetails(movie.id.toString()) }
    ) {
        Row {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
                contentDescription = "Poster Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(64.dp)
                    .padding(8.dp)
                )
            Column(
                modifier = Modifier
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = movie.title.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start)
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Text(
                    text = movie.releaseDate.toString(),
                    color = Color.Black,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start)
            }
        }
    }
}
