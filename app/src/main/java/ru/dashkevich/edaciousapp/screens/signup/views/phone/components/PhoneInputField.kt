package ru.dashkevich.edaciousapp.screens.signup.views.phone.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpViewState
import ru.dashkevich.edaciousapp.screens.signup.views.phone.components.CountryDDM
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun PhoneInputField(modifier: Modifier = Modifier,phoneNumber: String, onValueChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            "+88",
            fontSize = 22.sp,
            modifier = Modifier
                .padding(horizontal = 5.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(2.dp),
            color = Theme.colors.ternaryTextColor
        )
        TextField(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(1f),
            textStyle = TextStyle(
                color = Theme.colors.defaultTextColor,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            ),
            value = phoneNumber,
            onValueChange = {
                onValueChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Phone number",
                    fontSize = 22.sp,
                    color = Theme.colors.secondaryTextColor,
                    textAlign = TextAlign.Center
                )
            },
            shape = RoundedCornerShape(0.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Theme.colors.primaryBackgroundColor,
                textColor = Theme.colors.defaultTextColor,
                disabledIndicatorColor = Theme.colors.primaryBackgroundColor,
                errorIndicatorColor = Theme.colors.primaryBackgroundColor,
                focusedIndicatorColor = Theme.colors.primaryBackgroundColor,
                unfocusedIndicatorColor = Theme.colors.primaryBackgroundColor,
                cursorColor = Theme.colors.primaryBackgroundColor
            ),
            visualTransformation = VisualTransformation.None,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}