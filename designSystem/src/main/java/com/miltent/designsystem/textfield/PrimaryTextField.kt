package com.miltent.designsystem.textfield

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PrimaryTextField(
    value: String,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    TextField(value = value, modifier = modifier, label = label, onValueChange = onValueChange)
}

@Preview
@Composable
fun PrimaryTextFieldPreview() {
    PrimaryTextField(
        "test input",
        label = {},
        onValueChange = {},
    )
}