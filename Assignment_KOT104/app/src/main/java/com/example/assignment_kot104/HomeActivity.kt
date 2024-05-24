package com.example.assignment_kot104

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentApp()
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
        modifier = Modifier.height(620.dp)

    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Two columns
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .height(650.dp)
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
    val context = LocalContext.current
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
                .clickable { navigateToProScreen(context) }
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
fun navigateToProScreen(context: Context) {
    val intent = Intent(context, ProductActivity::class.java)
    context.startActivity(intent)
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AssignmentApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        NavigationGraph(navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Cart,
        NavigationItem.Profile,
        NavigationItem.Tb
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}



@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) { HomeActivity() }
        composable(NavigationItem.Cart.route) { CardActivity() }
        composable(NavigationItem.Profile.route) { ProfileScreen() }
        composable(NavigationItem.Tb.route){ThongBaoActivity()}
    }
}

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Default.Home, "")
    object Cart : NavigationItem("cart", Icons.Default.FavoriteBorder, "")
    object Tb : NavigationItem("profile", Icons.Default.Notifications, "")
    object Profile : NavigationItem("tb", Icons.Default.Person, "")

}
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Screen", fontSize = 20.sp)
    }
}

@Composable
fun CartScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cart Screen", fontSize = 20.sp)
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile Screen", fontSize = 20.sp)
    }
}



