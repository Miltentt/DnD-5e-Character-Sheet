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

@Composable
fun StatisticWithModifierTile(typeText:String, attributeValue: Int, modifierValue: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                shape = RoundedCornerShape(12.dp),
                width = 2.dp,
                color = Colors.primary
            )
            .padding(4.dp)
    ) {
        Text(text = typeText, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        Text(
            text = modifierValue.toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .widthIn(min = 100.dp)
                .padding(4.dp)
                .border(
                    shape = RoundedCornerShape(12.dp),
                    width = 2.dp,
                    color = Colors.primary
                )
                .padding(horizontal = 22.dp),
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
                .padding(horizontal = 12.dp, vertical = 2.dp)
        )
        Spacer(Modifier.padding(2.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun StatisticWithModifierTilePreview(){
    StatisticWithModifierTile("DEXTERITY",16,3)
}