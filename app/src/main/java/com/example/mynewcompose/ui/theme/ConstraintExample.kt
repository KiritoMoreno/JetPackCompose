package com.example.mynewcompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ConstraintExample(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()){
        // CreateRefs -> it allow us to created the id
        val (boxGreen,boxRed, boxBlue, boxYellow, boxBlack) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                // Here we can link to the others
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(boxYellow.bottom)
                end.linkTo(boxYellow.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                bottom.linkTo(boxYellow.top)
                start.linkTo(boxYellow.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Black)
            .constrainAs(boxBlack) {
                top.linkTo(boxYellow.bottom)
                start.linkTo(boxYellow.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                bottom.linkTo(boxYellow.top)
                end.linkTo(boxYellow.start)
            })

    }
}

@Composable
fun ConstraintExampleGuide(){
    ConstraintLayout (Modifier.fillMaxSize()){
        //val startGuide = createGuidelineFromTop(16.dp)
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })



    }
}

@Preview
@Composable
fun ConstraintBarrier(){
    ConstraintLayout (Modifier.fillMaxSize()){

        val (boxRed, boxBlue, boxYellow) = createRefs()

        val barrier = createEndBarrier(boxBlue,boxRed)

        Box (modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            start.linkTo(parent.start, margin = 16.dp)

        })
        Box (modifier = Modifier.size(235.dp).background(Color.Blue).constrainAs(boxBlue){
            top.linkTo(boxRed.bottom)
            start.linkTo(boxRed.start, margin = 32.dp)
        })

        // It will always respect the barrier ->
        Box(modifier = Modifier.size(50.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(barrier)
        })

    }
}