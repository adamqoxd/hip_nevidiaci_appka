package sk.zavacky.hip_zadanie_appka.initial_settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sk.zavacky.hip_zadanie_appka.R

@Composable
fun QuestionScreen(modifier: Modifier = Modifier, question: Question) {
    Column(modifier = modifier
        .padding(15.dp)
        .fillMaxSize()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Box(modifier = modifier.padding(top = 50.dp, bottom = 50.dp)
        ) {
            Text(text = question.description, fontSize = 50.sp, textAlign = TextAlign.Center)
        }
        val buttonHeight: Dp = 600.dp
        val buttonWidth: Dp = 180.dp
        Row(modifier = modifier) {
            Button(modifier = modifier
                .height(buttonHeight)
                .width(buttonWidth)
                .padding(horizontal = 5.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(37, 212, 130)),
                shape = CutCornerShape(10.dp),
                onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.yes),
                    fontSize = 50.sp,
                    color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Button(modifier = modifier
                .height(buttonHeight)
                .width(buttonWidth)
                .padding(horizontal = 5.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(255, 107, 107)),
                shape = CutCornerShape(10.dp),
                onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.no),
                    fontSize = 50.sp,
                    color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview
@Composable
fun QuestionScreenPreview() {
    val question: Question = Question(datastoreTag = "Blind", description = "Si ozaj slepy ?")
    QuestionScreen(question = question)
}