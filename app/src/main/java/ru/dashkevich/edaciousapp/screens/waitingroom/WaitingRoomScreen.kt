package ru.dashkevich.edaciousapp.screens.waitingroom

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ru.dashkevich.edaciousapp.R
import ru.dashkevich.edaciousapp.navigaiton.model.NavigationTree
import ru.dashkevich.edaciousapp.screens.waitingroom.model.WaitRoomAction
import ru.dashkevich.edaciousapp.screens.waitingroom.model.WaitingRoomEvent
import ru.dashkevich.edaciousapp.screens.waitingroom.model.WaitingRoomViewState
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun WaitingRoomScreen(navController: NavHostController, waitingRoomViewModel: WaitingRoomViewModel) {

    val viewState = waitingRoomViewModel.viewState.observeAsState(WaitingRoomViewState())

    Surface(modifier = Modifier.fillMaxSize(), color = Theme.colors.secondaryBackgroundColor) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.eatbackground),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            val scrollState = rememberScrollState()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.height(126.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .height(70.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.trident),
                        contentDescription = null,
                        tint = Theme.colors.primaryColor,
                        modifier = Modifier.size(90.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        "DACIOUS",
                        color = Theme.colors.primaryColor,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row() {
                    Text("Best place for ", color = Theme.colors.defaultTextColor, fontSize = 18.sp)
                    Text("food lovers ", color = Theme.colors.primaryColor, fontSize = 18.sp)
                    Text("like you", color = Theme.colors.defaultTextColor, fontSize = 18.sp)
                }
                Image(
                    painter = painterResource(id = R.drawable.chef),
                    contentDescription = null,
                    modifier = Modifier.size(300.dp)
                )
                Text(
                    "Create a new account or sing in",
                    color = Theme.colors.defaultTextColor,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(14.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(start = 20.dp, end = 10.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Theme.colors.primaryColor,
                            contentColor = Theme.colors.primaryBackgroundColor
                        ),
                        onClick = {
                            waitingRoomViewModel.obtainEvent(WaitingRoomEvent.SignUpClicked)
                        }
                    ) {
                        Text(
                            "Get started",
                            fontSize = 20.sp
                        )
                    }

                    OutlinedButton(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(start = 10.dp, end = 20.dp)
                            .height(50.dp)
                            .border(
                                width = 2.dp,
                                color = Theme.colors.primaryColor,
                                shape = MaterialTheme.shapes.small
                            ),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Theme.colors.primaryBackgroundColor,
                            contentColor = Theme.colors.primaryColor
                        ),
                        onClick = {
                            waitingRoomViewModel.obtainEvent(WaitingRoomEvent.SignInClicked)
                        }
                    ) {
                        Text(
                            "Sing In",
                            fontSize = 20.sp
                        )
                    }

                }
            }
        }
    }

    LaunchedEffect(key1 = viewState.value.waitRoomAction){
        when(viewState.value.waitRoomAction){
            WaitRoomAction.SignUp -> {
                navController.navigate(NavigationTree.SignUp.name){
                    popUpTo(NavigationTree.WaitingRoom.name)
                }
            }
            WaitRoomAction.SignIn -> {
                navController.navigate(NavigationTree.SignIn.name){
                    popUpTo(NavigationTree.WaitingRoom.name)
                }
            }
            WaitRoomAction.None -> {}
        }
    }

    DisposableEffect(key1 = Unit){
        onDispose {
            waitingRoomViewModel.obtainEvent(WaitingRoomEvent.RegistrationActionInvoked)
        }
    }

}