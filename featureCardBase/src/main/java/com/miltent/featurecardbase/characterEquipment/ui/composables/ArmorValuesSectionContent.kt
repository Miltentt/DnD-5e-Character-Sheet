package com.miltent.featurecardbase.characterEquipment.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.domain.model.ArmorCategory
import com.miltent.featurecardbase.characterEquipment.model.EqArmorValues
import com.miltent.domain.model.Property
import com.miltent.resources.R as ResR

@Composable
fun ArmorValuesSectionContent(
    armorValues: EqArmorValues,
    changeArmorCategory: (ArmorCategory) -> Unit,
    changeArmorClass: (Int) -> Unit,
    changeStrengthReq: (Int) -> Unit,
    toggleStealthDisadvantage: () -> Unit,
    changeProperties: (Property) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(ResR.string.armor_category),
            modifier = Modifier.padding(start = Spacing.spacing2),
            fontSize = 12.sp
        )
        val scrollState1 = rememberScrollState()
        Row(modifier = Modifier.horizontalScroll(scrollState1)) {
            ArmorCategory.entries.forEach {
                SimpleTile(
                    name = it.name,
                    checked = it == armorValues.armorCategory,
                    changeChecked = { changeArmorCategory(it) })
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            ClickUpDownTile(
                modifier = Modifier.weight(1f),
                name = stringResource(ResR.string.armor_class_ac),
                value = armorValues.armorClassValue,
                plusValue = { changeArmorClass(1) },
                minusValue = { changeArmorClass(-1) }
            )
            ClickUpDownTile(
                modifier = Modifier.weight(1f),
                name = stringResource(ResR.string.strength_req),
                value = armorValues.strengthRequirement,
                plusValue = { changeStrengthReq(1) },
                minusValue = { changeStrengthReq(-1) }
            )
            SwitchTile(
                modifier = Modifier.weight(1f),
                name = stringResource(ResR.string.stealth_disadvantage),
                additionalInfo = stringResource(ResR.string.imposes_disadvantage),
                checked = armorValues.stealthDisadvantage,
                toggle = toggleStealthDisadvantage
            )
        }

        Text(
            text = stringResource(ResR.string.properties),
            modifier = Modifier.padding(start = Spacing.spacing2),
            fontSize = 12.sp
        )
        val scrollState2 = rememberScrollState()
        Row(
            modifier = Modifier.horizontalScroll(state = scrollState2)
        ) {
            Property.entries.forEach {
                SimpleTile(
                    it.name, it in armorValues.properties, changeChecked = { changeProperties(it) })
            }
        }
    }
}


@Composable
fun SimpleTile(name: String, checked: Boolean, changeChecked: () -> Unit) {

    Box(
        modifier = Modifier
            .padding(Spacing.spacing2)
            .background(
                if (checked) Colors.pinkLemonade else Colors.primary,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                color = Colors.onPrimary, shape = RoundedCornerShape(16.dp), width = 1.dp
            )
            .clickable(onClick = changeChecked)
    ) {
        Text(
            text = name, modifier = Modifier.padding(
                vertical = Spacing.spacing4, horizontal = Spacing.spacing16
            ), fontSize = 10.sp
        )
    }
}

@Composable
fun SwitchTile(
    modifier: Modifier, name: String, additionalInfo: String, checked: Boolean, toggle: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxHeight()
            .padding(Spacing.spacing2)
            .background(Colors.primary, shape = RoundedCornerShape(16.dp))
            .border(
                color = Colors.onPrimary, shape = RoundedCornerShape(16.dp), width = 1.dp
            )
    ) {
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            modifier = Modifier.padding(
                vertical = Spacing.spacing4
            )
        )
        Text(text = additionalInfo, textAlign = TextAlign.Center, fontSize = 10.sp)
        Switch(checked = checked, onCheckedChange = { toggle() })
    }
}

@Composable
fun ClickUpDownTile(
    modifier: Modifier, name: String, value: Int, plusValue: () -> Unit, minusValue: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxHeight()
            .padding(Spacing.spacing2)
            .background(Colors.primary, shape = RoundedCornerShape(16.dp))
            .border(
                color = Colors.onPrimary, shape = RoundedCornerShape(16.dp), width = 1.dp
            )
    ) {
        Text(
            text = name,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = Spacing.spacing4),
            fontSize = 12.sp
        )
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = value.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Column(modifier = Modifier.weight(1f)) {
                IconButton(onClick = plusValue) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = null
                    )
                }
                IconButton(onClick = minusValue) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ArmorValuesSectionContentPreview() {
    Box(modifier = Modifier.padding(horizontal = Spacing.spacing24)) {
        ArmorValuesSectionContent(EqArmorValues(), {}, {}, {}, {}, {})
    }
}