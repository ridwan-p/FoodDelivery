package com.ridwanpa.fooddelivery.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ridwanpa.fooddelivery.routes.Screen
import com.ridwanpa.fooddelivery.ui.components.ButtonRounded
import com.ridwanpa.fooddelivery.ui.components.FoodReview

@Composable
fun OrderScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
//            modifier = Modifier.weight(1f)
        ) {
            FoodReview()
            FoodReview()
            FoodReview()
            FoodReview()
        }
        ButtonRounded(
            onClick = {
                navController.navigate(Screen.HomeScreen.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Send")
        }
    }
}
