package com.tc.cleanmovie.framework.repository.get

import com.tc.cleanmovie.framework.data.model.details.DetailsModel
import com.tc.cleanmovie.framework.data.model.favorite.FavoriteModel
import com.tc.cleanmovie.framework.data.model.movie.MovieModel
import com.tc.cleanmovie.framework.remote.ApiEndpoint
import javax.inject.Inject

class RepositoryGetImpl @Inject constructor(
    private val service: ApiEndpoint
): RepositoryGet {
    override suspend fun getMovies(): MovieModel {
        return service.getMovies()
    }

    override suspend fun getMovieDetails(movieId: Int): DetailsModel {
        return service.getMovieDetails(movieId)
    }

    override suspend fun getFavorites(): FavoriteModel {
        return service.getFavorites()
    }
}