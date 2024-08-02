package com.example.mynewcompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.R

@Composable
fun MyTwitterPost() {
    var chat by remember {
        mutableStateOf(false)
    }
    var like by remember {
        mutableStateOf(false)
    }
    var rt by remember {
        mutableStateOf(false)
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF161D26))
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                MyTitle(text = "Moreno")
                MyDefaultText(text = "@KiritoMoreno", modifier = Modifier.padding(end = 8.dp))
                MyDefaultText(text = "2h", modifier = Modifier.padding(end = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painterResource(id = R.drawable.ic_dots),
                    contentDescription = "Dots",
                    tint = Color.White
                )
            }
            MyTextBody(
                text = "Crafting a Twitter post UI with Jetpack Compose is streamlined and efficient." + "Leveraging composable functions to build responsive and visually appealing layouts.",
                Modifier.padding(bottom = 16.dp)
            )
            MyImagePro()
            Row(Modifier.padding(top = 16.dp))
            {
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_chat),
                            contentDescription = "Chat",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_chat_filled),
                            contentDescription = "Chat",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    isSelected = chat
                ) {
                    chat = !chat
                }

                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_rt),
                            contentDescription = "Rt",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_rt),
                            contentDescription = "Rt",
                            tint = Color(0xFF00FF27)
                        )
                    },
                    isSelected = rt
                ) {
                    rt = !rt
                }

                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_like),
                            contentDescription = "Like",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_like_filled),
                            contentDescription = "Like",
                            tint = Color(0xFFF31E0F)
                        )
                    },
                    isSelected = like
                ) {
                    like = !like
                }
            }
        }
    }

}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1
    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }
        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun MyImagePro() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(
                RoundedCornerShape(10)
            ),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyTitle(text: String, modifier: Modifier = Modifier.padding(end = 8.dp)) {
    Text(
        text = text,
        color = Color.White,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun MyDefaultText(text: String, modifier: Modifier) {
    Text(text = text, color = Color.Gray, modifier = modifier)
}

@Composable
fun MyTextBody(text: String, modifier: Modifier) {
    Text(text = text, color = Color.White, modifier = modifier)
}

@Composable
fun DividerTwi(){
    Divider(Modifier.padding(top = 4.dp).height(0.8.dp).fillMaxWidth(), color = Color(0xFFE8B98))
}