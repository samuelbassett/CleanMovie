package com.tc.cleanmovie.presentation.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.tc.cleanmovie.framework.data.model.details.DetailsModel

@Composable
fun DetailsScreen(
    navController: NavController,
    movieId: Int
) {
    val viewModel = hiltViewModel<DetailsViewModel>()
    val detailsData by viewModel.detailsData.collectAsState()
    var isFavorite by remember { mutableStateOf(false) }

    viewModel.getDetails(movieId)
    MovieDetailsScreen(
        detailsData,
        isFavorite
    ) {
        isFav ->
        isFavorite = isFav
        viewModel.toggleFavorite(movieId, isFavorite)
    }
}

@Composable
fun MovieDetailsScreen(detailsData: DetailsModel, isFavorite: Boolean, onFavoriteToggle: (Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 64.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${detailsData.posterPath}",
                contentDescription = "Movie Poster",
                modifier = Modifier
                    .height(256.dp)
                    .padding(end = 8.dp))
            Column {
                Text(
                    text = detailsData.title.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start)
                Text(
                    text = detailsData.releaseDate.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(top = 8.dp))
            }
        }
        Text(
            text = detailsData.overview.toString(),
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
        Button(onClick = {
            // Toggle the favorite status and trigger the provided lambda
            onFavoriteToggle(!isFavorite)
        }) {
            Text(text = if (isFavorite) "Remove from Favorites" else "Add to Favorites")
        }
    }
}