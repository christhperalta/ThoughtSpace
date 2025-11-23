package com.horizontech.thoughtspace.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.horizontech.thoughtspace.core.navigation.NavigationWrapper
import com.horizontech.thoughtspace.core.ui.theme.ThoughtSpaceTheme
import com.horizontech.thoughtspace.features.presentation.home.HomeScreen

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

