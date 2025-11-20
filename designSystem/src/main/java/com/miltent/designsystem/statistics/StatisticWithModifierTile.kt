package com.miltent.designsystem.statistics

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            .padding(16.dp)
            .border(
                shape = RoundedCornerShape(8.dp),
                width = 2.dp,
                color = Colors.primary
            )
            .padding(4.dp)
    ) {
        Text(text = typeText, fontSize = 12.sp, modifier = Modifier.padding(4.dp))
        Text(
            text = attributeValue.toString(),
            modifier = Modifier
                .padding(4.dp)
                .border(
                    shape = RoundedCornerShape(8.dp),
                    width = 2.dp,
                    color = Colors.primary
                )
                .padding(horizontal = 22.dp),
            fontSize = 40.sp,
        )
        Text(
            text = modifierValue.toString(),
            fontSize = 22.sp,
            modifier = Modifier
                .padding(4.dp)
                .border(
                    shape = RoundedCornerShape(20.dp),
                    width = 2.dp,
                    color = Colors.primary
                )
                .padding(horizontal = 12.dp, vertical = 2.dp)
        )
    }
}

@Preview(showBackground = true,showSystemUi = false)
@Composable
fun StatisticWithModifierTilePreview(){
    StatisticWithModifierTile("DEXTERITY",16,3)
}