package ru.dashkevich.edaciousapp.data.model
import android.graphics.Bitmap

data class Meal(
    var id: Int = 10,
    var title: String = "Meal",
    var shortDescription: String = "",
    var longDescription: String = "",
    var photo: Bitmap? = null,
    var ingredients: List<Ingredient> = emptyList(),
    var feedbacks: List<Feedback> = emptyList()
)
