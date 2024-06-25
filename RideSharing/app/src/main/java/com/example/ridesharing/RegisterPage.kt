package com.example.ridesharing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(modifier: Modifier = Modifier,navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xff5356ff))
    ) {

        //RegisterButton
        Box(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .offset(
                    x = 0.dp,
                    y = 250.dp
                )
                .clickable { navController.navigate("LoginPage")}
                .requiredWidth(width = 300.dp)
                .requiredHeight(height = 58.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = Color(0xff97e7e1))
        ){
            Text(
                text = "Register",
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
            //---------------------Name-----------------------------------
            Box(
                modifier = Modifier
                    .requiredWidth(width = 328.dp)
                    .requiredHeight(height = 50.dp)
                    .clip(shape = RoundedCornerShape(74.dp))
            ){
                var (name, setName) = remember { mutableStateOf("") }
                TextField(
                    value = name,
                    onValueChange = { setName(it) }, // Use setName for clarity
                    placeholder = { Text(text = "Name") }, // Use lambda for conciseness
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    ),
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }

            Spacer(modifier = Modifier.requiredHeight(15.dp))

            //---------------------E-Mail---------------------------------
            Box(
                modifier = Modifier
                    .requiredWidth(width = 328.dp)
                    .requiredHeight(height = 50.dp)
                    .clip(shape = RoundedCornerShape(74.dp))
            ){
                var (mail, setMail) = remember { mutableStateOf("") }
                TextField(
                    value = mail,
                    onValueChange = { setMail(it) }, // Use setName for clarity
                    placeholder = { Text(text = "E-Mail") }, // Use lambda for conciseness
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    ),
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )}

            Spacer(modifier = Modifier.requiredHeight(15.dp))

            Row (
                modifier = Modifier
                .requiredHeight(50.dp)
                .requiredWidth(328.dp)
            ){
                //----------------------PhoneCountry------------------------
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 92.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(74.dp))
                        .background(color = Color.White)
                ){Text(
                    text = "+90   ",
                    color = Color.Black.copy(alpha = 0.5f),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.CenterStart)
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically))}

                Spacer(modifier = Modifier.requiredWidth(8.dp))

                //--------------------Phone---------------------------
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 230.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(74.dp))
                ){
                    var (phone, setPhone) = remember { mutableStateOf("") }
                    TextField(
                        value = phone,
                        onValueChange = { setPhone(it) },
                        placeholder = { Text(text = "Phone") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White
                        ),
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black.copy(alpha = 0.5f)
                        ),
                        modifier = Modifier
                            .align(alignment = Alignment.Center)
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )}
            }

            Spacer(modifier = Modifier.requiredHeight(15.dp))

            //------------------------Password----------------------------
            Box(
                modifier = Modifier
                    .requiredWidth(width = 328.dp)
                    .requiredHeight(height = 50.dp)
                    .clip(shape = RoundedCornerShape(74.dp))
            ){
                var (password, setPassword) = remember { mutableStateOf("") }
                TextField(
                    value = password,
                    onValueChange = { setPassword(it) }, // Use setName for clarity
                    placeholder = { Text(text = "Password") }, // Use lambda for conciseness
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    ),
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )}

            Spacer(modifier = Modifier.requiredHeight(15.dp))

            //---------------------Password(Confirm)------------------------
            Box(
                modifier = Modifier
                    .requiredWidth(width = 328.dp)
                    .requiredHeight(height = 50.dp)
                    .clip(shape = RoundedCornerShape(74.dp))
            ){
                var (passwordCon, setPasswordCon) = remember { mutableStateOf("") }
                TextField(
                    value = passwordCon,
                    onValueChange = { setPasswordCon(it) }, // Use setName for clarity
                    placeholder = { Text(text = "Password(Confirm)") }, // Use lambda for conciseness
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    ),
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
        }

        //-------------------Header-------------------------------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                //.requiredWidth(width = 360.dp)
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
            painter = painterResource(id = R.drawable.back),
            contentDescription = "Back",
            modifier = Modifier
                .requiredSize(20.dp, 40.dp)
                .offset(20.dp, 90.dp)
                .clickable (
                    onClick = { navController.navigate("LoginPage")}
                )
        )
    }
}

@Preview
@Composable
private fun RegisterPagePreview() {
    RegisterPage(Modifier, rememberNavController())
}