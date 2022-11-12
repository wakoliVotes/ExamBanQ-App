package com.example.exambankcompose

sealed class Routes( val route: String) {
    object Splash: Routes ("Splash_screen")
    object Home : Routes("Home_Screen")
    object Login: Routes("Login")
    object SignUp: Routes("SignUp")
    object ForgotPassword: Routes("ForgotPassword")
}
