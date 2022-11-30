package ru.dashkevich.edaciousapp.data.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import ru.dashkevich.edaciousapp.data.model.Meal
import ru.dashkevich.edaciousapp.util.MEAL_COLLECTION
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MealRepository @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val dispatcher: CoroutineDispatcher
) {


    suspend fun getMeals(): Result<List<Meal>> {
        return runCatching {
            withContext(dispatcher) {
                val result = fireStore.collection(MEAL_COLLECTION).get().await()
                val meals = result.toObjects(Meal::class.java)
                Log.d("FirebaseData", meals.toString())
                meals
            }
        }
    }


}














