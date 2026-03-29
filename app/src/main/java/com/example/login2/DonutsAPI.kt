package com.example.login2

import retrofit2.http.GET

interface DonutsAPI {
    @GET(value = "donuts")
    suspend fun getDonuts(): List<Donut>
}