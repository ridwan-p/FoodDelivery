package com.ridwanpa.fooddelivery.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ridwanpa.fooddelivery.ui.layouts.MainLayout
import com.ridwanpa.fooddelivery.ui.screens.*


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val menuBottom = listOf(
        Screen.HomeScreen,
        Screen.OrderScreen,
        Screen.MyListScreen,
        Screen.AccountScreen
    )

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
            MainLayout(navController = navController, menuBottom = menuBottom) {
                HomeScreen(navController)
            }
        }
        composable(Screen.OrderScreen.route) {
            MainLayout(navController = navController, menuBottom = menuBottom) {
                OrderScreen(navController)
            }
        }
        composable(Screen.AccountScreen.route) {
            MainLayout(navController = navController, menuBottom = menuBottom) {
                AccountScreen(navController)
            }
        }
        composable(Screen.ChangePasswordScreen.route) {
            MainLayout(navController = navController, menuBottom = menuBottom) {
                ChangePasswordScreen(navController)
            }
        }
        composable(Screen.PaymentSettingScreen.route) {
            MainLayout(navController = navController, menuBottom = menuBottom) {
                PaymentSettingScreen(navController)
            }
        }
        composable(Screen.PaypalScreen.route) {
            MainLayout(navController = navController, menuBottom = menuBottom) {
                PaypalScreen(navController)
            }
        }
        composable(Screen.AddPaymentScreen.route) {
            MainLayout(navController = navController, menuBottom = menuBottom) {
                AddPaymentScreen(navController)
            }
        }
        composable(Screen.MyVoucherScreen.route) {
            MainLayout(navController = navController, menuBottom = menuBottom) {
                MyVoucherScreen(navController)
            }
        }
        composable(Screen.MyListScreen.route) {
            MainLayout(navController = navController, menuBottom = menuBottom) {
                MyVoucherScreen(navController)
            }
        }
    }
}