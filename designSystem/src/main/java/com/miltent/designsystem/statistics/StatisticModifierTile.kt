package com.miltent.designsystem.statistics

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
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
fun StatisticModifierTile(typeText: String, modifierValue: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = Spacing.spacing8, vertical = Spacing.spacing4)
            .fillMaxWidth()
    ) {
        Text(
            text = typeText,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .border(
                    shape = RoundedCornerShape(12.dp),
                    width = 2.dp,
                    color = Colors.primary
                )
                .padding(Spacing.spacing4)
            ,
            textAlign = TextAlign.Center
        )
        Text(
            text = modifierValue.toString(),
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .widthIn(min = 55.dp)
                .border(
                    shape = RoundedCornerShape(20.dp),
                    width = 2.dp,
                    color = Colors.primary
                )
                .padding(horizontal = Spacing.spacing16, vertical = Spacing.spacing8))
    }
}

@Preview(showBackground = true)
@Composable
fun StatisticModifierTilePreview(){
    StatisticModifierTile("SIŁAAAAAA",9)
}