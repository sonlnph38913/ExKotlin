package com.example.assignment_kot104

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.toolbox.ImageLoader

class ProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
    getLayoutProduct()
        }
    }
}

@Preview
@Composable
fun getLayoutProduct() {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        getLayoutHeader()
        getLayoutContent()
    }
}
@Composable
fun getLayoutHeader(){
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxWidth()) {

        Image(
            painter = painterResource(id = R.drawable.imgpro),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(350.dp)
                .height(450.dp)
                .align(Alignment.TopEnd)
        )
        imgBack {
           getBackNav(context)
        }

        Image(
            painter = painterResource(id = R.drawable.color),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(270.dp)
                .width(135.dp)
                .offset(x = 10.dp, y = 100.dp) // Điều chỉnh giá trị offset cho phù hợp
        )

    }
}
@Composable
fun getLayoutContent(){
    val context = LocalContext.current
    Column (
    ){
    Text(text = "Minimal Stand",
        style = TextStyle(
            fontFamily = customFontFamily,
            fontSize = 24.sp,
            lineHeight = 30.47.sp,
            color = Color("#303030".toColorInt())
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 30.dp)
        )
        Row {
            Text(text = "$ 50",
                style = TextStyle(
                    fontFamily = customFontFamily3,
                    fontSize = 30.sp,
                    lineHeight = 40.92.sp,
                    color = Color("#303030".toColorInt())
                ),
                modifier = Modifier
                    .padding(top = 10.dp, start = 30.dp)
            )
            Image(painter = painterResource(id = R.drawable.add),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(start = 150.dp, top = 20.dp)
                    .size(30.dp)
                            )
            Text(text = "01",
                style = TextStyle(
                    fontFamily = customFontFamily2,
                    fontSize = 25.sp,
                    lineHeight = 30.47.sp,
                    color = Color("#303030".toColorInt())
                ),
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp)
            )
            Image(painter = painterResource(id = R.drawable.remove),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(start = 15.dp, top = 20.dp)
                    .size(30.dp)
            )
        }
        Row {
            Image(painter = painterResource(id = R.drawable.star1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(start = 30.dp, top = 10.dp)
                    .size(30.dp)
            )
            Text(text = "4.5",
                style = TextStyle(
                    fontFamily = customFontFamily3,
                    fontSize = 20.sp,
                    lineHeight = 24.55.sp,
                    color = Color("#303030".toColorInt())
                ),
                modifier = Modifier
                    .padding(top = 10.dp, start = 15.dp)
            )
            Text(text = "(50 reviews)",
                style = TextStyle(
                    fontFamily = customFontFamily3,
                    fontSize = 14.sp,
                    lineHeight = 24.55.sp,
                    color = Color("#303030".toColorInt())
                ),
                modifier = Modifier
                    .padding(top = 15.dp, start = 20.dp)
            )

        }
        Text(
            text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
            style = TextStyle(
                fontFamily = customFontFamily3, // Bạn có thể thay đổi font này bằng customFontFamily3
                fontSize = 15.sp,
                lineHeight = 19.1.sp,
                color = Color("#303030".toColorInt()),
                textAlign = TextAlign.Justify
            ),
            modifier = Modifier
                .padding(top = 10.dp, start = 30.dp, end = 30.dp)
                .align(Alignment.CenterHorizontally)
        )
        Row {
            Image(painter = painterResource(id = R.drawable.save),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(start = 30.dp, top = 15.dp)
                    .size(60.dp)
            )
            getButton {
                    navigateToCardScreen(context)
            }

        }

    }
}

fun navigateToCardScreen(context: Context) {
    val intent = Intent(context, CardActivity::class.java)
    context.startActivity(intent)
}

@Composable
private fun getButton(onClick : () -> Unit){
    Surface(
        modifier = Modifier
            .padding(top = 15.dp, start = 30.dp, end = 30.dp)
            .width(285.dp)
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
                text = "Add To Card",
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

fun getBackNav(context: Context){
    val intent = Intent(context, HomeActivity::class.java)
    context.startActivity(intent)
}
@Composable
fun imgBack(onClick: () -> Unit){
    Image(
        painter = painterResource(id = R.drawable.back),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(130.dp)
            .offset(x = 5.dp, y = 10.dp)
            .clickable(onClick = onClick)
    )
}



