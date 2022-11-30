package ru.dashkevich.edaciousapp.screens.main.model

import ru.dashkevich.edaciousapp.navigaiton.model.TopMainNavTree
import ru.dashkevich.edaciousapp.navigaiton.model.itemsMenu

data class MainViewState(
    val expandedTopMenu: Boolean = false,
    val useSearch: Boolean = false,
    val useMap: Boolean = false,
    val useMenuItems: List<Pair<TopMainNavTree, Boolean>> = itemsMenu
)
