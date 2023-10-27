package com.tc.cleanmovie.framework.data.model.details


import com.google.gson.annotations.SerializedName

data class ProductionCompanyModel(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("logo_path")
    val logoPath: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("origin_country")
    val originCountry: String? = ""
)