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
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.resources.R as ResR

@Composable
fun DeleteCharacterPopUp(name: String, onClick: (Boolean) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(Spacing.spacing8)
            .background(Colors.primary)
    )
    {
        Text(text = stringResource(ResR.string.delete_character_dialog, name),
            fontSize = 16.sp,
            modifier = Modifier.padding(Spacing.spacing16),
            textAlign = TextAlign.Center
        )
        Row {
            Text(text = stringResource(ResR.string.yes),
                Modifier
                    .clickable(onClick = { onClick(true)})
                    .padding(Spacing.spacing16),
                fontSize = 22.sp
            )
            Spacer(Modifier.width(Spacing.spacing24))
            Text(text = stringResource(ResR.string.no),
                Modifier
                    .clickable(onClick = { onClick(false)})
                    .padding(Spacing.spacing16),
                fontSize = 22.sp
                )
        }
    }
}

@Preview
@Composable
fun DeleteCharacterPopUpPreview(){
    DeleteCharacterPopUp("Grzegorz",{})
}