package sk.zavacky.hip_zadanie_appka.allergens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sk.zavacky.hip_zadanie_appka.R

@Composable
fun AllergensScreen(modifier: Modifier = Modifier, allergens: List<Allergen>) {
    Column(modifier = modifier
        .padding(15.dp)
        .fillMaxSize()
        .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = modifier
            .fillMaxWidth(1f)
            .height(250.dp)) {
            Text(text = stringResource(id = R.string.allergens),
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold)
        }
        LazyColumn(modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            items(allergens) { allergen ->
                Box(modifier = modifier
                    .border(3.dp, color = Color.Black, shape = RectangleShape)
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(50.dp)) {
                    Row(modifier = modifier,
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = allergen.icon, contentDescription = "")
                        Spacer(modifier = modifier.width(15.dp))
                        Text(text = allergen.name,
                            textAlign = TextAlign.Right,
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AllergensScreenPreview() {
    val allergensList = listOf<Allergen>(
        Allergen("Lepok",Icons.Default.Clear),
        Allergen("Zinok",Icons.Default.Home),
        Allergen("Laktóza",Icons.Default.Face))
    AllergensScreen(allergens = allergensList)
}