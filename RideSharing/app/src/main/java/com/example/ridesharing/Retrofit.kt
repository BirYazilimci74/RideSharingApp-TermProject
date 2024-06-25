package com.example.ridesharing

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    const val BASE_URL = "http://192.168.56.245:8080" // This should be your localhost ID

    private val retrofit: Retrofit by lazy {
        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val rideService: RideService by lazy {
        retrofit.create(RideService::class.java)
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}
