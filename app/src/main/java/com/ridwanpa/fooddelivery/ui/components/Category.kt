package com.ridwanpa.fooddelivery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ridwanpa.fooddelivery.R

@Composable
fun Category(
    image: Int,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFECF0F1))
        ) {
            Icon(
                painter = painterResource(id = image), contentDescription = "image",
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.Center)
                    .size(32.dp),
                tint = Color.Black
            )
        }
        Text(text = label, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun CategoryPreview() {
    Category(
        image = R.drawable.cake,
        label = "Cake"
    )
}