package com.example.mynewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    MyColumn()
                }
            }
        }
    }
}

@Composable
fun MyColumn() {
// at column it will be like LinearLayout
    // verticalArrangement = Arrangement.SpaceBetween
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Example 1",
            Modifier
                .background(Color.Blue)
                .height(100.dp)
                .fillMaxSize()
        )// we can use weight(1f)
        Text(
            "Example 2",
            Modifier
                .background(Color.Black)
                .fillMaxSize()
        )
        Text(
            "Example 2",
            Modifier
                .background(Color.Black)
                .fillMaxSize()
        )
        Text("Example 3",
            Modifier
                .background(Color.Red)
                .height(100.dp)
                .fillMaxSize())
        Text("Example 4",
            Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxSize())
        Text(
            "Example 2",
            Modifier
                .background(Color.Black)
                .fillMaxSize()
        )
        Text(
            "Example 2",
            Modifier
                .background(Color.Black)
                .fillMaxSize()
        )
        Text("Example 4",
            Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxSize())
        Text("Example 4",
            Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxSize())
        Text("Example 4",
            Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxSize())

        Text(
            "Example 2",
            Modifier
                .background(Color.Black)
                .fillMaxSize()
        )
        Text(
            "Example 2",
            Modifier
                .background(Color.Black)
                .fillMaxSize()
        )
        Text("Example 4",
            Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxSize())

        Text("Example 4",
            Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxSize())

        Text("Example 4",
            Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxSize())

        Text("Example 4",
            Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxSize())

    }
}

@Composable
fun MyBox(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(androidx.compose.ui.graphics.Color.Blue)
                .verticalScroll(rememberScrollState()), contentAlignment = Alignment.Center
        ) {
            Text("Example to see the box")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNewComposeTheme {
        MyColumn()
    }
}