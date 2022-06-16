package com.ridwanpa.fooddelivery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ridwanpa.fooddelivery.R
import com.ridwanpa.fooddelivery.routes.Screen
import com.ridwanpa.fooddelivery.ui.components.ButtonRounded
import com.ridwanpa.fooddelivery.ui.components.InputField
import com.ridwanpa.fooddelivery.ui.theme.Blue900

@Composable
fun ForgotPasswordScreen(
    navController: NavController
) {
    var email by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.width(200.dp)
        )
        Column() {
            Text(text = "Forgot Password", style = MaterialTheme.typography.h2)
            Spacer(modifier = Modifier.height(8.dp))
            InputField(
                value = email,
                onValueChange = { email = it },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Email") }
            )
            Spacer(modifier = Modifier.height(24.dp))
            ButtonRounded(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Send")
            }
        }
    }
}
