package ru.dashkevich.edaciousapp.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.dashkevich.edaciousapp.navigaiton.model.NavigationTree
import ru.dashkevich.edaciousapp.screens.main.MainScreen
import ru.dashkevich.edaciousapp.screens.main.MainViewModel
import ru.dashkevich.edaciousapp.screens.signin.SignInScreen
import ru.dashkevich.edaciousapp.screens.signup.SignUpScreen
import ru.dashkevich.edaciousapp.screens.signup.SignUpViewModel
import ru.dashkevich.edaciousapp.screens.splash.SplashScreen
import ru.dashkevich.edaciousapp.screens.waitingroom.WaitingRoomScreen
import ru.dashkevich.edaciousapp.screens.waitingroom.WaitingRoomViewModel

@Composable
fun ApplicationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTree.Splash.name) {
        composable(NavigationTree.Splash.name) {
            SplashScreen(navController = navController)
        }
        composable(NavigationTree.WaitingRoom.name) {
            val waitingRoomViewModel = hiltViewModel<WaitingRoomViewModel>()
            WaitingRoomScreen(
                navController = navController,
                waitingRoomViewModel = waitingRoomViewModel
            )
        }
        composable(NavigationTree.SignIn.name) {
            SignInScreen()
        }
        composable(NavigationTree.SignUp.name) {
            val signUpViewModel = hiltViewModel<SignUpViewModel>()
            SignUpScreen(signUpViewModel, navController)
        }
        composable(NavigationTree.Main.name){
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navController, mainViewModel = mainViewModel)
        }

    }
}






