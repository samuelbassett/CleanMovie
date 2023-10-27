package com.tc.cleanmovie.framework.data.model.add_favorite


import com.google.gson.annotations.SerializedName

data class AddFavoriteModel(
    @SerializedName("status_code")
    val statusCode: Int? = 0,
    @SerializedName("status_message")
    val statusMessage: String? = ""
)