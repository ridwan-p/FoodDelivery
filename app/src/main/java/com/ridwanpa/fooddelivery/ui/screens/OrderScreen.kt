package com.ridwanpa.fooddelivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ridwanpa.fooddelivery.ui.components.FoodReview

@Composable
fun OrderScreen(
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        FoodReview()
        FoodReview()
        FoodReview()
        FoodReview()
        FoodReview()
        FoodReview()
        FoodReview()
        FoodReview()
        FoodReview()
    }
}
