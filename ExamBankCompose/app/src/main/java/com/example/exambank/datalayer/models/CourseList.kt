package com.example.exambank.datalayer.models

data class CourseList(
    val unitId: Int,
    val unitCodeAndName: String,
)

data class QuestionList(
    val questionNumber: String,
    val marks: String,
)