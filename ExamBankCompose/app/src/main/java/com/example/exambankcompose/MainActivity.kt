package com.example.exambankcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.exambankcompose.ui.theme.ExamBankComposeTheme
import com.example.exambankcompose.uiscreens.ScreenMain
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamBankComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenMain()

                }
            }
        }
    }
}

@Composable
private fun getGoogleLoginAuth(): GoogleSignInClient {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .requestIdToken(stringResource(R.string.gcp_id))
        .requestId()
        .requestProfile()
        .build()

    return GoogleSignIn.getClient(this, gso)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExamBankComposeTheme {
        ScreenMain()
    }
}