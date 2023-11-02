package com.example.pizzarestaurant

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzarestaurant.data.DataSource.storeLocation
import com.example.pizzarestaurant.data.DataSource.username
import com.example.pizzarestaurant.ui.theme.PizzaRestaurantTheme

class StoreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaRestaurantTheme {
                StoreDesc()
            }
        }
    }
}

@Composable
fun StoreDesc() {
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(10.dp)
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
            Image(
                painter = painterResource(R.drawable.pizza_restaurant),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxHeight(0.31f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Store",
                        color = Color(0xFF733F0E),
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = storeLocation,
                        color = Color(0xFF733F0E),
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Location",
                        color = Color(0xFF733F0E),
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Find on Maps",
                            color = Color(0xFF733F0E),
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(R.drawable.location_pin),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Button(
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color(0xFFD52F2F)),
                    onClick = {
                        val intent = Intent(context, FoodMenuActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(1.dp, Color(0xFFF9B916))
                ) {
                    Text(
                        text = "See Menus",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PizzaRestaurantPreview() {
    PizzaRestaurantTheme {
        StoreDesc()
    }
}