package com.example.ridesharing

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

fun sendRideData(scope: CoroutineScope, ride: Ride, onSuccess: () -> Unit, onError: (String) -> Unit) {
    scope.launch(Dispatchers.IO) {
        try {
            val response = RetrofitClient.rideService.addRide(ride).execute()
            if (response.isSuccessful) {
                onSuccess()
            } else {
                onError(response.errorBody()?.string() ?: "Unknown error")
            }
        } catch (e: HttpException) {
            onError(e.message())
        } catch (e: Exception) {
            onError(e.message ?: "An error occurred")
        }
    }
}

