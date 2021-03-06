package sk.zavacky.hip_zadanie_appka.allergens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import sk.zavacky.hip_zadanie_appka.R
import sk.zavacky.hip_zadanie_appka.destinations.CameraPermissionPreviewDestination
import kotlin.random.Random

@Composable
fun AllergenBox(allergen: Allergen, modifier: Modifier = Modifier) {
    var bcgcolor by remember {
        mutableStateOf(Color.Transparent)
    }
    Box(modifier = modifier
        .border(3.dp, color = Color.Black, shape = RectangleShape)
        .background(color = bcgcolor)
        .padding(5.dp)
        .fillMaxWidth()
        .height(50.dp)
        .clickable {
            bcgcolor = if (bcgcolor == Color.Transparent) {
                Color(0xFF25D482)
            } else {
                Color.Transparent
            }
        }) {
        Row(modifier = modifier,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically) {

            Icon(modifier = modifier
                .size(50.dp)
                .border(width = 2.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = Color.Black)
                .background(color = Color(0xFFFBD8B0),
                    shape = RoundedCornerShape(10.dp)),
                painter = painterResource(id = allergen.icon),
                contentDescription = null)
            Spacer(modifier = modifier.width(15.dp))
            Text(text = allergen.name,
                textAlign = TextAlign.Right,
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold)
        }
    }

}

@Composable
fun AllergensScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    allergens: List<Allergen>,
) {
    var bcgcolor by remember {
        mutableStateOf(Color.Transparent)
    }
    val rnd = Random
    Column(modifier = modifier
        .padding(15.dp)
        .fillMaxSize()
        .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = modifier
        ) {
            Text(text = stringResource(id = R.string.allergens),
                textAlign = TextAlign.Center,
                fontSize = 70.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold)
        }
        Button(onClick = { navigator.navigate(CameraPermissionPreviewDestination) }) {
            Text(text = stringResource(id = R.string.next),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(60.dp))
        LazyColumn(modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            items(allergens) { allergen ->
                AllergenBox(allergen = allergen)
            }
        }
    }
}

@Destination
@Composable
fun AllergensScreenPreview(navigator: DestinationsNavigator) {
    val allergensList = listOf<Allergen>(
        Allergen("Ke??u orie??ky", R.drawable.ic_icon_cashew),
        Allergen("Zeler", R.drawable.ic_icon_celery),
        Allergen("Vajcia", R.drawable.ic_icon_eggs),
        Allergen("Ryby", R.drawable.ic_icon_fish),
        Allergen("Lepok", R.drawable.ic_icon_gluten),
        Allergen("Lupin", R.drawable.ic_icon_lupine),
        Allergen("Lakt??za", R.drawable.ic_icon_milk),
        Allergen("Sezam", R.drawable.ic_icon_sesame),
        Allergen("Krevety", R.drawable.ic_icon_shrimp),
        Allergen("S??ja", R.drawable.ic_icon_soya),
        Allergen("Orechy", R.drawable.ic_icon_walnut))
    AllergensScreen(navigator, allergens = allergensList)
}