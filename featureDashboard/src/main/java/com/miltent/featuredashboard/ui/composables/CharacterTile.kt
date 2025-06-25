package com.miltent.featuredashboard.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.resources.R as ResR

@Composable
fun CharacterTile(name: String, level: Int, race: String, clazz: Clazz) {
    Row(modifier = Modifier.fillMaxWidth().height(200.dp).background(Colors.onPrimary), horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.padding(top = Spacing.large).offset(x = Spacing.large).zIndex(1f), verticalArrangement = Arrangement.Center) {
            Text(text = name, color = Colors.primary, fontSize = 36.sp, modifier = Modifier.padding(bottom = Spacing.extraSmall))
            Text("Level 7", color = Colors.primary, modifier = Modifier.padding(bottom = Spacing.small),fontSize = 22.sp)
            Row {
                Text("Dwarf", color = Colors.primary, fontSize = 16.sp, modifier = Modifier.padding(end = Spacing.extraSmall))
                Text("Fighter", fontSize = 16.sp, color = Colors.primary)
            }
        }
        Image(
            painter = painterResource(ResR.drawable.fighter),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().clipToBounds()
        )
    }
}

@Preview
@Composable
fun CharacterTile_PREVIEW() {
    CharacterTile()
}