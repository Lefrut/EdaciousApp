package ru.dashkevich.edaciousapp.screens.main.screens.characteristic.test
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// part. 1
val primaryTextColor = Color(0xFF444444)
val primaryColor = Color(0xffadf4ff)
val normalSpace = 16.dp
val smallSpace = 8.dp
val noSpace = 0.dp
val normalTouchableHeight = 44.dp

// part. 2
val noRadius = 0.dp
val normalRadius = 16.dp
val cornerRadiusBig = 20.dp
val rowHeight = 84.dp
val deleteIconButtonWidth = 60.dp
val deleteTextButtonWidth = 80.dp
val dividerNormalThickness = 1.0.dp
val normalElevation = 1.dp

val backSideColor = Color(0xFFfef49c)
val secondaryColor = Color(0xffb2ffa1)
val tertiaryColor = Color(0xFFb6caff)

val cardWidth = 350.dp
val cardHeight = 380.dp

const val paddingOffset = 32f
const val LOREM_IPSUM_FRONT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
const val LOREM_IPSUM_BACK =
    "Integer dolor nisl, finibus eget dignissim sit amet, semper vel ipsum."

// part. 3
const val animationTime = 350

@Preview
@Composable
fun TestStudyCardFrontView() {
    StudyCardView(
        backgroundColor = primaryColor,
        side = CardFlipState.FRONT_FACE,
        modifier = Modifier.size(cardWidth, cardHeight),
        content = { frontSideColor ->
            StudyCardsContent(
                LOREM_IPSUM_FRONT,
                frontSideColor
            )
        },
        bottomBar = { frontSideColor ->
            StudyCardsBottomBar(
                0, 1, CardFlipState.FRONT_FACE, frontSideColor,
                leftActionHandler = { },
                rightActionHandler = { }
            )
        }
    )
}

enum class CardFlipState {
    FRONT_FACE, FLIP_BACK, BACK_FACE, FLIP_FRONT
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StudyCardView(
    modifier: Modifier = Modifier,
    side: CardFlipState = CardFlipState.FRONT_FACE,
    backgroundColor: Color = backSideColor,
    content: @Composable (Color) -> Unit,
    bottomBar: @Composable (Color) -> Unit
) {
    val color = if (side == CardFlipState.FRONT_FACE) backgroundColor
    else backSideColor
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadiusBig),
        color = color,
        elevation = normalElevation,
        content = {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {},
                bottomBar = { bottomBar(backgroundColor) },
                content = { content(color) }
            )
        }
    )
}

@Composable
fun StudyCardsContent(data: String, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = data,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(normalSpace),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun StudyCardsBottomBar(
    index: Int,
    count: Int,
    side: CardFlipState = CardFlipState.FRONT_FACE,
    frontSideColor: Color,
    leftActionHandler: (CardFlipState) -> Unit = {},
    rightActionHandler: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(smallSpace)
    ) {
        val buttonColor = if (side == CardFlipState.FRONT_FACE) backSideColor else frontSideColor
        val leftTitle = if (side == CardFlipState.FRONT_FACE) "Peep" else "Back"
        val rightTitle = "Say"
        NiceButton(
            title = leftTitle,
            backgroundColor = buttonColor,
            onClick = { leftActionHandler.invoke(side) }
        )
        Spacer(Modifier.weight(1f))
        Text("${index + 1} of $count")
        Spacer(Modifier.weight(1f))
        NiceButton(
            title = rightTitle,
            backgroundColor = buttonColor,
            onClick = { rightActionHandler.invoke() }
        )
    }
}