package com.example.exambankcompose.uiscreens

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
import com.example.exambankcompose.R
import com.example.exambankcompose.data.CourseList
import com.example.exambankcompose.data.TrimesterOneData
import com.example.exambankcompose.data.TrimesterThreeData
import com.example.exambankcompose.data.TrimesterTwoData

@Composable
fun CoursesListing() {
    Column() {
        // TRIMESTER 1
        LazyColumn {
            item {
                Text(
                    text = "Trimester One",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }
            items(TrimesterOneData.unitTriOneList.size) {
                TrimesterOneCards(TrimesterOneData.unitTriOneList[it])
            }
        }
        // TRIMESTER 2
        LazyColumn {
            item {
                Text(
                    text = "Trimester Two",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }
            items(TrimesterTwoData.unitTwoList.size) {
                TrimesterTwoCards(TrimesterTwoData.unitTwoList[it])
            }
        }
        // TRIMESTER 3
        LazyColumn {
            item {
                Text(
                    text = "Trimester Three",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }
            items(TrimesterThreeData.unitTriList.size) {
                    TrimesterThreeCards(TrimesterThreeData.unitTriList[it])
            }
        }
    }
}


@Composable
fun TrimesterOneCards(courseList: CourseList) {
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

// TRIMESTER TWO UNITS
@Composable
fun TrimesterTwoCards(courseList: CourseList) {
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
// TRIMESTER THREE UNITS

@Composable
fun TrimesterThreeCards(courseList: CourseList) {
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
                fontSize = 16.sp
            )
        }
    }
}

@Composable
@Preview
fun PreviewCoursesListing() {
    CoursesListing()
}