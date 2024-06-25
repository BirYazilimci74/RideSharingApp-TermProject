package com.example.ridesharing

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RideViewModel : ViewModel() {
    private val repository = RideRepository()
    private val _rideLocations = mutableStateOf<List<Ride>>(emptyList())
    val rideLocations: State<List<Ride>> get() = _rideLocations

    fun fetchRides(target: String) {
        viewModelScope.launch {
            val rides = repository.fetchRides(target)
            _rideLocations.value = rides ?: emptyList()
        }
    }
}
