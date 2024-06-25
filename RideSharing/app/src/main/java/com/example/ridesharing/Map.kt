package com.example.ridesharing

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun RideMap(modifier: Modifier = Modifier,navController: NavController, viewModel: RideViewModel = viewModel()) {

    var selectedDistrict by remember { mutableStateOf("Direction") }
    var header by remember { mutableStateOf("Rides") }
    var expanded by remember { mutableStateOf(false) }
    val rideLocations by viewModel.rideLocations
    val istanbulDistricts = listOf(
        "Adalar", "Arnavutköy", "Ataşehir", "Avcılar", "Bağcılar", "Bahçelievler",
        "Bakırköy", "Başakşehir", "Bayrampaşa", "Beşiktaş", "Beykoz", "Beylikdüzü",
        "Beyoğlu", "Büyükçekmece", "Çatalca", "Çekmeköy", "Esenler", "Esenyurt",
        "Eyüpsultan", "Fatih", "Gaziosmanpaşa", "Güngören", "Kadıköy", "Kağıthane",
        "Kartal", "Küçükçekmece", "Maltepe", "Pendik", "Sancaktepe", "Sarıyer",
        "Silivri", "Sultanbeyli", "Sultangazi", "Şile", "Şişli", "Tuzla",
        "Ümraniye", "Üsküdar", "Zeytinburnu"
    )


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xff5356ff))
    ) {
        //---------------------------Back----------------------------------------
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "Back",
            modifier = Modifier
                .requiredSize(20.dp, 40.dp)
                .offset(20.dp, 90.dp)
                .clickable(
                    onClick = { navController.navigate("MainPage") }
                )
        )

        //-------------------------------Header----------------------------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(height = 74.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
                .background(color = Color(0xffdff5ff))
        ) {
            Text(
                text = header,
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .requiredWidth(width = 360.dp)
                    .requiredHeight(height = 56.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }


        Box(
            modifier = Modifier
                .requiredSize(400.dp, 600.dp)
                .align(Alignment.Center)
                .offset(y = 30.dp)
        )
        {
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(LatLng(41.0, 29.0), 10f)
            }

            GoogleMap(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(0.dp, 25.dp),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(isMyLocationEnabled = true)
            ) {
                // Show markers for each ride
                rideLocations.forEach { ride ->
                    Marker(
                        state = MarkerState(position = LatLng(ride.latitude, ride.longitude)),
                        title = ride.driverName,
                        snippet = ride.plate,
                        onInfoWindowClick = {
                            val rideJson = Gson().toJson(ride)
                            navController.navigate("rideInfoPage/$rideJson")
                        }
                    )
                }
            }

            //-------------------------SearchBar-------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                Box {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(50.dp)
                            .clip(shape = RoundedCornerShape(74.dp)),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .clickable { expanded = true }
                                .fillMaxWidth()
                                .background(color = Color(0xff97e7e1)))
                        {
                            Text(
                                text = selectedDistrict,
                                color = Color.Black.copy(alpha = 0.5f),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .requiredHeight(50.dp)
                                    .wrapContentHeight(align = Alignment.CenterVertically)
                                    .offset(15.dp)
                            )
                        }
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        istanbulDistricts.forEach { district ->
                            DropdownMenuItem(
                                text = { Text(district) },
                                onClick = {
                                    selectedDistrict = district
                                    expanded = false
                                    viewModel.fetchRides(district)
                                }
                            )
                        }
                    }
                    //------------------Search Icon----------------------------
                    Box(
                        modifier = Modifier
                            .requiredSize(size = 50.dp)
                            .clip(shape = RoundedCornerShape(74.dp))
                            .background(color = Color(0xff26847d))
                            .align(Alignment.CenterEnd)
                            .clickable {
                                // todo: Searching
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = "Search",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .requiredSize(35.dp, 35.dp)
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun MapPreview() {
    RideMap(modifier = Modifier,rememberNavController())
}
