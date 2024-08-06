package com.example.mynewcompose.recyclerview

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleRecyclerview(){
    val myList = listOf("Moreno", "Juan","Jhon","James")

    LazyColumn{
        // Ways to make a recyclerview
        item{ Text(text = "Example item")}

        items(7){
            Text(text = "Example number $it")
        }

        items(myList){
            Text(text = "Hello example $it")
        }
    }
}