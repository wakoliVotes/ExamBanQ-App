package com.example.exambank.viewscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.exambank.R
import com.example.exambank.common.GradientButton
import com.example.exambank.navigation.Routes
import com.example.exambank.ui.theme.Purple500
import com.example.exambank.ui.theme.color1
import com.example.exambank.ui.theme.color2


@Composable
fun ForgotPassword(navController: NavHostController){
    var emailItem by remember { mutableStateOf("Enter email ...") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Welcome Banner
        Text(
            text = "Forgot Your Password",
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif
            )
        )
        Image(painter = painterResource(id = R.drawable.forgot_pass), contentDescription = null)
        // Card to Hold Next Items
        // Card to hold next items
        Card(
            backgroundColor = Color.White,
            elevation = 0.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Email
                OutlinedTextField(value = emailItem, onValueChange = { newText ->
                    {
                        emailItem = newText
                    }
                }, label = {
                    Text(text = "Email:")
                }, singleLine = true, leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "Email"
                        )

                    }
                }, trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Check"
                        )
                    }
                }, keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Go
                )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                // Created Button Called Here
                GradientButton(text = "Send Reset Link", textColor = Color.White, gradient = Brush.horizontalGradient(
                    colors = listOf(
                        color1, color2
                    )
                )) {  }

            }

        }
        Text(text = "Do not have have an account?")
        // Do not have have an account Call
        ClickableText(
            text = AnnotatedString("Sign Up"),
            onClick = { navController.navigate(Routes.SignUp.route) },
            modifier = Modifier.padding(start = 5.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.None,
                color = Purple500
            )
        )
    }
}


//@Preview
//@Composable
//fun PreviewForgotPassword () {
//    ForgotPassword ()
//}