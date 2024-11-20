package com.example.apiuse

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getProduct(): Call<MyData?>
}