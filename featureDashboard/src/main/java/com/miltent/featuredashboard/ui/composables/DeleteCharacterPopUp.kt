package com.miltent.featuredashboard.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.theme.Colors
import com.miltent.resources.R as ResR

@Composable
fun DeleteCharacterPopUp(name: String, onClick: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .background(Colors.primary)
    )
    {
        Text(text = stringResource(ResR.string.delete_character_dialog, name),
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
        Row {
            Text(text = "tak",
                Modifier
                    .clickable(onClick = { onClick(true)})
                    .padding(16.dp),
                fontSize = 22.sp
            )
            Spacer(Modifier.width(22.dp))
            Text(text = "nie",
                Modifier
                    .clickable(onClick = { onClick(false)})
                    .padding(16.dp),
                fontSize = 22.sp
                )
        }
    }
}

@Preview
@Composable
fun DeleteCharacterPopUpPreview(){
    DeleteCharacterPopUp("",{})
}