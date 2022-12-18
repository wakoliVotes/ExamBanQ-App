package com.example.exambank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.exambank.common.GradientButton
import com.example.exambank.navigation.Routes
import com.example.exambank.ui.theme.Purple500
import com.example.exambank.ui.theme.color1
import com.example.exambank.ui.theme.color2


@Composable
fun SignIn(navController: NavHostController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        var emailItem by remember { mutableStateOf("Enter email ...") }
        var passwordItem by remember { mutableStateOf("Enter password ....") }

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
            text = "Log In",
            style = TextStyle(
                fontSize = 40.sp,
                fontFamily = FontFamily.SansSerif
            )
        )
        Spacer(modifier = Modifier.padding(30.dp))

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


        Spacer(modifier = Modifier.padding(10.dp))
        // Created Button Called Here
        GradientButton(text = "Log In", textColor = Color.White, gradient = Brush.horizontalGradient(
            colors = listOf(
                color1, color2
            )
        )) {  }

        Spacer(modifier = Modifier.padding(5.dp))
        Row() {
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
        // Forgotten Password Call
        Spacer(modifier = Modifier.padding(30.dp))
        Row() {
            Text(text = "Forgot Your Password?")
            // Do not have have an account Call
            ClickableText(
                text = AnnotatedString("Reset"),
                onClick = { navController.navigate(Routes.ForgotPassword.route) },
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
}

@Composable
fun HeaderCallView(){
    Image(
        painter = painterResource(id = R.drawable.login_img),
        contentDescription = "login image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth
    )
    // Column
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 5.dp),
    )
    {
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.flower_logo),
            contentDescription = "flower logo",
            modifier = Modifier.wrapContentWidth()
        )
        Text(
            text = "Exam Bank",
            color = Color.White,
            style = TextStyle(
                fontSize = 40.sp,
                fontFamily = FontFamily.SansSerif,
                letterSpacing = 2.sp
            )
        )

    }

}


@Composable
@Preview
fun PreviewHeaderCall(){
    HeaderCallView()
}