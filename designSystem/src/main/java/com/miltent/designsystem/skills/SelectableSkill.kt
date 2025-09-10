package com.miltent.designsystem.skills

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.theme.Spacing

@Composable
fun SelectableSkill(isChecked: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier, modificator: String, name: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier, horizontalArrangement = Arrangement.spacedBy(
        Spacing.spacing12)) {
        RadioButton(selected = isChecked, onClick = onClick)
        Skill(name = name, value = value, modificator = modificator)
    }
}

@Preview
@Composable
fun SelectableSkillPreview() {
    SelectableSkill(isChecked = true, onClick = {}, modificator = "DEX", name = "Acrobatics", value = "+2")
}