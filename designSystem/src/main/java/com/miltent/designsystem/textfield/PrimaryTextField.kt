package com.miltent.designsystem.textfield

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val MIN_HEIGHT = 56.dp
private val DIGITS_REGEX = Regex("^\\d+\$")

@Composable
fun PrimaryTextField(
    modifier: Modifier = Modifier,
    value: String,
    labelText: String,
    placeholderText: String?= null,
    isError: Boolean = false,
    readOnly: Boolean = false,
    isDigitsOnly: Boolean = false,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        modifier = modifier.heightIn(min = MIN_HEIGHT),
        shape = MaterialTheme.shapes.medium,
        label = {
            Text(text = labelText)
        },
        onValueChange = {
            if (isDigitsOnly) {
                if (it.matches(DIGITS_REGEX)) onValueChange(it)
            } else {
                onValueChange(it)
            }
        },
        placeholder = {
            placeholderText?.let { Text(text = it) }
        },
        isError = isError,
        readOnly = readOnly,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,),

        keyboardOptions = KeyboardOptions(keyboardType = if (isDigitsOnly) KeyboardType.Number else KeyboardType.Text)
    )
}

@Preview
@Composable
fun PrimaryTextFieldPreview() {
    PrimaryTextField(
        value = "test input",
        labelText = "test",
        placeholderText = "test",
        onValueChange = {},
    )
}