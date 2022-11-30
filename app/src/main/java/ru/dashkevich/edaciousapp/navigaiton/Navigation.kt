package ru.dashkevich.edaciousapp.navigaiton

import androidx.navigation.NavHostController
import com.google.gson.Gson
import ru.dashkevich.edaciousapp.data.model.Meal
import ru.dashkevich.edaciousapp.navigaiton.model.MainNavTree

fun NavHostController.navigateToCharacteristic(recipe: Meal, settings: () -> Unit = {}){
    val jsonRecipe = Gson().toJson(recipe)
    navigate(MainNavTree.RecipeCharacteristic.name + "/$jsonRecipe"){
        settings()
    }
}
