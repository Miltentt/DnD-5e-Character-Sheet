package com.miltent.dnd5echaractersheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.miltent.dnd5echaractersheet.navigation.MainNavHost
import com.miltent.designsystem.theme.DNDSheetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DNDSheetTheme {
                MainNavHost()
            }
        }
    }
}
