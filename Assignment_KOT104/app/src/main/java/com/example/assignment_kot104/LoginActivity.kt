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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.assignment_kot104.ui.theme.Assignment_KOT104Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_KOT104Theme {
                LoginScreen()
            }
        }
    }
}

val customFont1 = FontFamily(
    Font(R.font.merriweather, FontWeight.Normal)
)
val customFont2 = FontFamily(
    Font(R.font.merriweatherlight, FontWeight.Normal)
)

@Preview
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header()
        Title()
        Content()
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)
    ) {
        Divider(
            color = Color("#BDBDBD".toColorInt()), // Màu của đường kẻ
            thickness = 1.dp,
            modifier = Modifier
                .width(130.dp)
                .padding(top = 30.dp, start = 15.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.group),
            contentDescription = "My Image",
            modifier = Modifier
                .width(63.96.dp)
                .height(63.96.dp)
                .align(Alignment.Center)
        )

        Divider(
            color = Color("#BDBDBD".toColorInt()), // Màu của đường kẻ
            thickness = 1.dp,
            modifier = Modifier
                .width(130.dp)
                .padding(top = 30.dp, end = 15.dp)
                .align(Alignment.TopEnd)
        )
    }
}

@Composable
fun Title() {
    Column {
        Text(
            text = "Hello !",
            style = TextStyle(
                fontFamily = customFont2,
                fontSize = 30.sp,
                color = Color("#909090".toColorInt()),
                lineHeight = 45.sp
            ),
            modifier = Modifier.padding(start = 30.dp, top = 30.dp)
        )
        Text(
            text = "WELCOME BACK",
            style = TextStyle(
                fontFamily = customFont1,
                fontSize = 24.sp,
                color = Color("#303030".toColorInt()),
                lineHeight = 45.sp
            ),
            modifier = Modifier.padding(start = 30.dp, top = 10.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content() {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .height(520.dp)
            .fillMaxWidth()
            .padding(top = 30.dp, end = 30.dp)
            .shadow(8.dp, shape = RectangleShape)
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            "Email",
                            style = TextStyle(
                                fontFamily = customFont2,
                                fontSize = 14.sp,
                                color = Color("#909090".toColorInt()),
                                lineHeight = 19.sp
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .padding(start = 15.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Divider(
                    color = Color("#E0E0E0".toColorInt()),
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(start = 30.dp, end = 30.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            "Password",
                            style = TextStyle(
                                fontFamily = customFont2,
                                fontSize = 14.sp,
                                color = Color("#909090".toColorInt()),
                                lineHeight = 19.sp
                            )
                        )
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            painterResource(id = R.drawable.ic_visibility)
                        else painterResource(id = R.drawable.ic_visibility_off)

                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(painter = image, contentDescription = null)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .padding(start = 15.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Divider(
                    color = Color("#E0E0E0".toColorInt()),
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp)
                        .align(Alignment.BottomCenter)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Forgot Password",
                style = TextStyle(
                    fontFamily = customFont2,
                    fontSize = 18.sp,
                    color = Color("#303030".toColorInt()),
                    lineHeight = 24.55.sp
                ),
                modifier = Modifier.padding(top = 30.dp)
            )

            GetLoginButton {
                navigateToHomeScreen(context)
            }
            getSignUp {
                navRegisterScreen(context)
            }
        }
    }
}

@Composable
fun GetLoginButton(onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .padding(top = 65.dp, start = 30.dp, end = 30.dp)
            .width(285.dp)
            .height(50.dp)
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
                text = "Log in",
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

private fun navigateToHomeScreen(context: Context) {
    val intent = Intent(context, HomeActivity::class.java)
    context.startActivity(intent)
}
@Composable
private fun getSignUp(onClick: () -> Unit){
    Column {
    Text(text = "SIGN UP",
        style = TextStyle(
            fontFamily = customFontFamily2,
            fontSize = 22.sp,
            lineHeight = 24.55.sp,

        ),
        modifier = Modifier
            .padding(top = 70.dp)
            .clickable(onClick = onClick)
        )
    }
}
private fun navRegisterScreen(context: Context) {
    val intent = Intent(context, RegisterActivity::class.java)
    context.startActivity(intent)
}
