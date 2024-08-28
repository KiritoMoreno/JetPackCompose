package com.example.mynewcompose.NavigationCompose

sealed class Routes(val route: String){
    //A sealed class is a class that groups several classes or objects.
    object Screen1: Routes("Screen1")
    object Screen2: Routes("Screen2")
    object Screen3: Routes("Screen3")
    object Screen4: Routes("Screen4/{age}"){
        fun createRoute(age:Int) = "Screen4/$age"
    }
    object Screen5: Routes("Screen5?name={name}"){
        fun createRoute(name:String) = "Screen5?name=$name"
    }

}