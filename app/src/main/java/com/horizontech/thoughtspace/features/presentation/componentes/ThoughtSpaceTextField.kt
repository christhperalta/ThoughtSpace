package com.horizontech.thoughtspace.features.presentation.componentes


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ThoughtSpaceTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    Box(modifier = modifier) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange)

        if (value.isEmpty()) {
            ThoughtSpaceText(text = placeholder)
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