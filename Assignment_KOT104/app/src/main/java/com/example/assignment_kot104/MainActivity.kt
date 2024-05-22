package com.example.assignment_kot104

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.assignment_kot104.ui.theme.Assignment_KOT104Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_KOT104Theme {
                GetLayout(this)
            }
        }
    }
}

val customFontFamily = FontFamily(
    Font(R.font.gelasio, FontWeight.Normal)
)
val customFontFamily2 = FontFamily(
    Font(R.font.nunotosan1, FontWeight.Normal)
)

@Composable
private fun GetLayout(context: Context) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Hình ảnh nền
        Image(
            painter = painterResource(id = R.drawable.bgr1),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        // Nội dung
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
        ) {
            Text(
                text = "MAKE YOUR",
                style = TextStyle(
                    fontFamily = customFontFamily,
                    fontSize = 24.sp,
                    color = Color("#606060".toColorInt()),
                    lineHeight = 30.47.sp
                ),
                modifier = Modifier
                    .padding(top = 231.dp, start = 30.dp)
                    .height(30.dp)
                    .width(166.dp)
            )
            Text(
                text = "HOME BEAUTIFUL",
                style = TextStyle(
                    fontFamily = customFontFamily,
                    fontSize = 30.sp,
                    color = Color("#303030".toColorInt()),
                    lineHeight = 30.09.sp
                ),
                modifier = Modifier
                    .padding(top = 30.dp, start = 30.dp)
                    .height(38.dp)
                    .width(304.dp)
            )
            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                style = TextStyle(
                    fontFamily = customFontFamily2,
                    fontSize = 18.sp,
                    color = Color("#808080".toColorInt()),
                    lineHeight = 35.sp
                ),
                modifier = Modifier
                    .padding(top = 50.dp, start = 30.dp)
                    .height(105.dp)
                    .width(286.dp)
                    .align(Alignment.CenterHorizontally)
            )
            getButton(onClick = {
                navigationScreen(context)
            })
        }
    }
}

@Composable
private fun getButton(onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .padding(top = 130.dp, start = 108.dp)
            .width(159.dp)
            .height(54.dp)
            .clickable(onClick = onClick)
        ,
        color = Color(0xFF242424),
        contentColor = Color("#FFFFFF".toColorInt()),
        shape = MaterialTheme.shapes.small
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp),
//                .align(Alignment.CenterVertically),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Get Started",
                style = TextStyle(
                    fontFamily = customFontFamily,
                    fontSize = 18.sp,
                    lineHeight = 22.85.sp
                ),
                modifier = Modifier
//                    .clickable(onClick = onClick)
            )
        }
    }
}

 fun navigationScreen(context: Context) {
    val intent = Intent(context, LoginActivity::class.java)
    context.startActivity(intent)
}
