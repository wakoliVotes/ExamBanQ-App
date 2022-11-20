package com.example.exambankcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exambankcompose.R
import com.example.exambankcompose.ui.theme.Shapes

@Composable
fun ForgotPassword(  /* navController: NavHostController */ ) {

    var email by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

            ) {
        Text(text = "FORGOT YOUR PASSWORD",
            fontFamily = FontFamily.Monospace,
            color = MaterialTheme.colors.primaryVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 80.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp
            )
        // image
        Image(painter = painterResource(id = R.drawable.forgot_pass),
            contentDescription = null,
            modifier = Modifier.size(240.dp)
        )
        // Card to hold next items
        Card(
            backgroundColor = Color.White,
            elevation = 0.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Column {
                Text(text = "Enter Your Registration Email Below to receive password reset instructions",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 12.sp
                )
                OutlinedTextField (value = email, onValueChange = {email=it},
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colors.primary,
                        backgroundColor = MaterialTheme.colors.surface,
                        cursorColor = MaterialTheme.colors.primary,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = Shapes.medium,
                    singleLine = true,
                    leadingIcon = {
                        Row(
                            modifier = Modifier.padding(start = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_email),
                                contentDescription = null,
                                tint = MaterialTheme.colors.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Spacer(modifier = Modifier
                                .width(3.dp)
                                .height(24.dp)
                                .background(MaterialTheme.colors.primary)
                            )

                        }
                    },
                    placeholder = {
                        Text(text = "Email Address",
                            color = Color.Gray
                        )
                    },
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif
                    )
                )
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp),
                    contentPadding = PaddingValues(vertical = 14.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 2.dp
                    ),
                    shape = Shapes.medium
                ) {

                }
            }

        }

        
    }

}



@Preview
@Composable
fun PreviewForgotPassword () {
    ForgotPassword()
}