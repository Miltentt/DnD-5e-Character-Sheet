package com.miltent.designsystem.statistics

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing

@Composable
fun StatisticWithModifierTile(typeText:String, attributeValue: Int, modifierValue: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spacing.spacing8)
            .border(
                shape = RoundedCornerShape(12.dp),
                width = 2.dp,
                color = Colors.primary
            )
            .padding(Spacing.spacing4)
    ) {
        Text(text = typeText, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        Text(
            text = modifierValue.toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .widthIn(min = 100.dp)
                .padding(Spacing.spacing4)
                .border(
                    shape = RoundedCornerShape(12.dp),
                    width = 2.dp,
                    color = Colors.primary
                )
                .padding(horizontal = Spacing.spacing24),
            fontSize = 40.sp,
        )
        Text(
            text = attributeValue.toString(),
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .widthIn(min = 55.dp)
                .border(
                    shape = RoundedCornerShape(20.dp),
                    width = 2.dp,
                    color = Colors.primary
                )
                .padding(horizontal = Spacing.spacing12, vertical = Spacing.spacing2)
        )
        Spacer(Modifier.padding(Spacing.spacing2))
    }
}

@Preview(showBackground = true)
@Composable
fun StatisticWithModifierTilePreview(){
    StatisticWithModifierTile("DEXTERITY",16,3)
}