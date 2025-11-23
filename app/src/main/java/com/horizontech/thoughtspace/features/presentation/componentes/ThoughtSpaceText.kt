package com.horizontech.thoughtspace.features.presentation.componentes

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun ThoughtSpaceText(
    modifier: Modifier = Modifier,
     text : String,
    style: TextStyle = MaterialTheme.typography.bodyLarge
) {
    Text(
        modifier = modifier,
        text = text,
        style = style
    )
}

