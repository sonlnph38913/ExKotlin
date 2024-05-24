package com.example.assignment_kot104

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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

class CheckOutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getLayoutCheckOut()
        }
    }
}

@Preview
@Composable
fun getLayoutCheckOut() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        getHeaderCheckOut()
        getTitle1()
        getAddress()
        getTitle2()
        getPayment()
        getTitle3()
        getDelivery()
        getTotal()
        getButtonSubmit {
        navigationTBScreen(context)
        }
    }
}

@Composable
fun getHeaderCheckOut() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Search Icon",
            modifier = Modifier
                .size(40.dp)
                .padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.width(100.dp))
        Text(
            text = "Check Out",
            style = TextStyle(
                fontFamily = customFont1,
                fontSize = 18.sp,
                color = Color("#303030".toColorInt()),
                lineHeight = 45.sp
            ),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 15.dp)
        )
    }
}

@Composable
fun getTitle1() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 15.dp)
    ) {
        Text(
            text = "Shipping Address",
            style = TextStyle(
                fontFamily = customFontFamily3,
                fontSize = 18.sp,
                lineHeight = 24.55.sp,
                color = Color("#909090".toColorInt())
            ),
            modifier = Modifier
                .padding(top = 10.dp, start = 20.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.edit),
            contentDescription = "edit",
            modifier = Modifier
                .size(40.dp)
                .padding(end = 15.dp)
        )
    }
}

@Composable
fun getTitle2() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Payment",
            style = TextStyle(
                fontFamily = customFontFamily3,
                fontSize = 18.sp,
                lineHeight = 24.55.sp,
                color = Color("#909090".toColorInt())
            ),
            modifier = Modifier
                .padding(top = 10.dp, start = 20.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.edit2),
            contentDescription = "edit",
            modifier = Modifier
                .size(35.dp)
                .padding(end = 15.dp)
        )
    }
}

@Composable
fun getTitle3() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Delivery method",
            style = TextStyle(
                fontFamily = customFontFamily3,
                fontSize = 18.sp,
                lineHeight = 24.55.sp,
                color = Color("#909090".toColorInt())
            ),
            modifier = Modifier
                .padding(top = 10.dp, start = 20.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.edit2),
            contentDescription = "edit",
            modifier = Modifier
                .size(35.dp)
                .padding(end = 15.dp)
        )
    }
}

@Composable
fun getAddress() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
    ) {
        Text(
            text = "Bruno Fernandes",
            style = TextStyle(
                fontFamily = customFont1,
                fontSize = 18.sp,
                color = Color("#303030".toColorInt()),
                lineHeight = 45.sp
            ),
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
        )
        Divider(
            color = Color("#E0E0E0".toColorInt()),
            thickness = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )
        Text(
            text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
            style = TextStyle(
                fontFamily = customFont1,
                fontSize = 15.sp,
                color = Color("#808080".toColorInt()),
                lineHeight = 45.sp
            ),
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
        )
    }
}

@Composable
fun getPayment() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.mastercard),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp)
                .size(50.dp)
        )
        Text(
            text = "**** **** **** 3947",
            style = TextStyle(
                fontFamily = customFont1,
                fontSize = 15.sp,
                color = Color("#242424".toColorInt()),
                lineHeight = 45.sp
            ),
            modifier = Modifier
                .padding(start = 30.dp, end = 20.dp, top = 10.dp)
        )

    }
}

@Composable
fun getDelivery() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.dhl),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp)
                .height(30.dp)
                .width(100.dp)
        )
        Text(
            text = "Fast (2-3days)",
            style = TextStyle(
                fontFamily = customFont1,
                fontSize = 15.sp,
                color = Color("#242424".toColorInt()),
                lineHeight = 45.sp
            ),
            modifier = Modifier
                .padding(start = 30.dp, end = 20.dp, top = 10.dp)
        )

    }
}

@Composable
fun getTotal() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween // Sắp xếp các phần tử ngang cách nhau
        ) {
            Text(
                text = "Order :",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 20.sp,
                    color = Color("#808080".toColorInt()),
                    lineHeight = 45.sp
                ),
                modifier = Modifier.padding(start = 30.dp, top = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f)) // Spacer chiếm hết không gian còn lại
            Text(
                text = "$ 95.00",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 20.sp,
                    color = Color("#808080".toColorInt()),
                    lineHeight = 45.sp
                ),
                modifier = Modifier.padding(end = 20.dp, top = 10.dp)
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween // Sắp xếp các phần tử ngang cách nhau
        ) {
            Text(
                text = "Delivery:",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 20.sp,
                    color = Color("#808080".toColorInt()),
                    lineHeight = 45.sp
                ),
                modifier = Modifier.padding(start = 30.dp, top = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f)) // Spacer chiếm hết không gian còn lại
            Text(
                text = "$ 5.00",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 20.sp,
                    color = Color("#808080".toColorInt()),
                    lineHeight = 45.sp
                ),
                modifier = Modifier.padding(end = 20.dp, top = 10.dp)
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween // Sắp xếp các phần tử ngang cách nhau
        ) {
            Text(
                text = "Total:",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 20.sp,
                    color = Color("#808080".toColorInt()),
                    lineHeight = 45.sp
                ),
                modifier = Modifier.padding(start = 30.dp, top = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f)) // Spacer chiếm hết không gian còn lại
            Text(
                text = "$ 100.00",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 20.sp,
                    color = Color("#242424".toColorInt()),
                    lineHeight = 45.sp
                ),
                modifier = Modifier.padding(end = 20.dp, top = 10.dp)
            )

        }

    }
}
@Composable
fun getButtonSubmit(onClick : () -> Unit){
    Surface(
        modifier = Modifier
            .padding(top = 10.dp, start = 30.dp, end = 30.dp)
            .fillMaxWidth()
            .height(70.dp)
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
                text = "SUBMIT ORDER",
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
fun navigationTBScreen(context: Context) {
    val intent = Intent(context, ThongBaoActivity::class.java)
    context.startActivity(intent)
}




