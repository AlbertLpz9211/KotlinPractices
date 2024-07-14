package com.example.applicacionestudio.appjsonconsumer

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/61ef43f487da5bb25da807deb5e253c5/search/{name}")
    suspend fun getSuperheroes(@Path("name") superHeroName: String): Response<SuperHeroDataResponse>

    @GET("/api/61ef43f487da5bb25da807deb5e253c5/{id}")
    suspend fun getSuperHeroDetail(@Path("id") superHeroId: String)
}