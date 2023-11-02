@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzarestaurant.data.DataSource.storeLocation
import com.example.pizzarestaurant.data.DataSource.username
import com.example.pizzarestaurant.ui.theme.PizzaRestaurantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaRestaurantTheme {
                PizzaRestaurantApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaRestaurantApp() {
    val context = LocalContext.current
    val storeOptions = listOf("Cihampelas", "Cibiru")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(storeOptions[0]) }

    var name by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(45.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter =  painterResource(R.drawable.pizza_restaurant_logo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(223.dp)
                    .height(264.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(
                modifier = Modifier.height(55.dp)
            )
            Text(
                text = "Store",
                color = Color(0xFF733F0E),
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.padding(start = 5.dp)
            )

            storeOptions.forEach { text ->
                ElevatedButton(
                    shape = RectangleShape,
                    onClick = { onOptionSelected(text) },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = Color.White)
                        .shadow(elevation = 4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = text,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400)
                        )
                        if (text == selectedOption) {
                            Image(
                                painter = painterResource(R.drawable.baseline_arrow_drop_down_31),
                                contentDescription = null
                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Your Name",
                color = Color(0xFF733F0E),
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.padding(start = 5.dp)
            )
            TextField(
                value = name,
                onValueChange = { name = it },
                label = @Composable {
                    Text(
                        text = "Please fill your name",
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700)
                    )
                },
                shape = RectangleShape,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .shadow(elevation = 4.dp)
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Button(
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Color(0xFFD52F2F)),
                onClick = {
                    if (name != "") {
                        username = name
                    }
                    storeLocation = selectedOption
                    val intent = Intent(context, StoreActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(1.dp, Color(0xFFF9B916))
            ) {
                Text(
                    text = "Submit",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PizzaRestaurantAppPreview() {
    PizzaRestaurantTheme {
        PizzaRestaurantApp()
    }
}