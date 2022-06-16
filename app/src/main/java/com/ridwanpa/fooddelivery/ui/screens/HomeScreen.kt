package com.ridwanpa.fooddelivery.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ridwanpa.fooddelivery.R
import com.ridwanpa.fooddelivery.ui.components.Category
import com.ridwanpa.fooddelivery.ui.components.Food
import com.ridwanpa.fooddelivery.ui.components.FoodMenu
import com.ridwanpa.fooddelivery.ui.components.InputField
import com.ridwanpa.fooddelivery.viewmodel.CategoriesViewModel
import com.ridwanpa.fooddelivery.viewmodel.FoodMenuViewModel
import com.ridwanpa.fooddelivery.viewmodel.FoodViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    categoriesViewModel: CategoriesViewModel = viewModel(),
    foodMenuViewModel: FoodMenuViewModel = viewModel(),
    foodViewModel: FoodViewModel = viewModel()
) {
    var search by remember {
        mutableStateOf("")
    }
//    Log.d("testing", foodMenuViewModel.generateMultiRow().toString())

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            InputField(
                value = search,
                onValueChange = { search = it },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search",
                        modifier = Modifier.size(20.dp)
                    )
                },
                placeholder = { Text(text = "Search") },
                modifier = Modifier.fillMaxWidth()
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.pin),
                    contentDescription = "pin",
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "Pelemsewu No 354 RT 07, Yogyakarta",
                    style = MaterialTheme.typography.body2
                )
            }
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(categoriesViewModel.items) {
                Category(image = it.image, label = it.label)
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Food Menu", style = MaterialTheme.typography.h3)
                Text(text = "View all")
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(foodMenuViewModel.generateMultiRow()) { menu ->
                    Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                        menu.second.forEach {
                            FoodMenu(image = it.image)
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Near Me", style = MaterialTheme.typography.h3)
                Text(text = "View all")
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                foodViewModel.items.forEach { food ->
                    Food(food = food)
                }
            }
        }
    }
}