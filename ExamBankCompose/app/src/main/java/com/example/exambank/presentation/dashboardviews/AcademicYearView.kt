package com.example.exambank.presentation.dashboardviews

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.exambank.R
import com.example.exambank.ui.theme.water
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun AcademicYearView(
    navController: NavHostController,
) {
    FlowRow(
        modifier = Modifier
            .background(water)
        .verticalScroll(rememberScrollState())  // allow scrolling
    ) {
        // Top Item
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
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
                        fontSize = 18.sp
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.workspaces),
                    contentDescription = "workspaces",
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                        .background(Color.White)
                        .padding(5.dp)
                        .clip(CircleShape)
                        .clickable {
                            navController.navigate("Account")
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Academic Year Cards
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
            .clip(RoundedCornerShape(8.dp))
                .clickable {
                           navController.navigate("FullExamPaper")
                }
            ,
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.owner),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2018",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Sept - Dec",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Active",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2022",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Sept - Dec",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2022",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "May - Aug",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2022",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Jan - March",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2021",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Sept - Dec",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2021",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "May - Aug",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2021",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Jan - April",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2020",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Sept - Dec",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2020",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "May - Aug",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2020",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Jan - April",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2019",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Sept - Dec",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2019",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "May - Aug",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.owner),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2019",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Jan - April",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        /*
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.owner),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2018",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Sept - Dec",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Active",
                    fontSize = 10.sp,
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

         */
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.owner),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2018",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "May - Aug",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.owner),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2018",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Jan - April",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.owner),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2017",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Sept - Dec",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.owner),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2017",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "May - Aug",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .width(115.dp)
                .clip(RoundedCornerShape(8.dp)),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.owner),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .offset(40.dp, (8).dp)
                        .clip(CircleShape),
                )
                Text(
                    text = "2017",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp),
                )
                Text(
                    text = "Jan - April",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Text(
                    text = "Coming Soon",
                    fontSize = 10.sp,
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
}



@Preview(showBackground = true)
@Composable
fun PreviewAcademicYear() {
    AcademicYearView(navController = rememberNavController())
}