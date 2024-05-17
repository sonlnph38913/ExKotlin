package com.example.slide3_jc

import android.annotation.SuppressLint
import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bai5 : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayout()
        }
    }

}

@Preview
@Composable
private fun GetLayout () {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GetTextTitle("Thanh Toán")

        GetRowItem(color = Color.Blue,R.drawable.ic_logo_paypal,"Paypal")

        GetRowItem(color = Color.Cyan,R.drawable.ic_logo_visa,"Visa")

        GetRowItem(color = Color.Yellow,R.drawable.ic_logo_momo,"Momo")

        GetRowItem(color = Color.DarkGray,R.drawable.ic_logo_zalopay,"ZaloPay")
    }
}

@Composable
private fun GetRowItem (color: Color, idRes : Int =R.drawable.ic_logo_momo , title: String = "paypal") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(color, shape = RoundedCornerShape(10.dp))
            .height(70.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Image(painter = painterResource(id = idRes), contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp, 0.dp, 0.dp, 0.dp))
        Text(text = title,
            modifier = Modifier
                .weight(1f)
                .padding(50.dp, 0.dp, 0.dp)
            ,color = Color.White
            )
        RadioButton(selected = false, onClick = {

        })
    }
}

@Composable
private fun GetTextTitle(title: String = "Trang chu") {
    Text(
        text = title,
        fontSize = 40.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(0.dp, 16.dp)
            .fillMaxWidth()
    )
}


