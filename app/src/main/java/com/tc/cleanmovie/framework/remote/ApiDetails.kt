package com.tc.cleanmovie.framework.remote

object ApiDetails {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val MOVIE_ENDPOINT = "movie/popular?language=en-US&page=1"
    const val MOVIE_DETAILS_ENDPOINT = "movie/{movieId}"
    const val ADD_FAVORITE_ENDPOINT = "account/20625809/favorite"
    const val FAVORITE_ENDPOINT = "account/20625809/favorite/movies?language=en-US&page=1&sort_by=created_at.asc"
    const val API_KEY = "9e8e0dbc690683d9b63c3764c3344194"
    const val API_BEARER = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZThlMGRiYzY5MDY4M2Q5YjYzYzM3NjRjMzM0NDE5NCIsInN1YiI6IjY1M2E4NzA1ZWM0NTUyMDE0ZDZlZGY1NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.79SPr7VjoFTYWR_x24INuL-oO7U2uRHvH1qqhoZUcSo"
}