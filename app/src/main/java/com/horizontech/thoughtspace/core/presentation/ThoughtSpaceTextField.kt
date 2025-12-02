package com.horizontech.thoughtspace.core.presentation


import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ThoughtSpaceTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    onValueChange: (String) -> Unit
) {
    Box(modifier = modifier) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = style)

        if (value.isEmpty()) {
            ThoughtSpaceText(text = placeholder, style = style)
        }
    }
}

@Composable
fun ThoughtSpaceTextFieldContainer() {
    ThoughtSpaceTextField(value = "",
        placeholder = "Title",
        onValueChange = {})
}

@Preview(name = "ThoughtSpaceTextField")
@Composable
private fun PreviewThoughtSpaceTextField() {
    ThoughtSpaceTextFieldContainer()
}