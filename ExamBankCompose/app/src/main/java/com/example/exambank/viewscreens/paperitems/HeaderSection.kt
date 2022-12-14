package com.example.exambank.viewscreens.paperitems

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exambank.R


@Composable
fun HeaderSection(){
MaterialTheme(){
    Box {
        HeaderItems()
    }
}

}




@Composable
private fun HeaderItems(
//    calendarYear: String,
//    unitCode: String,
//    unitName: String,
//    monthYear: String,
){
    Card(

        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(420.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.kcau_logo1),
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(4.dp))
            )
            Row(

                modifier = Modifier.padding(top = 0.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "UNIVERSITY EXAMINATIONS 2017/2018",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "EXAMINATION FOR THE DEGREE OF BACHELOR OF\n" +
                                "SCIENCE IN INFORMATION TECHNOLOGY/ BACHELOR \n" +
                                "OF BUSINESS IN INFORMATION TECHNOLOGY",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "BIT2303 BBIT305 DISTRIBUTED SYSTEMS",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "FULL TIME/PART TIME/DISTANCE LEARNING",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier.padding(bottom = 5.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = "DATE: DECEMBER, 2017",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(100.dp))
                        Text(
                            text = "TIME: 2 HOURS",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    // 1st Divider
                    Box(

                        modifier = Modifier
                            .height(4.dp)
                            .fillMaxWidth()
                            .background(color = Color.Black)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    // INSTRUCTIONS
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = "INSTRUCTIONS: ",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            
                            text = "Answer Question One & ANY OTHER TWO",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontFamily = FontFamily.SansSerif
                            )
                        )
                    }
                    // 2nd Divider
                    Box(

                        modifier = Modifier
                            .height(2.dp)
                            .fillMaxWidth()
                            .background(color = Color.Black)
                    )
                }
            }

        }

    }
}






@Composable
@Preview
fun PreviewHeaderSection(){
    HeaderSection()
}