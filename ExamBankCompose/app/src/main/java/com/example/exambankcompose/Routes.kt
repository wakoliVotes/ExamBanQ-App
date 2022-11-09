package com.example.exambankcompose

sealed class Routes( val route: String) {
    object Login: Routes("Login")
    object SignUp: Routes("SignUp")
    object ForgotPassword: Routes("ForgotPassword")
}
