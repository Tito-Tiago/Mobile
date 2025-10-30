    package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Column(content = {
                    Info(
                        "Tiago Tito",
                        "Engenheiro de Software",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Contact(
                        phone = "+55(85)9 91999999",
                        linkedin = "@Tiago Tito",
                        email = "tiagotito.contato@gmail.com",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                })
            }
        }
    }
}

@Composable
fun Info(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

    Column (
        modifier
    ) {
        Image(
            painter = image,
            contentDescription = "Android logo",
            modifier = Modifier
                .height(70.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Contact(phone: String, linkedin: String, email: String, modifier: Modifier = Modifier) {
    Column (
        modifier
    ) {
        Row {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "phone"
            )
            Text(
                text = phone,
                fontSize = 16.sp
            )
        }
        Row {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "share icon"
            )
            Text(
                text = linkedin,
                fontSize = 16.sp
            )
        }
        Row {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email",
            )
            Text(
                text = email,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Column(content = {
            Info(
                "Tiago Tito",
                "Engenheiro de Software",
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Contact(
                phone = "+55(85)9 91999999",
                linkedin = "@Tiago Tito",
                email = "tiagotito.contato@gmail.com",
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        })
    }
}