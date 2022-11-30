package ru.dashkevich.edaciousapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ru.dashkevich.edaciousapp.screens.ApplicationScreen
import ru.dashkevich.edaciousapp.ui.theme.EdaciousAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdaciousAppTheme {
                ApplicationScreen()
            }
        }
    }
}