package com.ridwanpa.fooddelivery.viewmodel

import androidx.lifecycle.ViewModel
import com.ridwanpa.fooddelivery.R
import com.ridwanpa.fooddelivery.models.CategoryModel
import com.ridwanpa.fooddelivery.models.FoodModel


class FoodViewModel : ViewModel() {
    var items = listOf(
        FoodModel(
            image = R.drawable.food,
            name = "Dapur Ijah Restaurant",
            location = "13 th Street, 46 W 12th St, NY",
            long = -7.8245491,
            lat = 110.3376675,
            rating = 3
        ),
        FoodModel(
            image = R.drawable.food,
            name = "Dapur Ijah Restaurant",
            location = "13 th Street, 46 W 12th St, NY",
            long = -7.8245491,
            lat = 110.3376675,
            rating = 4
        ),
        FoodModel(
            image = R.drawable.food,
            name = "Dapur Ijah Restaurant",
            location = "13 th Street, 46 W 12th St, NY",
            long = -7.8245491,
            lat = 110.3376675,
            rating = 5
        ),
    )
}