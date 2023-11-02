package com.example.pizzarestaurant.data

import com.example.pizzarestaurant.R
import com.example.pizzarestaurant.model.Dish

object DataSource {
    val dishList = listOf(
        Dish(
            R.string.pepperoni_pizza_title,
            R.string.pepperoni_pizza_short_description,
            R.string.pepperoni_pizza_long_description,
            R.drawable.pepperoni_pizza_preview,
            R.drawable.pepperoni_pizza,
            R.string.pepperoni_pizza_price),
        Dish(
            R.string.spaghetti_title,
            R.string.spaghetti_short_description,
            R.string.spaghetti_long_description,
            R.drawable.spaghetti_preview,
            R.drawable.spaghetti,
            R.string.spaghetti_price),
        Dish(
            R.string.burger_title,
            R.string.burger_short_description,
            R.string.burger_long_description,
            R.drawable.burger_preview,
            R.drawable.burger,
            R.string.burger_price),
        Dish(
            R.string.steak_title,
            R.string.steak_short_description,
            R.string.steak_long_description,
            R.drawable.steak_preview,
            R.drawable.steak,
            R.string.steak_price),
        Dish(
            R.string.french_fries_title,
            R.string.french_fries_short_description,
            R.string.french_fries_long_description,
            R.drawable.french_fries_preview,
            R.drawable.french_fries,
            R.string.french_fries_price)
    )
    var username = "Unknown"
    var storeLocation = "Unspesified"
    var itemSelected: Dish = dishList[0]
}