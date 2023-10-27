package com.tc.cleanmovie.framework.repository.post

import com.tc.cleanmovie.framework.data.model.add_favorite.AddFavoriteModel
import com.tc.cleanmovie.framework.data.model.favorite.FavoriteBody
import com.tc.cleanmovie.framework.remote.ApiEndpoint
import javax.inject.Inject

class RepositoryPostImpl @Inject constructor(
    private val service: ApiEndpoint
): RepositoryPost {
    override suspend fun markAsFavorite(favoriteBody: FavoriteBody): AddFavoriteModel {
        return service.markAsFavorite(favoriteBody)
    }
}