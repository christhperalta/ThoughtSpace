package com.horizontech.thoughtspace.core.presentation


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ThoughtSpaceButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = { onClick() },
        modifier = modifier
            .fillMaxWidth()
    ) {
        ThoughtSpaceText(
            modifier = Modifier.padding(10.dp),
            text = text
        )
    }
}


@Composable
fun ThoughtSpaceButtonContainer() {
    ThoughtSpaceButton(text = "Make a Quit note") {}
}


@Preview(name = "ThoughtSpaceButton")
@Composable
private fun PreviewThoughtSpaceButton() {
    ThoughtSpaceButtonContainer()
}