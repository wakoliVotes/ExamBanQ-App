package com.example.exambankcompose.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exambankcompose.Routes
import com.example.exambankcompose.SignIn

@Composable
fun ScreenMain(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route ) {
        composable(Routes.Login.route) {
            SignIn(navController = navController)
        }
        composable(Routes.SignUp.route) {
            SignUp(navController = navController)
        }

//        composable(Routes.ForgotPassword.route) {navBackStack ->
//            Routes.ForgotPassword
//        }
    }
}