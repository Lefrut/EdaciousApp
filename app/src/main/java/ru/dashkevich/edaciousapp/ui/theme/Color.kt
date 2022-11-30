package ru.dashkevich.edaciousapp.ui.theme

import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)



class Colors(
    val defaultTextColor: Color,
    val primaryBackgroundColor: Color,
    val secondaryBackgroundColor: Color,
    val primaryColor: Color,
    val secondaryColor: Color,
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val ternaryTextColor: Color,
    val primarySelectedTextColor: Color,
    val secondarySelectedTextColor: Color,

)


val lightPalette = Colors(
    defaultTextColor = Color.Black,
    primaryBackgroundColor = Color.White,
    secondaryBackgroundColor = Color(0xFFf6eaed),
    primaryColor = Color(0xFFed3851),
    secondaryColor = Color(0xFFebd0d3),
    primaryTextColor = Color(0xFF5e5e5e),
    secondaryTextColor = Color(0xFF777777),
    ternaryTextColor = Color(0xFFf1f1f1),
    primarySelectedTextColor = Color(0xFFee5d71),
    secondarySelectedTextColor = Color(0xFF00c0ff),
)