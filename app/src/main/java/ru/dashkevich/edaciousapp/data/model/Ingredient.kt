package ru.dashkevich.edaciousapp.data.model

import android.graphics.Bitmap

data class Ingredient(
    var title: String = "",
    var gram: Int = -1,
    var photo: Bitmap? = null
)
