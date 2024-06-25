package com.example.ridesharing

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(modifier: Modifier = Modifier,navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xff5356ff))
    ) {

        //LoginButton
        Box(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .offset(
                    x = 0.dp,
                    y = 250.dp
                )
                .clickable(onClick =
                {
                    //navController.navigate("Map")
                    navController.navigate("MainPage")
                })
                .requiredWidth(width = 300.dp)
                .requiredHeight(height = 58.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = Color(0xff97e7e1))
        ){
            Text(
                text = "Login",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    shadow = Shadow(color = Color.Black.copy(alpha = 0.25f), offset = Offset(0f, 4f), blurRadius = 4f)),
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .fillMaxSize()
                    .wrapContentHeight(align = Alignment.CenterVertically))
        }

        Column(modifier = Modifier
            .align(Alignment.Center)
        ) {
            //---------------------------E-Mail--------------------------
            Box(
                modifier = Modifier
                    .requiredWidth(width = 328.dp)
                    .requiredHeight(height = 50.dp)
                    .clip(shape = RoundedCornerShape(74.dp))
                    .background(color = Color.White)
            ){
                var (email, setEmail) = remember { mutableStateOf("")}
                TextField(
                    value = email,
                    onValueChange = { setEmail(it) },
                    placeholder = {
                        Text(
                            text = "E-Mail",
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
                        .align(alignment = Alignment.Center)
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically))
            }

            Spacer(modifier = Modifier.requiredHeight(20.dp))

            //-------------------------Password---------------------------
            Box(
                modifier = Modifier
                    .requiredWidth(width = 328.dp)
                    .requiredHeight(height = 50.dp)
                    .clip(shape = RoundedCornerShape(74.dp))
                    .background(color = Color.White)
            ){
                var (password, setPassword) = remember { mutableStateOf("")}
                TextField(
                    value = password,
                    onValueChange = { setPassword(it) },
                    placeholder = {
                        Text(
                            text = "Password",
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
                        .align(alignment = Alignment.TopStart)
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                )
            }

            //----------------Don't have an account-------------------
            Text(
                text = "Don’t have an account?",
                color = Color.White,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.End,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .clickable(
                        onClick = { navController.navigate("RegisterPage") }
                    )
                    .offset(-10.dp)
                    .requiredWidth(width = 328.dp)
                    .requiredHeight(height = 20.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
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

    }
}

@Preview
@Composable
private fun LoginPagePreview() {
    LoginPage(Modifier, rememberNavController())
}