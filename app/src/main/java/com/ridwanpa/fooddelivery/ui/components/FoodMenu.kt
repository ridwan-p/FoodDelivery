package com.ridwanpa.fooddelivery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ridwanpa.fooddelivery.models.FoodModel
import com.ridwanpa.fooddelivery.ui.theme.Blue900

@Composable
fun FoodMenu(image: Int) {

    Image(
        painter = painterResource(id = image),
        contentDescription = "image",
        modifier = Modifier.size(130.dp),
    )
}