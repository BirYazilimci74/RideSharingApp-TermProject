package com.example.ridesharing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun MainPage(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xff5356ff))
    ) {

        Column(modifier = Modifier
            .align(Alignment.Center)
        ) {

            //------------------------------Ride----------------------------------------
            Button(
                onClick = { //navController.navigate("RidePage")
                          navController.navigate("RideMap")},
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff97e7e1)),
                modifier = Modifier
                    .requiredWidth(width = 183.dp)
                    .requiredHeight(height = 56.dp)
            ){
                Text(
                    text = "Ride",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }

            Spacer(modifier = Modifier.requiredHeight(20.dp))

            //------------------------------------Share-------------------------------------
            Button(
                onClick = { navController.navigate("SharePage")},
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff97e7e1)),
                modifier = Modifier
                    .requiredWidth(width = 183.dp)
                    .requiredHeight(height = 56.dp)
            ){
                Text(
                    text = "Share",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
        }

        //-------------------Header-------------------------------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(height = 74.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
                .background(color = Color(0xffdff5ff))
        ){
            Text(
                text = "Ride-Sharing",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .fillMaxSize()
                    .wrapContentHeight(align = Alignment.CenterVertically))
        }

        Image(
            painter = painterResource(id = R.drawable.logout),
            contentDescription = "Back",
            modifier = Modifier
                .requiredSize(40.dp, 80.dp)
                .align(Alignment.TopEnd)
                .offset(-20.dp, 90.dp)
                .clickable(
                    onClick = { navController.navigate("LoginPage") }
                ))
    }
}

@Preview
@Composable
private fun MainPagePreview() {
    MainPage(Modifier, rememberNavController())
}