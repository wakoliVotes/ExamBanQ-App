package com.example.exambank.presentation.welcomeviews


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.exambank.R
import com.example.exambank.ui.theme.ExamBankComposeTheme


@Composable
fun OnBoardScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
//            .background(MaterialTheme.colors.primaryVariant)
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.fastcar),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.8f)
                .height(300.dp),
            contentScale = ContentScale.FillBounds

        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.fastcar),
                contentDescription = null,
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds

            )
            Text(
                text = "ExamBanQ",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start=16.dp)
            )
            Text(
                text = "Revise on the Go",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    navController.navigate("signIn")
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.onBackground,
                    contentColor = MaterialTheme.colors.onSecondary
                )
            ) {
                Text(
                    text = "Explore",
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.ExtraBold
                )
            }

        }
    }
}


// Create preview for the OnBoardScreen
@Preview
@Composable
fun OnBoardScreenPreview() {
    ExamBankComposeTheme() {
        OnBoardScreen(navController = rememberNavController())
    }
}






