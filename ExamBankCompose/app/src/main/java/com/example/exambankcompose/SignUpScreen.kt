package com.example.exambankcompose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exambankcompose.ui.theme.ExamBankComposeTheme
import com.example.exambankcompose.ui.theme.color1
import com.example.exambankcompose.ui.theme.color2


@Composable
fun SignUp(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        var fullName by remember { mutableStateOf("Enter name ... ") }
        var emailItem by remember { mutableStateOf("Enter email ...") }
        var passwordItem by remember { mutableStateOf("Enter password ....") }
        var confirmPassword by remember { mutableStateOf("Confirm password ...") }

        // Password visibility
        var passwordvisibility by remember {
            mutableStateOf(false)
        }
        val icon = if (passwordvisibility)
            painterResource(id = R.drawable.design_ic_visibility)
        else
            painterResource(id = R.drawable.design_ic_visibility_off)

        // Welcome Banner
        Text(
            text = "Sign Up",
            style = TextStyle(
                fontSize = 40.sp,
                fontFamily = FontFamily.SansSerif
            )
        )
        Spacer(modifier = Modifier.padding(30.dp))

        // Full name
        OutlinedTextField(
            value = fullName,
            onValueChange = { newText -> {
                fullName = newText
            }
            },
            label = {
                Text(text = "Name:")
            },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Person,
                        contentDescription ="Profile" )

                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Check,
                        contentDescription ="Check" )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onGo = {
                    Log.d("ImeAction", "Clicked")
                }
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
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
        OutlinedTextField(
            value = passwordItem,
            onValueChange = { newText -> {
                passwordItem = newText
            }
            },
            label = {
                Text(text = "Confirm Password")
            },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Lock,
                        contentDescription ="Password" )

                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordvisibility = !passwordvisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Go
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))

        // Confirm password
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { newText -> {
                confirmPassword = newText
            }
            },
            label = {
                Text(text = "Confirm Password")
            },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Lock,
                        contentDescription ="Password" )

                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordvisibility = !passwordvisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Go
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        // Created Button Called Here
        GradientButton(text = "Sign Up", textColor = Color.White, gradient = Brush.horizontalGradient(
            colors = listOf(
                color1, color2
            )
        )) {  }

        Spacer(modifier = Modifier.padding(20.dp))
        // Already have an account Call
        OutlinedTextField(value = "Already have an Account? Log In", onValueChange = {""})

        Spacer(modifier = Modifier.padding(5.dp))

        // Created Button Called Here
        GradientButton(text = "Log In", textColor = Color.White, gradient = Brush.horizontalGradient(
            colors = listOf(
                color1, color2
            )
        )) {  }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    ExamBankComposeTheme {
        SignUp()
    }
}

