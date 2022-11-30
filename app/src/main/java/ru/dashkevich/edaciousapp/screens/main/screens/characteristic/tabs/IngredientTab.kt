package ru.dashkevich.edaciousapp.screens.main.screens.characteristic.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.data.model.Ingredient
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun IngredientTab(modifier: Modifier = Modifier, ingredients: List<Ingredient>) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        ingredients.forEach { ingredient ->
            IngredientItem(ingredient = ingredient)
        }
    }
}

@Composable
fun IngredientItem(modifier: Modifier = Modifier, ingredient: Ingredient) {

    Column(modifier = modifier.padding(horizontal = 10.dp)) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ingredient.photo?.let {
                Image(
                    bitmap = it.asImageBitmap(), contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = ingredient.title,
                    fontSize = 20.sp,
                    color = Theme.colors.defaultTextColor
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = ingredient.gram.toString(),
                        fontSize = 16.sp,
                        color = Theme.colors.primaryColor
                    )
                    Text(
                        text = " Gram",
                        fontSize = 16.sp,
                        color = Theme.colors.secondaryTextColor
                    )
                }
            }
        }
        Divider(modifier = Modifier.height(3.dp), color = Theme.colors.ternaryTextColor)
    }
}









