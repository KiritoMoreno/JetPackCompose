package com.example.mynewcompose.NavigationCompose

sealed class Routes(val route: String){
    //A sealed class is a class that groups several classes or objects.
    object Screen1: Routes("Screen1")
    object Screen2: Routes("Screen2")
    object Screen3: Routes("Screen3")

}