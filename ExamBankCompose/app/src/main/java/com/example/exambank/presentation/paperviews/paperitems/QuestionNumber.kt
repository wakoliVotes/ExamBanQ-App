package com.example.exambank.presentation.paperviews.paperitems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exambank.ui.theme.black
import com.example.exambank.ui.theme.white

@Preview
@Composable
fun QuestionNumberSection() {
    Column {
        LazyColumn {
            item {
                QuestionNumberTemplate(
                    quizTitle = "Question 1: ",
                    quizMarks = "30 Marks (Compulsory)"
                )
                QuestionNumberTemplate(
                    quizTitle = "Question 2: ",
                    quizMarks = "20 Marks"
                )
                QuestionNumberTemplate(
                    quizTitle = "Question 3: ",
                    quizMarks = "20 Marks"
                )
            }
        }
    }
}

@Composable
fun QuestionNumberTemplate(
    quizTitle: String,
    quizMarks: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .height(55.dp)
            .background(color = white)
    ) {
        Row(
            modifier = Modifier
                .padding(35.dp)
                .fillMaxWidth()

        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .align(Alignment.CenterVertically),
                text = quizTitle,
                color = black,
                style = MaterialTheme.typography.h6
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .align(Alignment.CenterVertically),
                text = quizMarks,
                color = black,
                style = MaterialTheme.typography.h6
            )
        }
    }
}
