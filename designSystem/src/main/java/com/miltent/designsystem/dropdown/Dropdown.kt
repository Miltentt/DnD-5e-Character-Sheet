package com.miltent.designsystem.dropdown

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.theme.DNDSheetTheme

@Composable
fun Dropdown(expanded: Boolean, onDismissRequest: () -> Unit, contentList: List<String>) {
    DropdownMenu(expanded = expanded, onDismissRequest = onDismissRequest) {
      contentList.forEach {
          DropdownItem()
      }
    }
}

@Composable
fun DropdownItem() {
    DropdownMenuItem(
        text = {
            Text(text = "test")
        },
        onClick = {}
    )
}

@Preview
@Composable
fun DropdownPreview() {
    DNDSheetTheme {
        Column(modifier = Modifier.wrapContentHeight()) {
            Dropdown(expanded = true, onDismissRequest = {}, contentList = listOf("test", "test2"))
        }
    }
}