package com.example.ridesharing

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RideInfoPage(modifier: Modifier = Modifier,navController: NavController, ride: Ride) {
    val scope = rememberCoroutineScope()
    var snackbarHostState = remember {
        SnackbarHostState()
    }

    Scaffold (
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ){
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color(0xff5356ff))
        ) {
            //-----------------------------------Header----------------------------------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(height = 74.dp)
                    .clip(shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
                    .background(color = Color(0xffdff5ff))
            ){
                Text(
                    text = "Ride Info",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically))
            }

            //-----------------------RideInfos--------------------------------
            Column (
                modifier = Modifier
                    .align(Alignment.Center)
                    .requiredWidth(width = 328.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(74.dp))
                        .background(color = Color.White)
                ){
                    Text(
                        text = "  " + ride.driverName,
                        color = Color.Black.copy(alpha = 0.5f),
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically))
                }

                Spacer(modifier = Modifier.requiredHeight(15.dp))

                Box(
                    modifier = Modifier
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(74.dp))
                        .background(color = Color.White)
                ){
                    Text(
                        text = "  " + ride.target,
                        color = Color.Black.copy(alpha = 0.5f),
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically))
                }

                Spacer(modifier = Modifier.requiredHeight(15.dp))

                Box(
                    modifier = Modifier
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(74.dp))
                        .background(color = Color.White)
                ){
                    Text(
                        text = "  " + ride.plate,
                        color = Color.Black.copy(alpha = 0.5f),
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically))
                }
            }

            Column (
                modifier = Modifier
                    .requiredWidth(width = 300.dp)
                    .align(alignment = Alignment.TopCenter)
                    .offset(0.dp, 583.dp)
            ){
                //----------------------------Send Request Button---------------------------
                Box(
                    modifier = Modifier
                        .requiredHeight(height = 60.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color(0xff97e7e1))
                        .clickable(
                            onClick = {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Request is Sended")
                                }
                                navController.navigate("MainPage")
                            }
                        )
                ){
                    Text(
                        text = "Send Request",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            shadow = Shadow(color = Color.Black.copy(alpha = 0.25f), offset = Offset(0f, 4f), blurRadius = 4f)
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically))
                }

                Spacer(modifier = Modifier.requiredHeight(25.dp))

                //-------------------------------Cancel Button------------------------------
                Box(
                    modifier = Modifier
                        .requiredHeight(height = 60.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color(0xffdc2d2d))
                        .clickable(onClick = { navController.popBackStack()})
                ){
                    Text(
                        text = "Cancel",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            shadow = Shadow(color = Color.Black.copy(alpha = 0.25f), offset = Offset(0f, 4f), blurRadius = 4f)
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically))
                }
            }

        }
    }
}

@Preview
@Composable
private fun RideInfoPagePreview() {
    RideInfoPage(Modifier, rememberNavController(),ride = Ride("Yahya","Pendik","34 BJS 017",40.0,29.0))
}