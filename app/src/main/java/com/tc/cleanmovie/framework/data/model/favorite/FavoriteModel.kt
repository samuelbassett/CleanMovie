package com.tc.cleanmovie.framework.data.model.favorite


import com.google.gson.annotations.SerializedName

data class FavoriteModel(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<FavoriteItemModel?>? = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)