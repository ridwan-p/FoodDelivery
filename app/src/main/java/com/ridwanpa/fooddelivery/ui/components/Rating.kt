package com.ridwanpa.fooddelivery.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ridwanpa.fooddelivery.ui.theme.Gray100
import com.ridwanpa.fooddelivery.ui.theme.Yellow

@Composable
fun Rating(
    value: Byte,
    modifier: Modifier = Modifier
) {

    Row(modifier) {
        for (i in 0..4) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = if (i <= value) Yellow else Gray100,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}