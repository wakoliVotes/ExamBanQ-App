package com.example.exambankcompose.screen

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.exambankcompose.Routes

@Composable
fun ForgotPassword() {
    OutlinedTextField(
        value = "Reset the Password",
        onValueChange = {""}
    )
}



@Preview
@Composable
fun PreviewForgotPassword () {
    ForgotPassword()
}