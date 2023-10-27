package com.tc.cleanmovie.framework.data.model.favorite

data class FavoriteBody(
    val media_type: String,
    val media_id: Int,
    val favorite: Boolean
)