package com.example.exambankcompose.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeDashboard (
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    OutlinedTextField(value = "Home Dashboad Screen", onValueChange = {""})

}


@Preview
@Composable
fun PreviewHomeDashBoard () {
    HomeDashboard()
}