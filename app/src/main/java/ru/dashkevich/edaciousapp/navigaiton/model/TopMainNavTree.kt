package ru.dashkevich.edaciousapp.navigaiton.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainNavTree {
    RecipeCharacteristic
}

sealed class TopMainNavTree(
    val route: String,
    val icon: ImageVector = Icons.Default.NoPhotography
) {

    object Feeds : TopMainNavTree("Feeds", Icons.Default.Newspaper)
    object Recipe : TopMainNavTree("Recipe", Icons.Default.RamenDining)
    object Chats : TopMainNavTree("Chats", Icons.Default.Forum)
    object Favorite : TopMainNavTree("Favorite", Icons.Default.Favorite)
    object Profile : TopMainNavTree("Profile", Icons.Default.Person)
    object Settings : TopMainNavTree("Settings", Icons.Default.Settings)
}

val topMainNavTreeLists = listOf(
    TopMainNavTree.Feeds,
    TopMainNavTree.Recipe,
    TopMainNavTree.Chats,
    TopMainNavTree.Favorite,
    TopMainNavTree.Profile,
    TopMainNavTree.Settings
)

val itemsMenu = topMainNavTreeLists
    .mapIndexed { index, topMainNavTree ->
        if(index==0) Pair(topMainNavTree, true)
        else Pair(topMainNavTree, false)
    }

val clearItemsMenu = topMainNavTreeLists
    .mapIndexed { index, topMainNavTree -> Pair(topMainNavTree, false) }
