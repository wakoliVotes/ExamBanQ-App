package com.example.exambank.viewscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.exambank.R

@Composable
fun NotificationView() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Notifications")
    }
}


@Preview
@Composable
fun CreateNotification() {
    // TODO
    /*
    * Notifications - Title
    * Categories - All Notifications
    * Image - Name - Summary Time
    * */

}


@Preview
@Composable
fun TopItemsList() {
    Row(
        modifier = Modifier.fillMaxWidth()
    )
    {
        Image(painter = painterResource(id = R.drawable.kcau_logo1),
            contentDescription = "logo"
        )
        Box(modifier = Modifier.fillMaxWidth())
        {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Notifications"
                )
                Image(imageVector = Icons.Default.Settings ,
                    contentDescription = "Settings"
                )
            }
        }
    }
}

@Preview
@Composable
fun CategoryNoticeList() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {

        Text(
            text = "All"
        )
        Text(
            text = "Verified"
        )
        Text(
            text = "Mentions"
        )
    }
}

@Preview
@Composable
fun MainNotification() {
    Row(
        modifier = Modifier.fillMaxWidth()
    )
    {
        Image(painter = painterResource(id = R.drawable.kcau_logo1),
            contentDescription = "logo"
        )
        Box(modifier = Modifier.fillMaxWidth())
        {
            Column() {
                Text(
                    text = "Unit Code and Name"
                )
                Text(
                    text = "Summary information about the course and unit more details"
                )
            }
        }
    }
}