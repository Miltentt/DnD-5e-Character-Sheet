package com.miltent.designsystem.statistics

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.theme.Colors

@Composable
fun StatisticModifierTile(typeText: String, modifierValue: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
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
                .padding(4.dp)
            ,
            textAlign = TextAlign.Center
        )
        Text(
            text = modifierValue.toString(),
            fontSize = 22.sp,
            modifier = Modifier
                .border(
                    shape = RoundedCornerShape(20.dp),
                    width = 2.dp,
                    color = Colors.primary
                )
                .padding(horizontal = 16.dp, vertical = 8.dp))
    }
}