package com.ridwanpa.fooddelivery.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ridwanpa.fooddelivery.R


val fontFamily = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_medium, weight = FontWeight.Medium),
    Font(R.font.poppins_semibold, weight = FontWeight.SemiBold),
    Font(R.font.poppins_bold, weight = FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    h2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h4 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h5 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    h6 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    button = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
)