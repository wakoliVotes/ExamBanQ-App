package com.example.exambankcompose

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun YearThree () {
    OutlinedTextField(value = "Year III", onValueChange = {""} )
}


@Preview
@Composable
fun PreviewYearThree () {
    YearThree()
}