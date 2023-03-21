package com.example.exambank.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Papers: BottomBarScreen(
        route = "papers",
        title = "Papers",
        icon = Icons.Default.List
    )
    object Account: BottomBarScreen(
        route = "account",
        title = "Account",
        icon = Icons.Default.Person
    )
}
