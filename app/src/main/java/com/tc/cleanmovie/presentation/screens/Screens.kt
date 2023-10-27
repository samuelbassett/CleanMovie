package com.tc.cleanmovie.presentation.screens

import com.tc.cleanmovie.presentation.screens.ScreenName.FAVORITE_LIST
import com.tc.cleanmovie.presentation.screens.ScreenName.FAVORITE_LIST_HEADER
import com.tc.cleanmovie.presentation.screens.ScreenName.MOVIE_DETAILS
import com.tc.cleanmovie.presentation.screens.ScreenName.MOVIE_DETAILS_HEADER
import com.tc.cleanmovie.presentation.screens.ScreenName.MOVIE_LIST
import com.tc.cleanmovie.presentation.screens.ScreenName.MOVIE_LIST_HEADER

enum class Screens(
    val route: String,
    val header: String
) {
    MovieList(route = MOVIE_LIST, header = MOVIE_LIST_HEADER),
    MovieDetails(route = MOVIE_DETAILS, header = MOVIE_DETAILS_HEADER),
    FavoriteList(route = FAVORITE_LIST, header = FAVORITE_LIST_HEADER)
}

object ScreenName {
    const val MOVIE_LIST = "movie_list"
    const val MOVIE_LIST_HEADER = "Movie List"
    const val MOVIE_DETAILS = "movie_details"
    const val MOVIE_DETAILS_HEADER = "Movie Details"
    const val FAVORITE_LIST = "favorite_list"
    const val FAVORITE_LIST_HEADER = "Favorite List"

}