package com.miltent.designsystem.skills

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SelectableSkill(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit, modifier: Modifier = Modifier, modificator: String, name: String, value: String) {
    Row {
        Switch(checked = isChecked, onCheckedChange = onCheckedChange)
        Skill(name = name, value = value, modificator = modificator)
    }
}

@Preview
@Composable
fun SelectableSkillPreview() {
    SelectableSkill(isChecked = true, onCheckedChange = {}, modificator = "DEX", name = "Acrobatics", value = "+2")
}