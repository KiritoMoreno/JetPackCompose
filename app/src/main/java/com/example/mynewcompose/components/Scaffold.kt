package com.example.mynewcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    var selectedItem by remember { mutableStateOf(0) } // To track the selected item
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MyDrawer { coroutineScope.launch { drawerState.apply { close() } } }
        }
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    onClickIcon = { iconLabel ->
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("You clicked on $iconLabel")
                        }
                    },
                    onClickDrawer = {
                        coroutineScope.launch {
                            drawerState.apply { if (isClosed) open() else close() }
                        }
                    }
                )
            },
            snackbarHost = { SnackbarHost(
                hostState = snackbarHostState,
                snackbar = {
                    Snackbar(
                        snackbarData = it,
                        containerColor = Color.LightGray,
                        contentColor= Color.Blue
                    )
                }
                ) },
            bottomBar = { MyBottomNavigation(selectedItem) { index -> selectedItem = index } },
            floatingActionButton = { MyFAB() }

        ) { contentPadding ->
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
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer:() -> Unit) {
    TopAppBar(
        title = { Text(text = "First Toolbar") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onClickDrawer()}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { onClickIcon("Dangerous") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Close")
            }
        }
    )
}

@Composable
fun MyBottomNavigation(selectedItem: Int, onItemSelected: (Int) -> Unit) {
    NavigationBar(containerColor = Color.Red) {
        NavigationBarItem(
            selected = selectedItem == 0,
            onClick = { onItemSelected(0) },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Red,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray
            ),
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text(text = "Home") }
        )
        NavigationBarItem(
            selected = selectedItem == 1,
            onClick = { onItemSelected(1) },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Red,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray
            ),
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite") },
            label = { Text(text = "Favorite") }
        )
        NavigationBarItem(
            selected = selectedItem == 2,
            onClick = { onItemSelected(2) },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Red,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray
            ),
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Person") },
            label = { Text(text = "Person") }
        )
    }
}

@Composable
fun MyFAB() {
    Box(modifier = Modifier)
    FloatingActionButton(
        onClick = { },
        containerColor = Color.Yellow,
        contentColor = Color.Black,
        shape = CircleShape,
        modifier = Modifier
            .size(80.dp)
            .offset(y = 60.dp)
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(text = "First Option", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() })
        Text(
            text = "Second Option",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() })
        Text(
            text = "Third Option",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() })
        Text(
            text = "Fourth Option",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() })
    }
}
