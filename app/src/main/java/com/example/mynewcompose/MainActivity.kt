package com.example.mynewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.mynewcompose.NavigationCompose.Routes
import com.example.mynewcompose.NavigationCompose.Screen1
import com.example.mynewcompose.NavigationCompose.Screen2
import com.example.mynewcompose.NavigationCompose.Screen3
import com.example.mynewcompose.NavigationCompose.Screen4
import com.example.mynewcompose.NavigationCompose.Screen5
import com.example.mynewcompose.instagram.Login.LoginScreen
import com.example.mynewcompose.instagram.Login.LoginViewModel
import com.example.mynewcompose.ui.theme.MyNewComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF161D26))
                ) {
                    LoginScreen(loginViewModel)
                }
                }
            }
        }
    }


@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        color = Color.Red,
        thickness = 8.dp
    )
}

@Composable
fun MyDropDownMenu() {
    var selectedText by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    val desserts = listOf("", "Bowl", "Coffee", "Apple", "Toast")

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(text = { Text(text = dessert) }, onClick = {
                    expanded = false
                    selectedText = dessert
                })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNewComposeTheme {
        MyDropDownMenu()
    }
}