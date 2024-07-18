package com.example.mynewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewcompose.ui.theme.MyNewComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MysuperText("")
                }
            }
        }
    }
}


// We can have more Previews
@Preview(
    name = "PREVIEW 1!",
    heightDp = 50,
    widthDp = 200,
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5

)

@Composable
fun MyTestSuperText(){
    MysuperText("What is going on?")
}
@Composable
fun MysuperText(name : String) {
    MyNewComposeTheme {
        Text(text = "Hello Word :( $name ")
    }
}