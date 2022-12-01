package com.example.exambankcompose.uiscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exambankcompose.uiscreens.paperitems.HeaderSection
import com.example.exambankcompose.uiscreens.paperitems.QuestionEach
import com.example.exambankcompose.uiscreens.paperitems.QuestionNumberSection

@Preview
@Composable
fun FullExamPaper(){
Column() {
    HeaderSection()
    Spacer(modifier = Modifier.height(10.dp))
    QuestionNumberSection()
    QuestionEach()
}

}