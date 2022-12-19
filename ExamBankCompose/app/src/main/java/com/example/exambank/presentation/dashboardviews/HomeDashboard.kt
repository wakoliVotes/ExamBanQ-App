package com.example.exambank.presentation.dashboardviews

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exambank.R
import com.example.exambank.datalayer.models.AcademicCalendar
import com.example.exambank.datalayer.models.AcademicCalendarData
import com.example.exambank.datalayer.models.AcademicCalendarData.academicList
import com.example.exambank.datalayer.models.Years
import com.example.exambank.datalayer.models.YearsData
import com.example.exambank.ui.theme.paleBlack
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun HomeDashboard(
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(YearsData.list.size) {
            YearsCard(YearsData.list[it])
        }

    }
}


@Preview
@Composable
private fun TopItems() {
    // Header
    // Search
    //
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(40.dp)
        ) {
            Text(
                text = "Browse",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            Image(painter = painterResource(id = R.drawable.workspaces),
                contentDescription = "workspaces"
            )

        }
    }
}

@Preview
@Composable
private fun WelcomeBanner(
//    imagePainter: Painter,
//    title: String = "",
//    price: String = "",
) {
    Column(modifier = Modifier
        .padding(10.dp)
        .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Start Revising \nOn the Go",
                    modifier = Modifier
                        .padding(start = 10.dp, bottom = 40.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.kcau_logo),
                    contentDescription = null,
                    modifier = Modifier.height(30.dp)
                )

            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clickable { },
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Exam Bank", color = paleBlack
                )
                Text(text = "Home of Best Materials", fontWeight = FontWeight.Bold)
            }
        }
        Box(
            modifier = Modifier
                .offset(140.dp, (-190).dp)
                .height(140.dp)
                .clip(CircleShape)

        ) {
            Image(
                contentScale = ContentScale.Fit,
                painter = painterResource(id = R.drawable.owner),
                contentDescription = "",

                )
        }
        // Call to Action
        Column(
            modifier = Modifier.padding(top = 0.dp)
        ) {
            Text(
                text = "*Explore\n *Learn\n   *Grow",
                fontWeight = FontWeight.W900,
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .offset(100.dp, (-100).dp)
            )
            Row(
                modifier = Modifier.offset(20.dp, (-80).dp),
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(120.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color.Red),
                )

                {
                    Text(
                        text = "Third",
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        ),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(160.dp)
                        .width(140.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = Color.DarkGray)
                )
                {
                    Text(
                        text = "Fourth",
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        ),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(160.dp)
                        .width(140.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = Color.DarkGray)
                )
                {
                    Text(
                        text = "Fourth",
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        ),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}


// MAIN / TOP ITEMS / CORE ITEMS


// CATEGORIES


// TODO
@Composable
fun CategoryItemsList(academicList: List<AcademicCalendar>) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        academicList.forEach { student ->
            AcademicCalendarRow(student)
        }
    }
}

@Composable
fun AcademicCalendarRow(academicCalendar: AcademicCalendar) {
    Card(
        modifier = Modifier
            .padding(all = 10.dp)
            .width(175.dp)
            .clip(RoundedCornerShape(20.dp, 8.dp)),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .padding(all = 8.dp),
//            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.owner),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .offset(70.dp, (18).dp)
                    .clip(CircleShape),
            )
            Text(
                text = academicCalendar.academicPeriodYear,
                fontSize = 18.sp,
                fontWeight = FontWeight.W700,
                modifier = Modifier.padding(top = 5.dp),
            )
            Text(
                text = academicCalendar.academicMonths,
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                modifier = Modifier.padding(),
                color = Color.Gray
            )
            Text(
                text = academicCalendar.itsStatus,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier
                    .padding()
                    .align(Alignment.End),
                style = TextStyle(
                    color = Color.Blue
                )
            )
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
fun HomePreview() {
    HomeDashboard()
}

@Composable
@Preview
fun AcademicCalPreview() {
    CategoryItemsList(academicList)
}