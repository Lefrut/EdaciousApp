package ru.dashkevich.edaciousapp.screens.signup.views.verify

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpViewState
import ru.dashkevich.edaciousapp.screens.signup.views.verify.components.CheckButton
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun VerifyView(
    viewState: SignUpViewState,
    onNextScreenClick: () -> Unit,
    onCodeChange: (String) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "Enter the verification code you've received",
            modifier = Modifier.padding(horizontal = 50.dp),
            fontSize = 18.sp,
            color = Theme.colors.defaultTextColor,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(40.dp))

        TextField(
            value = viewState.code,
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .border(
                    width = 2.dp,
                    color = Theme.colors.ternaryTextColor,
                    shape = CircleShape
                ),
            onValueChange = onCodeChange,
            trailingIcon = {
                Row() {
                    CheckButton(modifier = Modifier, onClick = onNextScreenClick)
                    Spacer(modifier = Modifier.width(10.dp))
                }
            },
            singleLine = true,
            shape = CircleShape,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Theme.colors.defaultTextColor,
                backgroundColor = Theme.colors.primaryBackgroundColor,
                cursorColor = Color.Transparent,
                placeholderColor = Theme.colors.ternaryTextColor,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(
                color = Theme.colors.defaultTextColor,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            ),
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Code",
                    fontSize = 22.sp,
                    color = Theme.colors.secondaryTextColor,
                    textAlign = TextAlign.Center
                )
            },
        )

        //CheckButton(onClick = onNextScreenClick)

    }

}