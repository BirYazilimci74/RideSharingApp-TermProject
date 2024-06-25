package com.example.ridesharing

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharePage(modifier: Modifier = Modifier,navController: NavController) {

    var (plate, setPlate) = remember { mutableStateOf("")}
    var (driverName, setDriverName) = remember { mutableStateOf("")}

    val coroutineScope = rememberCoroutineScope()

    var selectedDistrict by remember { mutableStateOf("Direction") }
    var expanded by remember { mutableStateOf(false) }
    val istanbulDistricts = listOf(
        "Adalar", "Arnavutköy", "Ataşehir", "Avcılar", "Bağcılar", "Bahçelievler",
        "Bakırköy", "Başakşehir", "Bayrampaşa", "Beşiktaş", "Beykoz", "Beylikdüzü",
        "Beyoğlu", "Büyükçekmece", "Çatalca", "Çekmeköy", "Esenler", "Esenyurt",
        "Eyüpsultan", "Fatih", "Gaziosmanpaşa", "Güngören", "Kadıköy", "Kağıthane",
        "Kartal", "Küçükçekmece", "Maltepe", "Pendik", "Sancaktepe", "Sarıyer",
        "Silivri", "Sultanbeyli", "Sultangazi", "Şile", "Şişli", "Tuzla",
        "Ümraniye", "Üsküdar", "Zeytinburnu"
    )

    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    var currentLocation by remember { mutableStateOf<Pair<Double, Double>?>(null) }

    // Request location permissions
    val locationPermissionRequest = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true) {
            getCurrentLocation(fusedLocationClient) { location ->
                currentLocation = location
            }
        }
    }

    LaunchedEffect(Unit) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            locationPermissionRequest.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        } else {
            getCurrentLocation(fusedLocationClient) { location ->
                currentLocation = location
            }
        }
    }


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xff5356ff))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(height = 74.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
                .background(color = Color(0xffdff5ff))
        ){Text(
            text = "Share",
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .fillMaxSize()
                .wrapContentHeight(align = Alignment.CenterVertically))}

        Column (
            modifier = Modifier
                .align(Alignment.Center)
        ){
            TextField(
                value = driverName,
                onValueChange = { setDriverName(it) },
                placeholder = {
                    Text(
                        text = "Driver Name",
                        color = Color.Black.copy(alpha = 0.5f),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .requiredHeight(50.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black.copy(alpha = 0.5f)
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White),
                modifier = Modifier
                    .requiredWidth(328.dp)
                    .requiredHeight(50.dp)
                    .clip(shape = RoundedCornerShape(74.dp))
            )

            Spacer(modifier = Modifier.requiredHeight(10.dp))

            TextField(
                value = plate,
                onValueChange = { setPlate(it) },
                placeholder = {
                    Text(
                        text = "Plate",
                        color = Color.Black.copy(alpha = 0.5f),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .requiredHeight(50.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black.copy(alpha = 0.5f)
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White),
                modifier = Modifier
                    .requiredWidth(328.dp)
                    .requiredHeight(50.dp)
                    .clip(shape = RoundedCornerShape(74.dp))
            )

            Spacer(modifier = Modifier.requiredHeight(10.dp))



            Box{
                Row (
                    modifier = Modifier
                        .requiredWidth(328.dp)
                        .requiredHeight(50.dp)
                        .clip(shape = RoundedCornerShape(74.dp)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Box(
                        modifier = Modifier
                            .clickable { expanded = true }
                            .fillMaxWidth()
                            .background(color = Color.White))
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
                            }
                        )
                    }
                }
            }
        }

        Button(
            onClick = {
                //-----------------Sending ride data to db----------------------
                val location = currentLocation
                if (location != null) {
                    val (latitude, longitude) = location
                    val ride = Ride(driverName = driverName, target = selectedDistrict, plate = plate, latitude = latitude, longitude = longitude)
                    sendRideData(
                        coroutineScope,
                        ride,
                        onSuccess = {
                            // Handle success
                        },
                        onError = { error ->
                            println("Error: $error")
                        }
                    )
                    navController.navigate("MainPage")
                } else {
                    // Handle the case where location is not available
                    println("Location not available")
                }
                //---------------------------------------------------------------

            },
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff97e7e1)),
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .offset(0.dp, 250.dp)
                .requiredWidth(width = 300.dp)
                .requiredHeight(height = 58.dp)
        ){Text(
            text = "Share",
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                shadow = Shadow(color = Color.Black.copy(alpha = 0.25f), offset = Offset(0f, 4f), blurRadius = 4f)),
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(align = Alignment.CenterVertically))}

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
    }
}

@SuppressLint("MissingPermission")
private fun getCurrentLocation(fusedLocationClient: FusedLocationProviderClient, onLocationReceived: (Pair<Double, Double>) -> Unit) {
    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
        location?.let {
            onLocationReceived(it.latitude to it.longitude)
        }
    }
}


@Preview
@Composable
private fun SharePagePreview() {
    SharePage(Modifier, rememberNavController())
}
