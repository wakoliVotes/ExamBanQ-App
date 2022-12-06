package com.example.exambankcompose.datautils

import android.graphics.Color
import androidx.annotation.DrawableRes

data class Course (
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
    )