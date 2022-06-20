package com.ridwanpa.fooddelivery.routes

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ridwanpa.fooddelivery.ui.layouts.MainLayout
import com.ridwanpa.fooddelivery.ui.layouts.TobBar
import com.ridwanpa.fooddelivery.ui.screens.*


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.OrderScreen.route) {
        composable(Screen.SignInScreen.route) {
            SignInScreen(navController)
        }
        composable(Screen.SignUpScreen.route) {

            SignUpScreen(navController)
        }
        composable(Screen.ForgotPasswordScreen.route) {
            ForgotPasswordScreen(navController)
        }

        composable(Screen.HomeScreen.route) {
            MainLayout(navController = navController) {
                HomeScreen(navController)
            }
        }
        composable(Screen.OrderScreen.route) {
            MainLayout(
                navController = navController,
                topBar = { TobBar(title = "Order", navController =navController )                }
            ) {
                OrderScreen(navController)
            }
        }
        composable(Screen.AccountScreen.route) {
            MainLayout(navController = navController) {
                AccountScreen(navController)
            }
        }
        composable(Screen.ChangePasswordScreen.route) {
            MainLayout(navController = navController) {
                ChangePasswordScreen(navController)
            }
        }
        composable(Screen.PaymentSettingScreen.route) {
            MainLayout(navController = navController) {
                PaymentSettingScreen(navController)
            }
        }
        composable(Screen.PaypalScreen.route) {
            MainLayout(navController = navController) {
                PaypalScreen(navController)
            }
        }
        composable(Screen.AddPaymentScreen.route) {
            MainLayout(navController = navController) {
                AddPaymentScreen(navController)
            }
        }
        composable(Screen.MyVoucherScreen.route) {
            MainLayout(navController = navController) {
                MyVoucherScreen(navController)
            }
        }
        composable(Screen.MyListScreen.route) {
            MainLayout(navController = navController) {
                MyVoucherScreen(navController)
            }
        }
    }
}