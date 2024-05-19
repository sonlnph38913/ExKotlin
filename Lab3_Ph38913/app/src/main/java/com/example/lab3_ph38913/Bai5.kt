package com.example.lab3_ph38913

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

private data class ItemThanhToan(var color: Color, var idRes: Int, var title: String)

class Bai5 : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var selectedMethod by remember { mutableStateOf<ItemThanhToan?>(null) }

            Scaffold(
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color("#242121".toColorInt()),
                            titleContentColor = Color.White,
                        ),
                        title = { GetTextTitle("Thanh Toán") }
                    )
                },
                bottomBar = {
                    BottomNavigationBar(navController)
                },
                snackbarHost = {
                    // Placeholder cho SnackbarHost
                }
            ) { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    GetLayout(
                        selectedMethod = selectedMethod,
                        onMethodSelected = { method ->
                            selectedMethod = method
                        }
                    )
                    Spacer(modifier = Modifier.height(56.dp)) // Chiều cao của bottom navigation bar
                }
            }
        }
    }

    @Composable
    private fun GetLayout(
        selectedMethod: ItemThanhToan? = null,
        onMethodSelected: (ItemThanhToan) -> Unit
    ) {
        val listItemThanhToan: MutableList<ItemThanhToan> = mutableListOf(
            ItemThanhToan(Color("#EB8B33".toColorInt()), R.drawable.ic_logo_paypal, "Paypal"),
            ItemThanhToan(Color.White, R.drawable.ic_logo_visa, "Visa"),
            ItemThanhToan(Color("#D93485".toColorInt()), R.drawable.ic_logo_momo, "Momo"),
            ItemThanhToan(Color("#57BFF7".toColorInt()), R.drawable.ic_logo_zalopay, "Zalo Pay"),
            ItemThanhToan(Color("#EB8B33".toColorInt()), R.drawable.ic_logo_paypal, "Paypal"),
            ItemThanhToan(Color.White, R.drawable.ic_logo_visa, "Visa"),
            ItemThanhToan(Color("#D93485".toColorInt()), R.drawable.ic_logo_momo, "Momo"),
            ItemThanhToan(Color("#57BFF7".toColorInt()), R.drawable.ic_logo_zalopay, "Zalo Pay")
        )

        val context = LocalContext.current

        Column(
            modifier = Modifier
                .background(color = Color("#2A2727".toColorInt()))
                .fillMaxSize()
                .padding(24.dp)
        ) {
            GetLayoutDiaChiNhanHang()

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(listItemThanhToan) { itemThanhToan ->
                    GetRowItem(
                        itemThanhToan.color,
                        itemThanhToan.idRes,
                        itemThanhToan.title,
                        selectedMethod == itemThanhToan,
                        onSelected = { onMethodSelected(itemThanhToan) }
                    )
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color("#ED7B57".toColorInt())),
                onClick = {
                    Toast.makeText(
                        context,
                        selectedMethod?.title ?: "Chưa chọn phương thức thanh toán",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) {
                Text(text = "Thanh Toán", color = Color.White)
            }
        }
    }

    @Composable
    private fun GetRowItem(
        color: Color,
        idRes: Int = R.drawable.ic_logo_momo,
        title: String = "Paypal",
        selected: Boolean,
        onSelected: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = color, shape = RoundedCornerShape(12.dp))
                .height(70.dp)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = idRes),
                contentDescription = "",
                modifier = Modifier.size(60.dp)
            )

            Text(
                text = title,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 30.dp),
                color = Color.Black,
                fontSize = 20.sp
            )

            RadioButton(selected = selected, onClick = onSelected)
        }
    }

    @Composable
    fun GetLayoutDiaChiNhanHang() {
        Column(modifier = Modifier.fillMaxWidth()) {
            GetTextContent(text = "Địa chỉ nhận hàng")
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Image(
                    Icons.Default.LocationOn,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Magenta)
                )
                Column {
                    GetTextContent(text = "Tri | 222222")
                    GetTextContent(text = "22/153 Tân Thới Tây")
                    GetTextContent(text = "Quận 12")
                    GetTextContent(text = "TP HCM")
                }
            }
            GetTextContent(text = "Chọn phương thức thanh toán")
        }
    }

    @Composable
    fun GetTextContent(text: String) {
        Text(
            text = text,
            color = Color.White
        )
    }

    @Composable
    private fun GetTextTitle
                (title: String = "Trang chủ") {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .fillMaxWidth()
        )
    }

    sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
        object Home : NavigationItem("home", Icons.Default.Home, "Trang Chủ")
        object Cart : NavigationItem("cart", Icons.Default.ShoppingCart, "Giỏ Hàng")
        object Profile : NavigationItem("profile", Icons.Default.Person, "Hồ Sơ")
    }

    @Composable
    fun BottomNavigationBar(navController: NavHostController) {
        val items = listOf(
            NavigationItem.Home,
            NavigationItem.Cart,
            NavigationItem.Profile
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
            composable(NavigationItem.Home.route) { HomeScreen() }
            composable(NavigationItem.Cart.route) { CartScreen() }
            composable(NavigationItem.Profile.route) { ProfileScreen() }
        }
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
}
