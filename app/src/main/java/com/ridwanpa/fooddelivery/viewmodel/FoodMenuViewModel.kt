package com.ridwanpa.fooddelivery.viewmodel

import androidx.lifecycle.ViewModel
import com.ridwanpa.fooddelivery.R
import com.ridwanpa.fooddelivery.models.FoodMenuModel


typealias FoodMenuVector = List<FoodMenuModel>

class FoodMenuViewModel : ViewModel() {
    private var items = listOf(
        FoodMenuModel(image = R.drawable.burgers, label = "Burgers"),
        FoodMenuModel(image = R.drawable.pizza, label = "Pizza"),
        FoodMenuModel(image = R.drawable.bbq, label = "BBQ"),
        FoodMenuModel(image = R.drawable.fruit, label = "Fruit"),
        FoodMenuModel(image = R.drawable.sushi, label = "Sushi"),
        FoodMenuModel(image = R.drawable.noodle, label = "Noodle"),
    )

    fun generateMultiRow(row: Int = 2): List<Pair<Int, FoodMenuVector>> {
        val n = items.size / row
        return items.withIndex()
            .groupBy(keySelector = { it.index % n }, valueTransform = { it.value })
            .toList()
    }
}