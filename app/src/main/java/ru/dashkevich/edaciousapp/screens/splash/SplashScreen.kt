package ru.dashkevich.edaciousapp.screens.splash

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import ru.dashkevich.edaciousapp.navigaiton.model.NavigationTree
import ru.dashkevich.edaciousapp.screens.splash.components.LogoImage
import ru.dashkevich.edaciousapp.ui.theme.EdaciousAppTheme
import ru.dashkevich.edaciousapp.ui.theme.Theme


@Composable
fun SplashScreen(navController: NavHostController) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            LogoImage(
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(14.dp))
            Row() {
                Text("Edacious ", color = Theme.colors.primaryColor, fontSize = 26.sp)
                Text("Free UI Kit", fontSize = 26.sp, color = Theme.colors.primaryTextColor)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row() {
                Text("Powered by ", fontSize = 22.sp, color = Theme.colors.secondaryTextColor)
                Text("UI Spark ", color = Theme.colors.secondarySelectedTextColor, fontSize = 22.sp)
                Text("Team", fontSize = 22.sp, color = Theme.colors.secondaryTextColor)
            }


//            Spacer(modifier = Modifier.height(8.dp))
//            SelectionText(text = "Powered by UI Spark Team", selectionText = " UI Spark")
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        delay(2000L)
        navController.navigate(NavigationTree.WaitingRoom.name)
    })
}


/*Доделать когда придет осознание, либо в случае безделия.*/
// Идея сделать row внутри, и выписывать сразу
@Composable
fun SelectionText(
    text: String,
    selectionText: String,
    textColor: Color = Theme.colors.primaryTextColor,
    selectionTextColor: Color = Theme.colors.primaryColor,
    modifier: Modifier = Modifier
) {
    var commonStr = mutableListOf<String>("", "")
    var numberElementStr = 0
    var word = ""

    text.forEach { s ->
        if (s == ' ') {
            if (word == selectionText) {
                commonStr[numberElementStr] = ""
            } else {
                commonStr += word
            }
            word = ""
        }
        word += s
    }
    Log.d("CommonText", commonStr[0])
    Log.d("CommonText", commonStr[0])
    Row(modifier = modifier) {
        Text(text = commonStr[0], color = textColor)
        Text(text = selectionText, color = selectionTextColor)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSplash() {
    EdaciousAppTheme {
        //SplashScreen()
    }
}



