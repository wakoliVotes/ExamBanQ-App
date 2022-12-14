package com.example.exambank.viewscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exambank.viewscreens.paperitems.HeaderSection
import com.example.exambank.viewscreens.paperitems.QuestionEach
import com.example.exambank.viewscreens.paperitems.QuestionNumberSection

@Preview
@Composable
fun FullExamPaper() {
    Column() {
            HeaderSection()
            Spacer(modifier = Modifier.height(10.dp))
            QuestionEach()
    }
}