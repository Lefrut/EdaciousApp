package ru.dashkevich.edaciousapp.screens.signup.model

import ru.dashkevich.edaciousapp.data.model.Country
import ru.dashkevich.edaciousapp.data.model.Meal

sealed class LoginAction{
    object OpenMainScreen: LoginAction()
    object None: LoginAction()

}

data class SignUpViewState(
    val nameCountry: String = "",
    val phoneNumber: String = "",
    val screenState: SignUpViews = SignUpViews.Phone,
    val expandedCountryMenu: Boolean = false,
    val code: String = "",
    val loginAction : LoginAction = LoginAction.None,
    val isLoginPassed: Boolean = false,
    val countries: List<Country> = emptyList()
)

//val addedMeals: List<Pair<Meal,Boolean>> =
