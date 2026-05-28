package com.miltent.featurecardbase.characterEquipment.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.featurecardbase.characterEquipment.model.EqBasicInfo
import com.miltent.domain.model.EqRarity
import com.miltent.domain.model.EqType
import com.miltent.resources.R as ResR

@Composable
fun BasicInfoSectionContent(
    eqBasicInfo: EqBasicInfo,
    changeName: (String) -> Unit,
    changeType: (String) -> Unit,
    changeRarity: (String) -> Unit,
    changeDescription: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.height(200.dp)) {
            AddImageTile()
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                EqTextField(eqBasicInfo.name, stringResource(ResR.string.name), changeName)
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    EqDropDownMenu(
                        modifier = Modifier.weight(1f),
                        options = EqType.entries.map { it.name },
                        label = stringResource(ResR.string.type),
                        currentOption = eqBasicInfo.type.name,
                        updateOption = { newOptionName ->
                            changeType(newOptionName)
                        }
                    )
                    EqDropDownMenu(
                        options = EqRarity.entries.map { it.name },
                        modifier = Modifier.weight(1f),
                        label = stringResource(ResR.string.rarity),
                        currentOption = eqBasicInfo.rarity.name,
                        updateOption = { newOptionName ->
                            changeRarity(newOptionName)
                        }
                    )
                }
            }
        }
        EqTextField(eqBasicInfo.description, stringResource(ResR.string.description), changeDescription)
    }
}

@Composable
fun EqTextField(text: String, label: String, changeText: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spacing.spacing4)
            .border(
                1.dp, Colors.onPrimary, RoundedCornerShape(16.dp)
            )
            .background(Colors.primary, shape = RoundedCornerShape(16.dp))
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = label, modifier = Modifier.padding(start = Spacing.spacing16), fontSize = 12.sp)
        TextField(
            value = text,
            onValueChange = { changeText(it) },
            placeholder = { Text(text = stringResource(ResR.string.place), fontSize = 12.sp) },
            singleLine = true,
            colors = TextFieldDefaults.colors().copy(
                unfocusedContainerColor = Colors.primary,
                focusedIndicatorColor = Colors.transparent,
                unfocusedIndicatorColor = Colors.transparent,
                disabledIndicatorColor = Colors.transparent
            ),
            shape = RoundedCornerShape(16.dp),
            textStyle = LocalTextStyle.current.copy(fontSize = 12.sp)
        )
    }
}

@Composable
fun AddImageTile() {
    var imageLoaded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .height(200.dp)
            .width(120.dp)
            .padding(Spacing.spacing4)
            .border(
                1.dp, Colors.onPrimary, RoundedCornerShape(16.dp)
            )
            .background(Colors.primary, shape = RoundedCornerShape(16.dp))
            .clickable(onClick = { imageLoaded = true }),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (imageLoaded) {
            Image(
                painter = painterResource(ResR.drawable.fighter),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clipToBounds()
            )
        } else {
            Image(
                painter = painterResource(ResR.drawable.ic_weapon),
                contentDescription = ""
            )
            Text(text = stringResource(ResR.string.add_image), fontSize = 12.sp)
        }
    }
}

@Composable
fun EqDropDownMenu(
    modifier: Modifier,
    label: String,
    options: List<String> = listOf("one", "two", "three", "four"),
    currentOption: String,
    updateOption: (String) -> Unit = {}
) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .padding(Spacing.spacing4)
            .border(
                1.dp, Colors.onPrimary, RoundedCornerShape(16.dp)
            )
            .background(Colors.primary, shape = RoundedCornerShape(16.dp))
            .padding(start = Spacing.spacing16)
    ) {
        Spacer(modifier = Modifier.height(Spacing.spacing16))
        Text(text = label, fontSize = 12.sp)

        Row(
            modifier = Modifier
                .padding(vertical = Spacing.spacing8)
                .clickable(onClick = { isExpanded = !isExpanded }),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = currentOption, fontSize = 12.sp)
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = null,
            )
        }
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            options.forEach {
                DropdownMenuItem(
                    { Text(it) },
                    onClick = {
                        isExpanded = false
                        updateOption(it)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun BasicInfoSectionContentPreview() {
    BasicInfoSectionContent(
        eqBasicInfo = EqBasicInfo(),
        changeName = {},
        changeType = {},
        changeRarity = {},
        changeDescription = {}
    )
}