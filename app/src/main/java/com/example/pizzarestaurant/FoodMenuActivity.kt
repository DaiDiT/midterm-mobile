package com.example.pizzarestaurant

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.pizzarestaurant.data.DataSource.dishList
import com.example.pizzarestaurant.data.DataSource.itemSelected
import com.example.pizzarestaurant.data.DataSource.username
import com.example.pizzarestaurant.model.Dish
import com.example.pizzarestaurant.ui.theme.PizzaRestaurantTheme

class FoodMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaRestaurantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    FoodMenu()
                }
            }
        }
    }
}

@Composable
fun FoodMenu() {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(11.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.outline_person_38),
                contentDescription = null,
                modifier = Modifier.size(38.dp)
            )
            Text(
                text = "Hello, $username",
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Box {
            LazyColumn {
                items(dishList) {
                    DishItem(
                        dish = it,
                        modifier = Modifier.padding(14.dp)
                    )
                }
            }
            FloatingActionButton(
                onClick = { },
                shape = CircleShape,
                containerColor = Color(0xFFD52F2F),
                contentColor = Color.White,
                modifier = Modifier
                    .padding(14.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(Icons.Filled.Add, "Large floating action button")
            }
        }
    }
}


@Composable
fun DishItem(
    dish: Dish,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {
            itemSelected = dish
            val intent = Intent(context, OrderActivity::class.java)
            context.startActivity(intent)
        }
    ) {
        Image(
            painter = painterResource(dish.prevImageId),
            contentDescription = stringResource(dish.name),
            modifier = Modifier
                .size(141.dp)
        )
        Column(
            modifier = Modifier.padding(start = 14.dp)
        ) {
            Text(
                text = stringResource(dish.name),
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 16.sp,
                color = Color(0xFF733F0E),
                fontWeight = FontWeight(700),
            )
            Text(
                text = stringResource(dish.shortDesc),
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 14.sp,
                color = Color(0xFF733F0E),
                style = TextStyle(lineHeight = 1.em)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodMenuPreview() {
    PizzaRestaurantTheme {
        FoodMenu()
    }
}