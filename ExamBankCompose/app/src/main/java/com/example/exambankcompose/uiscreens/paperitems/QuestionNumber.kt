package com.example.exambankcompose.uiscreens.paperitems

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exambankcompose.R
import com.example.exambankcompose.data.QuestionData
import com.example.exambankcompose.data.QuestionList

@Composable
fun QuestionNumberSection() {
    Column {
        LazyColumn {
            items(QuestionData.listQuestions.size) {
                QuestionOne(QuestionData.listQuestions[it])


            }
        }
    }
}

@Composable
fun QuestionOne(questions: QuestionList) {
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
                    .align(Alignment.CenterVertically)
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .align(Alignment.CenterVertically),
                text = questions.questionNumber,
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .align(Alignment.CenterVertically),
                text = questions.marks,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
@Preview
fun PreviewQuestionNumberSection() {
    QuestionNumberSection()

}
