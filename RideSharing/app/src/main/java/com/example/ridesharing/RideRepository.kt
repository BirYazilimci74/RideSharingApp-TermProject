package com.example.ridesharing

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RideRepository {
    private val apiService = RetrofitInstance.api

    suspend fun fetchRides(target: String): List<Ride>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getRides(target)
                response.data
            } catch (e: Exception) {
                null
            }
        }
    }
}
