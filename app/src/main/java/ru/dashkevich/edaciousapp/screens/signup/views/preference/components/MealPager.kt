package ru.dashkevich.edaciousapp.screens.signup.views.preference.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import ru.dashkevich.edaciousapp.R
import ru.dashkevich.edaciousapp.data.model.Meal
import ru.dashkevich.edaciousapp.ui.theme.Theme
import kotlin.math.absoluteValue


//Добавить работу с сервером и view model
@OptIn(ExperimentalPagerApi::class)
@Composable
fun MealPager(mealList: MutableList<Pair<Meal, Boolean>>, onAddMealClick: () -> Unit) {
    HorizontalPager(count = mealList.size) { page ->
        val meal = mealList[page]
        Card(
            Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    lerp(
                        start = 0.80f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
        ) {
            Box(
                modifier = Modifier
                    .height(380.dp)
                    .width(270.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    if (meal.first.photo != null) {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(260.dp),
                            bitmap = meal.first.photo!!.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(260.dp),
                            painter = painterResource(id = R.drawable.bigmac),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(meal.first.title, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        text = meal.first.shortDescription,
                        fontSize = 16.sp,
                        color = Theme.colors.secondaryTextColor,
                        textAlign = TextAlign.Center
                    )
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopEnd
                ) {


                    val iconButton = if (meal.second) Icons.Default.Check else Icons.Default.Add
                    val colorIcon =
                        if (!meal.second) Theme.colors.primaryTextColor else Theme.colors.primaryBackgroundColor
                    val colorButton =
                        if (meal.second) Theme.colors.primaryColor
                        else Theme.colors.primaryBackgroundColor
                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp, end = 10.dp)
                            .size(28.dp)
                            .background(color = colorButton, shape = CircleShape)
                            .border(
                                width = 1.dp,
                                color = Theme.colors.primaryTextColor,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        IconButton(
                            modifier = Modifier,
                            onClick = {
                                //onAddMealClick
                                mealList[page] = mealList[page].copy(second = !meal.second)
                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(23.dp),
                                imageVector = iconButton,
                                contentDescription = null,
                                tint = colorIcon
                            )
                        }
                    }
                }
            }
        }
    }
}

