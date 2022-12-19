package com.example.exambank.datalayer.models


// ABOUT
data class AboutClass(
    val aboutTitle: String,
    val aboutOne: String,
    val aboutTwo: String,
    val aboutThree: String
)


// PRIVACY POLICY
data class PrivacyPolicyClass(
    val privacyTitle: String,
    val privacyOne: String,
    val privacyTwo: String,
    val privacyThree: String,
    val privacyFour: String
)

// TERMS OF USE
data class TermsOfUseClass(
    val termsTitle: String,
    val termOne: String,
    val termTwo: String,
    val termThree: String,
    val termFour: String
)

// NOTIFICATIONS
data class NotificationsClass(
    val noticeImg: Int,
    val noticeName: String,
    val noticeSummary: String,
    val noticeTime: String
)
