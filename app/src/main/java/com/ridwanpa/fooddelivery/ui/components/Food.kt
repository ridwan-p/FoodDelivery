package com.ridwanpa.fooddelivery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridwanpa.fooddelivery.R
import com.ridwanpa.fooddelivery.models.FoodModel
import com.ridwanpa.fooddelivery.ui.theme.Blue900

@Composable
fun Food(
    food: FoodModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Image(
            painter = painterResource(id = food.image),
            contentDescription = "photo",
            modifier = Modifier.size(130.dp)
        )
        Column() {
            Text(text = food.name, style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.pin),
                    contentDescription = "pin",
                    tint = Blue900,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = food.location,
                    style = MaterialTheme.typography.subtitle1,
                    color = Blue900,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "pin",
                    tint = Blue900,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "3 min - 1.1 km",
                    style = MaterialTheme.typography.subtitle1,
                    color = Blue900,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Rating(value = food.rating)
        }
    }
}