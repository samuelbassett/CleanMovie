package com.tc.cleanmovie.framework.repository.post

import com.tc.cleanmovie.framework.data.model.add_favorite.AddFavoriteModel
import com.tc.cleanmovie.framework.data.model.favorite.FavoriteBody

interface RepositoryPost {
    suspend fun markAsFavorite(favoriteBody: FavoriteBody): AddFavoriteModel
}