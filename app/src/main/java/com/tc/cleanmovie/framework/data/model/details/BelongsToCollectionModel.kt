package com.tc.cleanmovie.framework.data.model.details


import com.google.gson.annotations.SerializedName

data class BelongsToCollectionModel(
    @SerializedName("backdrop_path")
    val backdropPath: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("poster_path")
    val posterPath: String? = ""
)