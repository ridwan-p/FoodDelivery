package com.ridwanpa.fooddelivery.models

data class FoodModel(
    var image: Int,
    var name: String,
    var location: String,
    var long: Double,
    var lat: Double,
    var rating: Byte
)
