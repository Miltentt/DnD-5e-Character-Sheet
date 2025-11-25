package com.miltent.designsystem.statistics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BaseCardStatisticTile(statName: String, statValue: String) {

    Column(
        modifier = Modifier.padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = statValue.toString(),
            modifier = Modifier
                .padding(horizontal = 12.dp),
            fontSize = 40.sp,
        )
        Text(text = statName, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun BaseCardStatisticTilePreview(){
    BaseCardStatisticTile("SPEED","9")
}