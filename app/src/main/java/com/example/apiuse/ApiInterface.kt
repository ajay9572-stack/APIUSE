package com.example.apiuse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String, // e.g., "US"
        @Query("lang") language: String,   // e.g., "en"
        @Query("limit") limit: Int,        // e.g., 500
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") apiHost: String
    ): Call <MyData> // Use NewsResponse instead of MyData
}