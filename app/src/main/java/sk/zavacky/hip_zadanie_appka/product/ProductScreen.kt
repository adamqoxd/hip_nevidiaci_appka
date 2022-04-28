package sk.zavacky.hip_zadanie_appka.product

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sk.zavacky.hip_zadanie_appka.R
import kotlin.random.Random

@Composable
fun ProductScreen(product: Product, modifier: Modifier = Modifier) {
    val rnd = Random
    Column(modifier = modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Text(modifier = modifier.padding(top = 30.dp),
            text = product.name,
            textAlign = TextAlign.Center,
            fontSize = 60.sp)
        Spacer(modifier = modifier.height(50.dp))

        Text(text = stringResource(id = R.string.composition),
            textAlign = TextAlign.Center,
            fontSize = 35.sp)
        Spacer(modifier = modifier.height(50.dp))
        LazyColumn(modifier = modifier,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(product.description) { product ->

                Text(text = "- $product", textAlign = TextAlign.Left, fontSize = 30.sp)
            }
        }
        Spacer(modifier = modifier.height(70.dp))
        Text(text = stringResource(id = R.string.allergens),
            textAlign = TextAlign.Center,
            fontSize = 35.sp)

        Spacer(modifier = modifier.height(40.dp))
        LazyRow(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            items(product.allergensIcon) { icon ->
                Icon(modifier = modifier
                    .size(50.dp)
                    .border(width = 2.dp,
                        shape = RoundedCornerShape(10.dp),
                        color = Color.Black)
                    .background(Color(0xFFFBD8B0),
                        shape = RoundedCornerShape(10.dp)),
                    painter = painterResource(id = icon),
                    contentDescription = null)
            }
        }

    }
}

@Preview
@Composable
fun ProductScreenPreview() {
    val product: Product =
        Product(name = "Rozok",
            description = listOf("Muka", "Soda", "Skorica", "Drozdie"),
            allergensIcon = listOf(
                R.drawable.ic_icon_cashew,
                R.drawable.ic_icon_eggs,
                R.drawable.ic_icon_fish,
                R.drawable.ic_icon_milk))
    ProductScreen(product = product)
}