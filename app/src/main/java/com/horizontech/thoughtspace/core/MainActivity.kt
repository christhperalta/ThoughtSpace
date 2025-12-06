package com.horizontech.thoughtspace.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.horizontech.thoughtspace.core.navigation.NavigationWrapper
import com.horizontech.thoughtspace.core.ui.theme.ThoughtSpaceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThoughtSpaceTheme {
                NavigationWrapper()
            }
        }
    }
}

