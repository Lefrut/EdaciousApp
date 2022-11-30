package ru.dashkevich.edaciousapp.util

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

const val USER_COLLECTION = "User"
const val MEAL_COLLECTION = "Meal"
const val INGREDIENT_COLLECTION = "Ingredient"

fun <T> T.callCollection(
    fireStore: FirebaseFirestore,
    title: String,
    filter: CollectionReference.() -> T
): T {
    return fireStore.collection(title).filter()
}