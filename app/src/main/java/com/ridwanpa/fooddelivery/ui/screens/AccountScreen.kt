package com.ridwanpa.fooddelivery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ridwanpa.fooddelivery.R
import com.ridwanpa.fooddelivery.routes.Screen
import com.ridwanpa.fooddelivery.ui.components.ButtonArrow
import com.ridwanpa.fooddelivery.ui.components.ButtonRounded

@Composable
fun AccountScreen(
    navController: NavController
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile), contentDescription = "profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .width(100.dp)
        )
        Text(text = "Ridwan Pamungkas", style = MaterialTheme.typography.h4)
        Text(text = "+6285868946565")
        Spacer(modifier = Modifier.height(16.dp))
        Column() {
            ButtonArrow(text = "My Profile", modifier = Modifier.fillMaxWidth(), onClick = {})
            ButtonArrow(text = "Change Password", modifier = Modifier.fillMaxWidth(), onClick = {})
            ButtonArrow(text = "Payment Settings", modifier = Modifier.fillMaxWidth(), onClick = {})
            ButtonArrow(text = "My Voucher", modifier = Modifier.fillMaxWidth(), onClick = {})
            ButtonArrow(text = "Notification", modifier = Modifier.fillMaxWidth(), onClick = {})
            ButtonArrow(text = "About Us", modifier = Modifier.fillMaxWidth(), onClick = {})
            ButtonArrow(text = "Contact Us", modifier = Modifier.fillMaxWidth(), onClick = {})
        }
        Spacer(modifier = Modifier.height(32.dp))

        ButtonRounded(
            onClick = {
                navController.navigate(Screen.HomeScreen.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign Out")
        }
    }
}