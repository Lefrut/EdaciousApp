package ru.dashkevich.edaciousapp.screens.signup.views.phone.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import ru.dashkevich.edaciousapp.data.model.Country
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun CountryDDM(
    modifier: Modifier = Modifier,
    nameCountry: String,
    countries: List<Country>,
    expandedCountryMenu: Boolean,
    onDropDownMenuClick: (Boolean) -> Unit,
    onCountryNameChoice: (String, Boolean) -> Unit
) {

    val icon =
        if (expandedCountryMenu) Icons.Filled.KeyboardArrowUp
        else Icons.Filled.KeyboardArrowDown
    var textFieldSize: Size by remember { mutableStateOf(Size.Zero) }


    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Country",
            fontSize = 22.sp,
            modifier = Modifier
                .padding(horizontal = 5.dp)
        )
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(2.dp),
            color = Theme.colors.ternaryTextColor
        )
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .clickable { onDropDownMenuClick(!expandedCountryMenu) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    nameCountry,
                    modifier = Modifier
                        .fillMaxWidth(0.84f)
                        .align(Alignment.CenterVertically)
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        }
                        .padding(horizontal = 4.dp),
                    textAlign = TextAlign.Center,
                    color = Theme.colors.defaultTextColor,
                    fontSize = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp),
                        tint = Theme.colors.primaryTextColor
                    )
                }

            }
            DropdownMenu(
                expanded = expandedCountryMenu,
                onDismissRequest = { onDropDownMenuClick(false)  },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
            ) {
                countries.forEach { country ->
                    DropdownMenuItem(onClick = {
                        onCountryNameChoice(country.name, false)
                    }) {
                        Column() {
                            Text(
                                text = country.name,
                                color = Theme.colors.primaryTextColor,
                                fontSize = 20.sp
                            )
                            Divider(
                                modifier = Modifier.fillMaxWidth(),
                                color = Theme.colors.ternaryTextColor,
                                thickness = 1.dp
                            )
                        }
                    }
                }
            }
        }
    }
}