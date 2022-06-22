package com.ridwanpa.fooddelivery.ui.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ridwanpa.fooddelivery.R
import com.ridwanpa.fooddelivery.ui.theme.Blue900
import com.ridwanpa.fooddelivery.ui.theme.Gray100
import com.ridwanpa.fooddelivery.ui.theme.Warning


@Composable
fun FoodReview() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.food),
                contentDescription = "food",
                contentScale = ContentScale.Crop,

                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Dogmie jagong tutung",
                    style = MaterialTheme.typography.h4,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    IconReview(isLike = true, total = 999)
                    Spacer(
                        Modifier
                            .height(14.dp)
                            .width(1.dp)
                            .background(Color(0xFF34495E))
                    )
                    IconReview(isLike = false, total = 21)
                }
                Text(text = "Rp 20K", color = Warning)
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TotalReview(isLike = true)
            TotalReview(isLike = false)
        }
    }

}

@Composable
fun IconReview(
    total: Int,
    isLike: Boolean = true
) {
    val icon = iconReviewData(isLike)
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon.painter,
            contentDescription = icon.contentDescription,
            tint = Blue900,
            modifier = Modifier.size(16.dp)
        )
        Text(text = total.toString(), color = Blue900)
    }
    Row() {

    }
}

@Composable
fun TotalReview(
    isLike: Boolean = true
) {
    val icon = iconReviewData(isLike)

    Icon(
        painter = icon.painter,
        contentDescription = icon.contentDescription,
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(Gray100)
            .padding(4.dp),
        tint = Blue900
    )
}

@Composable
fun iconReviewData(isLike: Boolean): IconReviewData {
    return if (isLike)
        IconReviewData(
            painter = painterResource(id = R.drawable.like),
            contentDescription = "like"
        )
    else
        IconReviewData(
            painter = painterResource(id = R.drawable.dislike),
            contentDescription = "dislike"
        )
}

data class IconReviewData(
    var painter: Painter,
    var contentDescription: String
)

@Preview
@Composable
fun FoodReviewPreview() {
    FoodReview()
}