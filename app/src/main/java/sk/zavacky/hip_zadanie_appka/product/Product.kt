package sk.zavacky.hip_zadanie_appka.product

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class Product(
    val name : String,
    val description : List<String>,
    val allergensIcon : List<Int>
)
