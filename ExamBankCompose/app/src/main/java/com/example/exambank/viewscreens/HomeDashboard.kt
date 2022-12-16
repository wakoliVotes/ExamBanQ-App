package com.example.exambank.viewscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.exambank.modeldatautils.Years
import com.example.exambank.modeldatautils.YearsData
import com.example.exambank.R
import com.example.exambank.common.CustomTopAppBar


@Composable
fun HomeDashboard (
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(YearsData.list.size) {
            YearsCard(YearsData.list[it])
        }
    }
}

@Composable
private fun YearsCard(years: Years) {
    Card(
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(10.dp)
            .width(150.dp)
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = years.image),
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(4.dp))
            )
            Row(modifier = Modifier.padding(top = 20.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = years.studentYear,
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                    )
                    Text(
                        text = years.paperAvailable,
                        style = TextStyle(
                            color = MaterialTheme.colors.primaryVariant,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                    )
                }
//                Box(
//                    modifier = Modifier.background(
//                        color = MaterialTheme.colors.primaryVariant,
//                        shape = RoundedCornerShape(10.dp)
//                )
//                ){
//                    Icon(
//                        Icons.Filled.ArrowForward,
//                        tint = Color.White,
//                        modifier = Modifier
//                            .padding(10.dp)
//                            .height(14.dp)
//                        ,
//                        contentDescription = null)
//                }
            }
        }
    }
}

@Composable
@Preview
fun HomePreview(){
    HomeDashboard()
}