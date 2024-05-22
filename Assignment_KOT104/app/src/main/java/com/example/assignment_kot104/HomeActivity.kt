package com.example.assignment_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           getLayoutHome()
        }
    }
}
val customFont3 = FontFamily(
    Font(R.font.nunotosan1, FontWeight.Bold)
)
@Preview
@Composable
fun getLayoutHome(){
    Column {
        getHeaderHome()
        ProductListScreen()
    }
}

@Composable
fun getHeaderHome() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,  // Align items vertically centered in the Row
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 30.dp, end = 30.dp) // Added end padding
        ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search Icon",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp)) // Space between Image and Column
            Column(
                modifier = Modifier.weight(1f) // Column takes up the remaining space
            ) {
                Text(
                    text = "Make Home",
                    style = TextStyle(
                        fontFamily = customFontFamily,
                        fontSize = 18.sp,
                        color = Color("#909090".toColorInt()),
                        lineHeight = 45.sp
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally) // Center horizontally within Column
                )
                Text(
                    text = "BEAUTIFUL",
                    style = TextStyle(
                        fontFamily = customFontFamily,
                        fontSize = 18.sp,
                        color = Color("#303030".toColorInt()),
                        lineHeight = 45.sp
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally) // Center horizontally within Column
                )
            }
            Spacer(modifier = Modifier.width(8.dp)) // Space between Column and new Image
            Image(
                painter = painterResource(id = R.drawable.cart), // Replace with your image resource
                contentDescription = "New Image",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen() {
    val products = getProducts() // Hàm lấy danh sách sản phẩm

    Scaffold(

    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Two columns
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(products) { product ->
                ProductItem(product = product)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .width(300.dp)
//            .padding(horizontal = 16.dp, vertical = 8.dp)
            ,
        elevation = CardDefaults.cardElevation(0.dp), // Set elevation
        colors = CardDefaults.cardColors(containerColor = Color("#fffbfe".toColorInt()))
    ) {
        Column(
            modifier = Modifier
                .clickable { /* Xử lý khi click vào sản phẩm */ }
//                .padding(16.dp),

        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.name,
                modifier = Modifier
                    .size(300.dp)
            )



            Column {
                Text(text = product.name,
                    style = TextStyle(
                        fontFamily = customFontFamily2,
                        fontSize = 18.sp,
                        lineHeight = 19.1.sp,
                        color = Color("#606060".toColorInt())
                    )
                    )
                Text(text = product.price,
                    style = TextStyle(
                        fontFamily = customFont3,
                        fontSize = 18.sp,
                        lineHeight = 19.1.sp,
                        color = Color("#303030".toColorInt())
                    ))
            }
        }
    }
}

data class Product(val id: Int, val name: String, val price: String, val image: Int)

fun getProducts(): List<Product> {
    // Lấy danh sách sản phẩm từ cơ sở dữ liệu hoặc API
    // Thay thế bằng logic lấy dữ liệu thực tế của bạn
    return listOf(
        Product(1, "Black Simple Lamp", "$12.00", R.drawable.img1),
        Product(2, "Minimal Stand", "$25.00", R.drawable.img2),
        Product(3, "Coffee Chair", "$20.00", R.drawable.img3),
        Product(4, "Simple Desk", "$50.00", R.drawable.img4)
    )
}


