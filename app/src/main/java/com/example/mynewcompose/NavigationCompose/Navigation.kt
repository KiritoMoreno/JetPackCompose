package com.example.mynewcompose.NavigationCompose

import android.app.backup.BackupAgent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.mynewcompose.NavigationCompose.Routes.*

@Composable
fun Screen1(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "Screen 1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Screen2.route) })
    }
}

@Composable
fun Screen2(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Screen 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Screen3.route) })
    }
}

@Composable
fun Screen3(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) { Text(text = "Screen 3", modifier = Modifier.align(Alignment.Center).clickable { navigationController.navigate("Screen4/28") }) }
}

@Composable
fun Screen4(navigationController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) { Text(text = age.toString(), modifier = Modifier.align(Alignment.Center).clickable { navigationController.navigate("Screen5") }) }
}
@Composable
fun Screen5(navigationController: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) { Text(text = "My name is $name", modifier = Modifier.align(Alignment.Center)) }
}
