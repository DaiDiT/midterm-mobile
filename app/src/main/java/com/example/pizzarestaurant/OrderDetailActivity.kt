package com.example.pizzarestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.pizzarestaurant.data.DataSource.itemSelected
import com.example.pizzarestaurant.data.DataSource.storeLocation
import com.example.pizzarestaurant.data.DataSource.username
import com.example.pizzarestaurant.ui.theme.PizzaRestaurantTheme

class OrderDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaRestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    OrderDish()
                }
            }
        }
    }
}

@Composable
fun OrderDish() {
    val deliveryOptions = listOf("Ambil sendiri", "Fast Delivery (minimal 30 menit sampai)")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(deliveryOptions[0]) }

    var isOrderCreated by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(
            text = "Order Detail",
            color = Color(0xFF733F0E),
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontSize = 20.sp,
            fontWeight = FontWeight(700)
        )
        Text(
            text = stringResource(
                R.string.order_detail_text,
                username,
                storeLocation,
                stringResource(itemSelected.name)
            ),
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontSize = 16.sp,
            color = Color.Black,
            style = TextStyle(lineHeight = 1.em),
            modifier = Modifier.padding(start = 5.dp, top = 15.dp, bottom = 20.dp)
        )
        Text(
            text = "Pengiriman",
            color = Color(0xFF733F0E),
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontSize = 20.sp,
            fontWeight = FontWeight(700)
        )
        deliveryOptions.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, top = 15.dp, bottom = 10.dp)
            ) {
                Box{
                    Button(
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color(0xFFC4C4C4)),
                        onClick = {
                            isOrderCreated = false
                            onOptionSelected(text)
                        },
                        modifier = Modifier.size(25.dp)
                    ) {}
                    if (text == selectedOption) {
                        Image(
                            painter = painterResource(R.drawable.baseline_check_25),
                            contentDescription = null
                        )
                    }
                }
                Text(
                    text = text,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    style = TextStyle(lineHeight = 1.em),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { onOptionSelected(text) }
                )
                Spacer(modifier = Modifier.height(5.dp))
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color(0xFFD52F2F)),
            onClick = { isOrderCreated = !isOrderCreated },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(1.dp, Color(0xFFF9B916))
        ) {
            Text(
                text = "Done",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        AnimatedVisibility(
            visible = isOrderCreated,
            enter = slideInVertically(animationSpec = tween(durationMillis = 500)) { fullWidth ->
                -fullWidth / 3
            } + fadeIn(
                animationSpec = tween(durationMillis = 1100)
            ),
            exit = slideOutVertically(animationSpec = spring(stiffness = Spring.StiffnessMediumLow)) {
                200
            } + fadeOut(
                animationSpec = tween(durationMillis = 200)
            ),
        ) {
            Text(
                text = if (selectedOption == deliveryOptions[0]) stringResource(
                    R.string.toast_message_1,
                    username,
                    stringResource(itemSelected.name)
                ) else stringResource(
                    R.string.toast_message_2,
                    username,
                    stringResource(itemSelected.name)
                ),
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                style = TextStyle(lineHeight = 1.em),
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .background(Color(0xFFC4C4C4))
                    .border(1.dp, Color(0xFFD52F2F))
                    .padding(14.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderDetailPreview() {
    PizzaRestaurantTheme {
        OrderDish()
    }
}