package com.miltent.designsystem.skills

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing

@Composable
fun Skill(modifier: Modifier = Modifier, modificator: String, name: String, value: String) {
    Row {
        Text(text = modificator)
        Column {
            Text(text = name)
            HorizontalDivider(Modifier.width(120.dp))
        }
        Text(text = value, modifier.border(1.dp, Colors.primary, CutCornerShape(10)).padding(Spacing.spacing4))
    }
}

@Composable
@Preview
fun SkillPreview() {
    Skill(
        modificator = "DEX",
        name = "Acrobatics",
        value = "+2"
    )
}