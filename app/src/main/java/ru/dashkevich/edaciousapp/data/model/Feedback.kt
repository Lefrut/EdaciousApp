package ru.dashkevich.edaciousapp.data.model

import java.util.*


data class Feedback(
    var user: User = User(),
    var comment: String = "",
    var rate: Float = -1f
)


