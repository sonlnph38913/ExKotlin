package com.example.assignment_kot104

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayoutCard()
        }
    }
}
@Preview
@Composable
fun GetLayoutCard(){
    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        getHeaderCard()
        ProductListCard()
        getFooter()
        getButtonCheckOut {
            navigateCheckOutScreen(context)
        }
    }
}

@Composable
fun getHeaderCard(){
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
            text = "My Card",
            style = TextStyle(
                fontFamily = customFont1,
                fontSize = 18.sp,
                color = Color("#303030".toColorInt()),
                lineHeight = 45.sp
            ),
            modifier = Modifier
                .weight(1f) // Đảm bảo text chiếm không gian còn lại của dòng
                .padding(horizontal = 15.dp)
        )
    }
}

@Composable
fun ProductListCard() {
    val productCard = getProductCard() // Hàm lấy danh sách sản phẩm

    Scaffold(
        modifier = Modifier
            .size(550.dp)
            .background(color = Color("#FFFFFF".toColorInt()))

    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(1), // Two columns
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
//                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(productCard) { productCard ->
                ProductItemCard(productCard = productCard)
            }
        }
    }
}


@Composable
fun ProductItemCard(productCard: ProductCard) {

    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            elevation = CardDefaults.cardElevation(0.dp),
            colors = CardDefaults.cardColors(containerColor = Color("#fffbfe".toColorInt()))
        ) {
            Box {
                Row(
                    modifier = Modifier
                        .clickable { }
                        .fillMaxWidth()
                        .padding(end = 40.dp) // Thêm khoảng trống cho ảnh "cancel"
                ) {
                    Image(
                        painter = painterResource(id = productCard.image),
                        contentDescription = productCard.name,
                        modifier = Modifier
                            .size(100.dp)
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = productCard.name,
                            style = TextStyle(
                                fontFamily = customFontFamily2,
                                fontSize = 18.sp,
                                lineHeight = 19.1.sp,
                                color = Color("#606060".toColorInt())
                            )
                        )
                        Text(
                            text = productCard.price,
                            style = TextStyle(
                                fontFamily = customFont3,
                                fontSize = 18.sp,
                                lineHeight = 19.1.sp,
                                color = Color("#242424".toColorInt())
                            ),

                        )
                        Row(
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.add),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .size(30.dp)
                            )
                            Text(
                                text = "01",
                                style = TextStyle(
                                    fontFamily = customFontFamily2,
                                    fontSize = 25.sp,
                                    lineHeight = 30.47.sp,
                                    color = Color("#303030".toColorInt())
                                ),
                                modifier = Modifier
                                    .padding(top = 10.dp, start = 15.dp)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.remove),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(start = 15.dp, top = 10.dp)
                                    .size(30.dp)
                            )
                        }
                    }
                }
                Image(
                    painter = painterResource(R.drawable.cancel),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.TopEnd)
                        .padding(8.dp) // Thêm padding để không bị sát lề
                )
            }
        }

        Divider(
            color = Color("#E0E0E0".toColorInt()),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
        )
    }

}



data class ProductCard(val id: Int, val name: String, val price: String, val image: Int)

fun getProductCard(): List<ProductCard> {
    return listOf(
        ProductCard(1, "Black Simple Lamp", "$12.00", R.drawable.img1),
        ProductCard(2, "Minimal Stand", "$25.00", R.drawable.img2),
        ProductCard(3, "Coffee Chair", "$20.00", R.drawable.img3),
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getFooter(){
    var code by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
//            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .shadow(8.dp, shape = RoundedCornerShape(4.dp))
                .background(Color.White, shape = RoundedCornerShape(4.dp))
                .height(60.dp)
        ) {
            OutlinedTextField(
                value = code,
                onValueChange = { code = it },
                label = {
                    Text(
                        "Enter your promo code",
                        style = TextStyle(
                            fontFamily = customFont2,
                            fontSize = 14.sp,
                            color = Color("#909090".toColorInt()),
                            lineHeight = 19.sp
                        )
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .background(Color.White, shape = RoundedCornerShape(4.dp)),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.width(8.dp))

           getButtonCode {

           }
        }
        Row (
            modifier = Modifier.padding(top = 20.dp)
        ){
            Text(
                text = "Total :",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 18.sp,
                    color = Color("#808080".toColorInt()),
                    lineHeight = 45.sp
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)
            )
            Text(
                text = "$ 95.00",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 18.sp,
                    color = Color("#808080".toColorInt()),
                    lineHeight = 45.sp
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 60.dp)
            )
        }
    }

}
@Composable
fun getButtonCode(onClick : () -> Unit){
    Surface(
        modifier = Modifier
            .width(60.dp)
            .height(50.dp)
            .clickable(onClick = onClick),
        color = Color(0xFF242424),
        contentColor = Color.White,
        shape = MaterialTheme.shapes.small
    ) {
        Box(
//            modifier = Modifier
//                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = ">",
                style = TextStyle(
                    fontFamily = customFont1,
                    fontSize = 28.sp,
                    lineHeight = 22.85.sp,
                    color = Color.White
                )

            )

        }
    }
}
@Composable
fun getButtonCheckOut(onClick: () -> Unit){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(top = 10.dp, start = 30.dp, end = 30.dp)
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
                text = "Check Out",
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
fun navigateCheckOutScreen(context: Context) {
    val intent = Intent(context, CheckOutActivity::class.java)
    context.startActivity(intent)
}