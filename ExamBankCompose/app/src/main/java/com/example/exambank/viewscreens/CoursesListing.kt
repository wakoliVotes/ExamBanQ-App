package com.example.exambank.viewscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exambank.modeldatautils.CourseList
import com.example.exambank.modeldatautils.TrimesterOneData
import com.example.exambank.modeldatautils.TrimesterThreeData
import com.example.exambank.modeldatautils.TrimesterTwoData
import com.example.exambank.R

@Composable
fun CoursesListing() {
    Column {
        // TRIMESTER 1
        LazyColumn {
            item {
                Text(
                    text = "Trimester One",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                )
            }
            items(TrimesterOneData.unitTriOneList.size) {
                TrimesterTemplate(TrimesterOneData.unitTriOneList[it])
            }
        // TRIMESTER 2
            item {
                Text(
                    text = "Trimester Two",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                )
            }
            items(TrimesterTwoData.unitTwoList.size) {
                TrimesterTemplate(TrimesterTwoData.unitTwoList[it])
            }
        // TRIMESTER 3
            item {
                Text(
                    text = "Trimester Three",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                )
            }
            items(TrimesterThreeData.unitTriList.size) {
                TrimesterTemplate(TrimesterThreeData.unitTriList[it])
            }
        }
    }
}

@Composable
fun TrimesterTemplate(courseList: CourseList) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .height(25.dp)
            .background(color = Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 2.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "user icon",
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .align(CenterVertically)
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .align(CenterVertically),
                text = courseList.unitCodeAndName,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}


@Composable
fun TrimesterNoTemplate(){
    Text(text = "Trimester")
    
}


@Composable
@Preview
fun PreviewCoursesListing() {
    CoursesListing()
}