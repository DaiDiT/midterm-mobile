package com.example.pizzarestaurant

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzarestaurant.data.DataSource.itemSelected
import com.example.pizzarestaurant.ui.theme.PizzaRestaurantTheme

class OrderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaRestaurantTheme {
                OrderFood()
            }
        }
    }
}

@Composable
fun OrderFood() {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(itemSelected.imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )
                Text(
                    text = stringResource(itemSelected.name),
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight(700),
                    modifier = Modifier
                        .padding(23.dp)
                        .align(Alignment.BottomStart)
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(23.dp)
            ) {
                Text(
                    text = stringResource(R.string.price_tag, stringResource(itemSelected.price)),
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 18.sp,
                    color = Color(0xFF733F0E),
                    fontWeight = FontWeight(700),
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer( modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(itemSelected.longDesc),
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 16.sp,
                    color = Color(0xFF733F0E),
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Justify
                )
                Spacer( modifier = Modifier.height(23.dp))
                Button(
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color(0xFFD52F2F)),
                    onClick = {
                        val intent = Intent(context, OrderDetailActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(1.dp, Color(0xFFF9B916))
                ) {
                    Text(
                        text = "Order Now",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                    )
                }
                Spacer( modifier = Modifier.height(20.dp))
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
                        text = "Back",
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

@Preview(showBackground = true)
@Composable
fun OrderPreview() {
    PizzaRestaurantTheme {
        OrderFood()
    }
}