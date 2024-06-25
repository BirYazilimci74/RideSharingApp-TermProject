package com.example.ridesharing

import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

@Serializable
data class Ride(
    val driverName: String,
    val target: String,
    val plate: String,
    val latitude: Double,
    val longitude: Double
)

interface RideService {
    @POST("/add_data")
    fun addRide(@Body ride: Ride): Call<Void>
}

interface ApiService {
    @GET("/read_data")
    suspend fun getRides(@Query("target") target: String): ApiResponseLocation
}

data class ApiResponseLocation(
    val data: List<Ride>?,
    val error: String?
)

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(RetrofitClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}