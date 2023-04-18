package com.anchormiles.exambank.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CustomTopAppBar (navController: NavController, title: String, showBackIcon: Boolean){
    val navController = rememberNavController()
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = if (showBackIcon && navController.previousBackStackEntry != null){
            {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack ,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            null
        })
}

@Preview
@Composable
fun PreviewTopBar(){
    CustomTopAppBar(navController = rememberNavController(), title = "Back", showBackIcon = true)

}