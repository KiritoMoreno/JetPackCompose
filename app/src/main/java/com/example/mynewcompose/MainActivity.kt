package com.example.mynewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
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
                    MyTextFieldAdvance()
                }
            }
        }
    }
}

@Composable
fun MyStateExample() {

    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Click")
        }
        Text(text = "I have been pressed $counter times")
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow), contentAlignment = Alignment.Center
        ) {
            Text(text = "Hello Word!!")
        }
        MySpacer(20)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue), contentAlignment = Alignment.Center
            ) {
                Text(text = "We Making an exercise")
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Cyan), contentAlignment = Alignment.Center
            ) {
                Text(text = "In Compose")
            }
        }
        MySpacer(20)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Red), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Congratulations!! =)")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow() {
    /*
    Row (Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
        Text(
            "Example 1"
        )
        Text(
            "Example 2"
        )
        Text(
            "Example 3"
        )
    }
    */
    //We can use Modifier.weight(1f) or another
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(
            "Example 1", modifier = Modifier.width(100.dp)
        )
        Text(
            "Example 2", modifier = Modifier.width(100.dp)
        )
        Text(
            "Example 3", modifier = Modifier.width(100.dp)
        )
        Text(
            "Example 4", modifier = Modifier.width(100.dp)
        )
        Text(
            "Example 5", modifier = Modifier.width(100.dp)
        )
        Text(
            "Example 6", modifier = Modifier.width(100.dp)
        )
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
                .background(Color.Blue)
                .height(100.dp)
                .fillMaxSize()
        )
        Text(
            "Example 3",
            Modifier
                .background(Color.Blue)
                .height(100.dp)
                .fillMaxSize()
        )


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

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Example of the text")
        Text(text = "Example of the text", color = Color.Blue)
        Text(text = "Example of the text", style = TextStyle(fontWeight = FontWeight.ExtraBold))
        Text(text = "Example of the text", fontWeight = FontWeight.Light)
        Text(text = "Example of the text", fontFamily = FontFamily.Cursive)
        Text(
            text = "Example of the text",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(text = "Example of the text", textDecoration = TextDecoration.Underline)
        Text(
            text = "Example of the text", textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough, TextDecoration.Underline
                )
            )
        )
        Text(
            text = "Example of the text",
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline
        )


    }
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(
        value = myText,
        onValueChange = {
            if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Which is your name?") }) // it will work like hint
}

@Composable
fun MyTextField() {

    var myText by remember { mutableStateOf("") }

    TextField(value = myText, onValueChange = { myText = it })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNewComposeTheme {
        MyTextFieldAdvance()
    }
}