package com.tc.cleanmovie.framework.repository.get

import com.tc.cleanmovie.framework.data.model.details.DetailsModel
import com.tc.cleanmovie.framework.data.model.favorite.FavoriteModel
import com.tc.cleanmovie.framework.data.model.movie.MovieModel

interface RepositoryGet {
    suspend fun getMovies(): MovieModel

    suspend fun getMovieDetails(movieId: Int): DetailsModel

    suspend fun getFavorites(): FavoriteModel
}