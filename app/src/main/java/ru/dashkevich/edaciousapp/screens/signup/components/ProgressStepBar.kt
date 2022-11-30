package ru.dashkevich.edaciousapp.screens.signup.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpViews
import ru.dashkevich.edaciousapp.ui.theme.EdaciousAppTheme
import ru.dashkevich.edaciousapp.ui.theme.Theme


enum class PageState {
    Current, Completed, InCompleted, None
}

//Доработать вид
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun StepBar(
    modifier: Modifier = Modifier,
    numberOfSteps: Int,
    currentStep: Int
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        horizontalArrangement = Arrangement.Center,
        //verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 1..numberOfSteps) {
            val pageState =
                when {
                    step == currentStep -> PageState.Current
                    step < currentStep -> PageState.Completed
                    step > currentStep -> PageState.InCompleted
                    else -> PageState.None
                }
            var namePage = ""
            val textColor: Color =
                if (pageState == PageState.Current) Theme.colors.primaryColor
                else Theme.colors.defaultTextColor
            val textPaddingTop =
                if (pageState == PageState.Current) 0.dp
                else 5.dp

            val (circle, text) = createRefs()

            Column {
                Spacer(modifier = Modifier.height(textPaddingTop))
                if (step == numberOfSteps) {
                    namePage = SignUpViews.values()[step - 1].name
                    Box(contentAlignment = Alignment.CenterStart) {
                        StepCircle(
                            modifier = Modifier.layoutId(circle),
                            pageState = pageState, numberPage = step
                        )
                    }
                } else {
                    namePage = SignUpViews.values()[step - 1].name
                    Box(contentAlignment = Alignment.CenterStart) {
                        StepLine(pageState = pageState)
                        StepCircle(
                            modifier = Modifier.layoutId(circle),
                            pageState = pageState, numberPage = step
                        )
                    }

                }
                Text(
                    text = namePage,
                    color = textColor,
                    modifier = Modifier
                        .padding(top = textPaddingTop)
                )
            }
        }
    }
}


@Composable
fun StepLine(modifier: Modifier = Modifier, pageState: PageState) {
    val lineColor =
        if (pageState == PageState.Completed) Theme.colors.primaryColor else Theme.colors.secondaryColor
    val width = if (pageState == PageState.Current) 82.dp else 72.dp


    Divider(
        modifier = modifier.width(width),
        color = lineColor,
        thickness = 8.dp
    )
}

@Composable
fun StepCircle(modifier: Modifier = Modifier, pageState: PageState, numberPage: Int) {
    val smallCircleColor =
        if (pageState == PageState.InCompleted) Theme.colors.secondaryColor
        else Theme.colors.primaryColor
    val textColor =
        if (pageState == PageState.InCompleted) Theme.colors.defaultTextColor
        else Theme.colors.primaryBackgroundColor
    val bigCircleColor = Theme.colors.secondaryColor



    Column(modifier = modifier) {
        Box(contentAlignment = Alignment.Center) {
            if (pageState == PageState.Current) {
                Canvas(modifier = Modifier
                    .size(36.dp),
                    onDraw = {
                        drawCircle(color = bigCircleColor)
                    }
                )
            }
            Canvas(modifier = Modifier
                .size(26.dp),
                onDraw = {
                    drawCircle(color = smallCircleColor)
                }
            )
            if (pageState == PageState.InCompleted || pageState == PageState.Current) {
                Text(numberPage.toString(), fontSize = 14.sp, color = textColor)
            }
            if (pageState == PageState.Completed) {
                Icon(
                    modifier = Modifier.size(23.dp),
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Theme.colors.primaryBackgroundColor
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun StepCirclePreview() {
//    EdaciousAppTheme {
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            StepCircle(pageState = PageState.InCompleted, 1)
//            StepCircle(pageState = PageState.Current, 2)
//            StepCircle(pageState = PageState.Completed, 3)
//        }
//    }
//}