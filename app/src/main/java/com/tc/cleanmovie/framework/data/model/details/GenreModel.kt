package com.tc.cleanmovie.framework.data.model.details


import com.google.gson.annotations.SerializedName

data class GenreModel(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
)