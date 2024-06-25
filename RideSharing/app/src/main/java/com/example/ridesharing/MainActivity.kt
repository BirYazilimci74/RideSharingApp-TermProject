package com.example.ridesharing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ridesharing.ui.theme.RideSharingTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RideSharingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Transition()
                }
            }
        }
    }
}

@Composable
fun Transition()
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "LoginPage")
    {
        composable(route = "LoginPage")
        {
            LoginPage(modifier = Modifier,navController)
        }

        composable(route = "RegisterPage")
        {
            RegisterPage(modifier = Modifier,navController)
        }

        composable(route = "MainPage")
        {
            MainPage(modifier = Modifier,navController)
        }

        composable(route = "SharePage")
        {
            SharePage(modifier = Modifier,navController)
        }

        composable(route = "RideInfoPage")
        {
            //RideInfoPage(modifier = Modifier,navController)
        }

        composable(
            "rideInfoPage/{rideJson}",
            arguments = listOf(navArgument("rideJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val rideJson = backStackEntry.arguments?.getString("rideJson")
            val ride = Gson().fromJson(rideJson, Ride::class.java)
            RideInfoPage(navController = navController, ride = ride)
        }

        composable(route = "RideMap")
        {
            RideMap(modifier = Modifier,navController = navController)
        }

    }
}