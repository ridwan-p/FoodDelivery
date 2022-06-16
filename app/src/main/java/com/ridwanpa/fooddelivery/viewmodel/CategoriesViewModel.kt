package com.ridwanpa.fooddelivery.viewmodel

import androidx.lifecycle.ViewModel
import com.ridwanpa.fooddelivery.R
import com.ridwanpa.fooddelivery.models.CategoryModel


class CategoriesViewModel:ViewModel() {
    var items = listOf(
        CategoryModel(image = R.drawable.coffee_cup, label = "Drink" ),
        CategoryModel(image = R.drawable.burger, label = "Burger" ),
        CategoryModel(image = R.drawable.cake, label = "Cake" ),
        CategoryModel(image = R.drawable.potato_chips, label = "Snack" )
    )
}