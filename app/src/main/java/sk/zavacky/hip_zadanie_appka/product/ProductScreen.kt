package sk.zavacky.hip_zadanie_appka.product

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import sk.zavacky.hip_zadanie_appka.R
import sk.zavacky.hip_zadanie_appka.destinations.CameraPreviewDestination
import kotlin.random.Random

@Composable
fun ProductScreen(navigator: DestinationsNavigator,product: Product, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Text(modifier = modifier.padding(top = 10.dp),
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
        Spacer(modifier = modifier.height(40.dp))
        Text(text = stringResource(id = R.string.allergens),
            textAlign = TextAlign.Center,
            fontSize = 35.sp)

        Spacer(modifier = modifier.height(20.dp))
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
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navigator.navigate(CameraPreviewDestination)}) {
            Text(text = stringResource(id = R.string.next_product),
                fontSize = 30.sp,
                color = Color.Black, fontWeight = FontWeight.Bold)

        }

    }
}
/*
@Preview
@Composable
fun ProductScreenPreview(navigator: DestinationsNavigator) {
    val product: Product =
        Product(name = "Rozok",
            description = listOf("Muka", "Soda", "Skorica", "Drozdie"),
            allergensIcon = listOf(
                R.drawable.ic_icon_cashew,
                R.drawable.ic_icon_eggs,
                R.drawable.ic_icon_fish,
                R.drawable.ic_icon_milk))
    ProductScreen(navigator,product = product)
}*/
@Destination
@Composable
fun SojovySuk(navigator: DestinationsNavigator){
    val product: Product =
        Product(name = "Sójový rez",
            description = listOf("Sušený glukózový sirup",
                "Sója",
                "Múka",
                "Cukor",
                "Palmový tuk",
                "Sušená syrovátka",
                "Mlieko"),
            allergensIcon = listOf(
                R.drawable.ic_icon_soya,
                R.drawable.ic_icon_eggs,
                R.drawable.ic_icon_milk,
                R.drawable.ic_icon_gluten))

    ProductScreen(navigator,product = product)
}

@Destination
@Composable
fun Maslo(navigator: DestinationsNavigator){
    val product: Product =
        Product(name = "Maslo",
            description = listOf("Cukor",
                "Soľ",
                "Mlieko"),
            allergensIcon = listOf(
                R.drawable.ic_icon_milk,
                R.drawable.ic_icon_gluten))
    ProductScreen(navigator,product = product)
}

@Destination
@Composable
fun AlaskaCokoladova(navigator: DestinationsNavigator){
    val product: Product =
        Product(name = "Alaska Čokoládová",
            description = listOf("Cukor",
                "Kukuričný škrob",
                "Sušené mlieko",
                "Srvátka",
                "Palmový tuk",
                "Soľ"),
            allergensIcon = listOf(
                R.drawable.ic_icon_gluten,
                R.drawable.ic_icon_eggs,
                R.drawable.ic_icon_milk,
                R.drawable.ic_icon_soya))
    ProductScreen(navigator,product = product)
}