package com.example.mynewcompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = { MyTopAppBar() }
    ) {contentPadding ->
        // Apply the content padding provided by Scaffold
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxWidth()
                .height(200.dp)
        ) {
            // Your content goes here
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(text = "First Toolbar") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Close")
            }
        }
    )
}
