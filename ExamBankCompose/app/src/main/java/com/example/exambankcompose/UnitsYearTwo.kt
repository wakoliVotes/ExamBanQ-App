package com.example.exambankcompose

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun YearTwoUnits () {
    OutlinedTextField(value = "Year II", onValueChange = {""} )
}


@Preview
@Composable
fun PreviewYearTwo () {
    YearTwoUnits()
}