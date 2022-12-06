package com.example.exambankcompose.navigation

sealed class Routes( val route: String) {
    object Splash: Routes("Splash_screen")
    object Login: Routes("Login")
    object SignUp: Routes("SignUp")
    object ForgotPassword: Routes("ForgotPassword")
    object Home : Routes("Home_Screen")
    object FullExamPaper: Routes("FullExamPaper")
    object CourseListing: Routes("CourseListing")
}