package com.example.applicacionestudio.appjsonconsumer

import com.google.gson.annotations.SerializedName
import retrofit2.http.Url


data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superHeroe: List<SuperHeroItemResponse>
)

data class SuperHeroItemResponse(
    @SerializedName("id") val superHeoId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superHeroImage: superHeroImageResponse
)

data class superHeroImageResponse(@SerializedName("url") val url: String)