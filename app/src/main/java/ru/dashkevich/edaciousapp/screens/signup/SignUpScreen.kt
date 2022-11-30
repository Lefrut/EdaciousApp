package ru.dashkevich.edaciousapp.screens.signup

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.dashkevich.edaciousapp.navigaiton.model.NavigationTree
import ru.dashkevich.edaciousapp.screens.signup.components.StepBar
import ru.dashkevich.edaciousapp.screens.signup.model.LoginAction
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpEvent
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpViewState
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpViews
import ru.dashkevich.edaciousapp.screens.signup.views.verify.VerifyView
import ru.dashkevich.edaciousapp.screens.signup.views.phone.PhoneView
import ru.dashkevich.edaciousapp.screens.signup.views.preference.PreferenceView

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel, navController: NavHostController) {

    val viewState = signUpViewModel.viewState.observeAsState(SignUpViewState())

    with(viewState.value) {
        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(60.dp))
            StepBar(
                modifier = Modifier,
                numberOfSteps = SignUpViews.values().size,
                currentStep = screenState.ordinal + 1,
            )
            Spacer(modifier = Modifier.height(50.dp))

            when (screenState) {
                SignUpViews.Phone -> {
                    PhoneView(
                        viewState = this@with,
                        onDropDownMenuClick = {
                            signUpViewModel.obtainEvent(SignUpEvent.CountryDropMenuClicked(it))
                        },
                        onCountryNameChoice = { value1, value2 ->
                            signUpViewModel.obtainEvent(SignUpEvent.CountryChoice(value1, value2))
                        },
                        onPhoneNumberChange = {
                            signUpViewModel.obtainEvent(SignUpEvent.PhoneNumberChanged(it))
                        },
                        onNextScreenClick = {
                            signUpViewModel.obtainEvent(SignUpEvent.NextScreenClicked)
                        }
                    )
                }
                SignUpViews.Verify -> {
                    VerifyView(
                        viewState = this@with,
                        onNextScreenClick = {
                            signUpViewModel.obtainEvent(SignUpEvent.NextScreenClicked)
                        },
                        onCodeChange = {
                            signUpViewModel.obtainEvent(SignUpEvent.CodeChanged(it))
                        }
                    )
                }
                SignUpViews.Preference -> {
                    PreferenceView(
                        viewState = this@with,
                        onNextScreenClick = { signUpViewModel.obtainEvent(SignUpEvent.NextScreenClicked) },
                        onAddMealClick = {/*создать во view}*/ }
                    )
                }
            }
        }

        LaunchedEffect(key1 = loginAction) {
            when (loginAction) {
                is LoginAction.OpenMainScreen -> {
                    navController.navigate(NavigationTree.Main.name){
                        popUpTo(NavigationTree.SignUp.name)
                    }
                }
                is LoginAction.None ->{}
            }
        }

        DisposableEffect(key1 =Unit){
            onDispose {
                signUpViewModel.obtainEvent(SignUpEvent.LoginActionInvoked)
            }
        }

    }
}




