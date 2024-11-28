package com.example.mad_practical_5_22012011067

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mad_practical_5_22012011067.screen.LoginForm
import com.example.mad_practical_5_22012011067.screen.RegisterForm
import com.example.mad_practical_5_22012011067.ui.theme.MAD_practical_5_22012011067Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MAD_practical_5_22012011067Theme {
                AppNavigation(context = this)
            }
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun LoginPreviewMain(){
//    LoginForm()
//}
@Composable
fun AppNavigation(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginForm(context,
                navController = navController,
            )
        }
        composable("registration") {
            RegisterForm(context,
                navController = navController,
            )
        }
    }
}

fun navigateToRegistrationScreen(navController: NavController) {
    navController.navigate("registration") {
        popUpTo("login") { inclusive = true }
    }
}

fun navigateToLoginScreen(navController: NavController) {
    navController.navigate("login") {
        popUpTo("registration") { inclusive = true }
    }
}
