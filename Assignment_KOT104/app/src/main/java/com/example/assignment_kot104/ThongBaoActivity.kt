package com.example.assignment_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThongBaoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            getLayoutTB()
        }
    }
}
@Preview
@Composable
fun getLayoutTB(){
    val context = LocalContext.current
    Column (
    modifier = Modifier
        .fillMaxSize()
        .background(Color("#FFFFFF".toColorInt()))
    ){
        Text(text = "SUCCESS!",
            style = TextStyle(
                fontFamily = customFont1,
                fontSize = 40.sp,
                lineHeight = 40.sp,

            ),
            modifier = Modifier
                .padding(top = 150.dp)
                .align(Alignment.CenterHorizontally)

            )
        getLayoutContentTB()
        Text(text = "Your order will be delivered soon.\n" +
                "Thank you for choosing our app!",
            style = TextStyle(
                fontFamily = customFontFamily2,
                fontSize = 20.sp,
                lineHeight = 27.sp,
                color = Color("#606060".toColorInt())
                ),
            modifier = Modifier
                .padding(top = 60.dp)
                .align(Alignment.CenterHorizontally)

        )
        getButtonOrder {

        }
        getButtonBack {
            navigateToHomeScreen(context)
        }
    }
}

@Composable
fun getLayoutContentTB(){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(300.dp)
                .height(250.dp)
                .align(Alignment.Center)
                
        )
        Image(
            painter = painterResource(id = R.drawable.group3),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .align(Alignment.Center)

        )
        Image(
            painter = painterResource(id = R.drawable.verified),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 30.dp)
        )
    }
}
@Composable
fun getButtonOrder(onClick : () -> Unit){
    Surface(
        modifier = Modifier
            .padding(top = 30.dp, start = 30.dp, end = 30.dp)
            .fillMaxWidth()
            .height(60.dp)
            .clickable(onClick = onClick),
        color = Color(0xFF242424),
        contentColor = Color.White,
        shape = MaterialTheme.shapes.small
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Track your orders",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 18.sp,
                    lineHeight = 22.85.sp,
                    color = Color.White
                )

            )

        }
    }
}
@Composable
fun getButtonBack(onClick : () -> Unit){
    Surface(
        modifier = Modifier
            .padding(top = 30.dp, start = 30.dp, end = 30.dp)
            .fillMaxWidth()
            .height(60.dp)
            .clickable(onClick = onClick)
            .border(width = 2.dp, color = Color.Black, shape = MaterialTheme.shapes.small),
        color = Color(0xFFFFFF),
        contentColor = Color.White,
        shape = MaterialTheme.shapes.small
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "BACK TO HOME",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 18.sp,
                    lineHeight = 22.85.sp,
                    color = Color.Black
                )
            )
        }
    }
}
