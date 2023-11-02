package com.example.pizzarestaurant.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dish(
    @StringRes val name: Int,
    @StringRes val shortDesc: Int,
    @StringRes val longDesc: Int,
    @DrawableRes val prevImageId: Int,
    @DrawableRes val imageId: Int,
    @StringRes val price: Int
)