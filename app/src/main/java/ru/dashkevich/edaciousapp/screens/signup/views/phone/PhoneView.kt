package ru.dashkevich.edaciousapp.screens.signup.views.phone

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpViewState
import ru.dashkevich.edaciousapp.screens.signup.views.phone.components.CountryDDM
import ru.dashkevich.edaciousapp.screens.signup.views.phone.components.PhoneInputField
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun PhoneView(
    viewState: SignUpViewState,
    onDropDownMenuClick: (Boolean) -> Unit,
    onCountryNameChoice: (String, Boolean) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onNextScreenClick: () -> Unit
) {

    //Во view model

    Spacer(modifier = Modifier.height(100.dp))
    Text("Enter your phone number", fontSize = 20.sp)
    Spacer(modifier = Modifier.height(6.dp))
    Column {
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp,
            color = Theme.colors.ternaryTextColor
        )
        CountryDDM(
            nameCountry = viewState.nameCountry,
            countries = viewState.countries,
            expandedCountryMenu = viewState.expandedCountryMenu,
            onDropDownMenuClick = onDropDownMenuClick,
            onCountryNameChoice = onCountryNameChoice
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp,
            color = Theme.colors.ternaryTextColor
        )
        PhoneInputField(phoneNumber = viewState.phoneNumber, onValueChange = onPhoneNumberChange)
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp,
            color = Theme.colors.ternaryTextColor
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.primaryColor,
                contentColor = Theme.colors.primaryBackgroundColor
            ),
            onClick = onNextScreenClick

        ) {
            Text(
                "Ok",
                fontSize = 24.sp
            )
        }
    }
}