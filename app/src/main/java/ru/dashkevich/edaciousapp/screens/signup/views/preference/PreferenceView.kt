package ru.dashkevich.edaciousapp.screens.signup.views.preference

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpViewState
import ru.dashkevich.edaciousapp.screens.signup.views.preference.components.MealPager
import ru.dashkevich.edaciousapp.screens.signup.views.verify.components.CheckButton
import ru.dashkevich.edaciousapp.ui.theme.Theme
import ru.dashkevich.edaciousapp.util.mealList
import kotlin.math.absoluteValue

@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun PreferenceView(
    viewState: SignUpViewState,
    onNextScreenClick: () -> Unit,
    onAddMealClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "What you type of food you usually prefer?",
            modifier = Modifier.padding(horizontal = 20.dp),
            fontSize = 18.sp,
            color = Theme.colors.primaryTextColor,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))

        val list = remember {
            mealList.map { Pair(it, false) }.toMutableList().toMutableStateList()
        }
        MealPager(
            mealList = list,
            onAddMealClick = onAddMealClick
        )
        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
            CheckButton(onClick = onNextScreenClick)
        }
    }
}
