package com.example.exambank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exambank.datalayer.models.login.LoginViewModel
import com.example.exambank.navigation.Navigator
import com.example.exambank.ui.theme.ExamBankComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            
            ExamBankComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    ScreenMain()
                    Navigator(loginViewModel = loginViewModel)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExamBankComposeTheme {
//        ScreenMain()
        Navigator(loginViewModel = LoginViewModel())
    }
}