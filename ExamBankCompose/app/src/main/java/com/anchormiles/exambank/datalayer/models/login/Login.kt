package com.anchormiles.exambank.datalayer.models.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.anchormiles.exambank.R
import com.anchormiles.exambank.navigation.Routes
import com.anchormiles.exambank.ui.theme.ExamBankComposeTheme


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage: () -> Unit,
    onNavToSignUpPage: () -> Unit,
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.logInError != null
    val context = LocalContext.current

    // Visibility
    var passwordVisibility by remember { mutableStateOf(false) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    )
    {
        // Logo image section and app name
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .width(90.dp)
                .height(100.dp)
                .padding(bottom = 8.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Login",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSecondary
        )
        if (isError) {
            Text(text = loginUiState?.logInError ?: "unknown error",
                color = MaterialTheme.colors.error
            )
        }
        OutlinedTextField(
            value = loginUiState?.userName ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor =  Color.LightGray,
                focusedLabelColor =  Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
            ),
            onValueChange = {
                loginViewModel?.onUserNameChange(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = null)
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                    )
                }
            },
            label = {
                Text(text = "Email")
            },
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
        OutlinedTextField(
            value = loginUiState?.password ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor =  Color.LightGray,
                focusedLabelColor =  Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
            ),
            onValueChange = {
                loginViewModel?.onPasswordNameChange(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock,
                    contentDescription = null)
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    // User painter resource to add visibility icon
                    Image(
                        painter = painterResource(id = if (passwordVisibility) R.drawable.visibility else R.drawable.visibility_off),
                        contentDescription = null,
                    )
                }
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
        Spacer(modifier = Modifier.height(28.dp))
        Button(
            onClick = {
                /*TODO*/
                loginViewModel?.loginUser(context)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.onBackground,
                contentColor = MaterialTheme.colors.onPrimary
            )
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(5.dp)
            )
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                color = MaterialTheme.colors.onSecondary
            )
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = {
                /*TODO*/
                onNavToSignUpPage.invoke()
            }) {
                Text(
                    text = "Sign Up",
                    color = MaterialTheme.colors.primaryVariant
                )
            }
        }

        if (loginUiState?.isLoading == true) {
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser) {
            if (loginViewModel?.hasUser == true) {
                onNavToHomePage.invoke()
            }
        }
    }
}

@Composable
fun SignUpScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage: () -> Unit,
    onNavToLoginpPage: () -> Unit,
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current

    // visibility
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        // Logo image section and app name
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .width(90.dp)
                .height(100.dp)
                .padding(bottom = 8.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSecondary
        )
        if (isError) {
            Text(text = loginUiState?.signUpError ?: "unknown error",
                color = MaterialTheme.colors.error
            )
        }
        OutlinedTextField(
            value = loginUiState?.userNameSignUp ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor =  Color.LightGray,
                focusedLabelColor =  Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
            ),
            onValueChange = {
                loginViewModel?.onUserChangeSignUp(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = null)
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                    )
                }
            },
            label = {
                Text(text = "Email")
            },
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
        OutlinedTextField(
            value = loginUiState?.passwordSignUp ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor =  Color.LightGray,
                focusedLabelColor =  Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
            ),
            onValueChange = {
                loginViewModel?.onPasswordChangeSignUp(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock,
                    contentDescription = null)
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    // User painter resource to add visibility icon
                    Image(
                        painter = painterResource(id = if (passwordVisibility) R.drawable.visibility else R.drawable.visibility_off),
                        contentDescription = null,
                    )
                }
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
        OutlinedTextField(
            value = loginUiState?.confirmPasswordSignUp ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor =  Color.LightGray,
                focusedLabelColor =  Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
            ),
            onValueChange = {
                loginViewModel?.onConfirmPasswordChange(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock,
                    contentDescription = null)
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    // User painter resource to add visibility icon
                    Image(
                        painter = painterResource(id = if (passwordVisibility) R.drawable.visibility else R.drawable.visibility_off),
                        contentDescription = null,
                    )
                }
            },
            label = {
                Text(text = "Confirm Password")
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
        Spacer(modifier = Modifier.height(28.dp))
        Button(
            onClick = {
                /*TODO*/
                loginViewModel?.createUser(context)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(text = "Sign Up",
                modifier = Modifier.padding(5.dp))
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an Account?",
                color = MaterialTheme.colors.onSecondary
            )
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = {
                /*TODO*/
                onNavToLoginpPage.invoke()
            }) {
                Text(
                    text = "Login",
                    color = MaterialTheme.colors.primaryVariant
                )
            }
        }

        if (loginUiState?.isLoading == true) {
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser) {
            if (loginViewModel?.hasUser == true) {
                onNavToHomePage.invoke()
            }
        }

    }
}


// Forgot Password
@Composable
fun ForgotPassword(navController: NavHostController){
    var emailItem by remember { mutableStateOf("Enter email ...") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.onPrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Welcome Banner
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .width(90.dp)
                .height(100.dp)
                .padding(bottom = 8.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(36.dp))
        Text(
            text = "Forgot Your Password",
            style = TextStyle(
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
            )
        )
        Image(
            painter = painterResource(id = R.drawable.forgot_pass),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )
        // Card to Hold Next Items
        // Card to hold next items
        Card(
            backgroundColor = MaterialTheme.colors.onPrimary,
            elevation = 0.dp,
            modifier = Modifier
                .fillMaxWidth()
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
                ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                )
                Spacer(modifier = Modifier.padding(10.dp))
                // Created Button Called Here
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        /*TODO*/

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onSecondary,
                        contentColor = MaterialTheme.colors.onPrimary
                    )
                ) {
                    Text(text = "Send Reset Link",
                        modifier = Modifier.padding(5.dp))
                }

            }

        }
        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "Do not have have an account?",
            color = MaterialTheme.colors.onSecondary
        )
        // Do not have have an account Call
        ClickableText(
            text = AnnotatedString("Sign Up"),
            onClick = { navController.navigate(Routes.SignUp.route) },
            modifier = Modifier.padding(start = 5.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.None,
                color = MaterialTheme.colors.primaryVariant
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreLoginSCreen() {
    ExamBankComposeTheme() {
        LoginScreen(onNavToHomePage = { /*TODO*/ }) {
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreSignUpSCreen() {
    ExamBankComposeTheme() {
        SignUpScreen(onNavToHomePage = { /*TODO*/ }) {
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreForgotPasswordSCreen() {
    ExamBankComposeTheme() {
        ForgotPassword(navController = rememberNavController())
    }
}