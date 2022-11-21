package com.example.exambankcompose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exambankcompose.Routes
import com.example.exambankcompose.SignIn

@Composable
fun ScreenMain(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route )
            {
                composable(route = Routes.Splash.route) {
                    SplashScreen(navController = navController)
                }
                composable(Routes.Login.route) {
                    SignIn(navController = navController)
            }
                composable(Routes.SignUp.route) {
                    SignUp(navController = navController)
                }
                composable(Routes.Home.route) {
                    Box(
                        modifier = androidx.compose.ui.Modifier
                            .fillMaxSize()
                            .fillMaxSize()
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Exam Bank: Welcome to Student Papers", color = Color.Black)
                    }
                }

        composable(Routes.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }
    }
}