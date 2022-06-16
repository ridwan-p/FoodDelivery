package com.ridwanpa.fooddelivery.routes

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import com.ridwanpa.fooddelivery.R

sealed class Screen(
    val route: String,
    @StringRes val icon: Int? = null,
    val label: String? = null,
) {
    object SignInScreen : Screen(route = "sign_in", icon = null)
    object SignUpScreen : Screen(route = "sign_up", icon = null)
    object ForgotPasswordScreen : Screen(route = "forgot_password", icon = null)

    @SuppressLint("ResourceType")
    object HomeScreen : Screen(route = "home", icon = R.drawable.store, label = "Home")

    @SuppressLint("ResourceType")
    object OrderScreen : Screen(route = "order", icon = R.drawable.order, label = "Order")

    @SuppressLint("ResourceType")
    object AccountScreen : Screen(route = "account", icon = R.drawable.account, label = "Account")
    object ChangePasswordScreen : Screen(route = "change_password", icon = null)
    object PaymentSettingScreen : Screen(route = "payment_setting", icon = null)
    object PaypalScreen : Screen(route = "paypal", icon = null)
    object AddPaymentScreen : Screen(route = "add_payment", icon = null)
    object MyVoucherScreen : Screen(route = "my_voucher", icon = null)

    @SuppressLint("ResourceType")
    object MyListScreen : Screen(route = "my_list", icon = R.drawable.mylist, label = "My List")

}
