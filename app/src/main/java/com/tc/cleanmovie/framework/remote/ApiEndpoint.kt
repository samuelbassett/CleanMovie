package com.tc.cleanmovie.framework.remote

import com.tc.cleanmovie.framework.data.model.add_favorite.AddFavoriteModel
import com.tc.cleanmovie.framework.data.model.details.DetailsModel
import com.tc.cleanmovie.framework.data.model.favorite.FavoriteBody
import com.tc.cleanmovie.framework.data.model.favorite.FavoriteModel
import com.tc.cleanmovie.framework.data.model.movie.MovieModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiEndpoint {
    @GET(ApiDetails.MOVIE_ENDPOINT)
    suspend fun getMovies(
    ): MovieModel

    @GET(ApiDetails.MOVIE_DETAILS_ENDPOINT)
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int
    ): DetailsModel

    @GET(ApiDetails.FAVORITE_ENDPOINT)
    suspend fun getFavorites(
    ): FavoriteModel

    @POST(ApiDetails.ADD_FAVORITE_ENDPOINT)
    suspend fun markAsFavorite(
        @Body favoriteBody: FavoriteBody
    ): AddFavoriteModel

}