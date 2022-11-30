package ru.dashkevich.edaciousapp.data.model

import android.graphics.Bitmap

class User(
    var login: String = "",
    var name: String = "",
    var surname: String = "",
    var numberPhone: String = "",
    var email: String = "",
    var photo: Bitmap? = null
)