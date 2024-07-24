package com.example.mynewcompose.ui.theme

data class CheckInfo(val title:String, var selected: Boolean= false, var onCheckedChange:(Boolean)-> Unit)
