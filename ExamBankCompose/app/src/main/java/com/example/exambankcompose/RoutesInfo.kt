package com.example.exambankcompose

sealed class RoutesInfo( val route: String) {
    object Login: RoutesInfo("Login")
    object SignUp: RoutesInfo("SignUp")
}
