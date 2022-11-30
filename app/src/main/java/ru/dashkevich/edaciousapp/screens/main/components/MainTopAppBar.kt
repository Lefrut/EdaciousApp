package ru.dashkevich.edaciousapp.screens.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.dashkevich.edaciousapp.screens.splash.components.LogoImage
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun MainTopAppBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit,
    onPlanetClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        backgroundColor = Theme.colors.primaryColor
    ) {


        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            onMenuClick()
                        },
                    tint = Theme.colors.primaryBackgroundColor
                )

                Row() {
                    Icon(
                        imageVector = Icons.Default.Public,
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                            .clickable { },
                        tint = Theme.colors.primaryBackgroundColor
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                            .clickable { },
                        tint = Theme.colors.primaryBackgroundColor
                    )
                }
            }
            LogoImage(
                modifier = Modifier
                    .height(40.dp)
                    .width(80.dp),
                paddingEnd = 30.dp,
                heightIcon = 50.dp,
                widthIcon = 50.dp,
                colorCircle = Theme.colors.primaryBackgroundColor,
                colorIcon = Theme.colors.primaryColor
            )
        }
    }
}