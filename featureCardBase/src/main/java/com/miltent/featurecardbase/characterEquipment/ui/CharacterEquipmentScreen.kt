package com.miltent.featurecardbase.characterEquipment.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent
import com.miltent.domain.model.EqRarity
import com.miltent.domain.model.EqType
import com.miltent.featurecardbase.characterEquipment.state.CharacterEquipmentState
import com.miltent.featurecardbase.characterEquipment.ui.composables.ArmorValuesSectionContent
import com.miltent.featurecardbase.characterEquipment.ui.composables.BasicInfoSectionContent
import com.miltent.featurecardbase.characterEquipment.ui.composables.EqSectionTile

@Composable
internal fun CharacterEquipmentScreen() {
    val viewModel: CharacterEquipmentViewModel = hiltViewModel()
    val viewState: CharacterEquipmentState by viewModel.viewState.collectAsStateWithLifecycle()
    CharacterEquipmentScreen(viewState, viewModel::setIntent)
}

@Composable
internal fun CharacterEquipmentScreen(
    state: CharacterEquipmentState,
    onIntent: (CharacterEquipmentIntent) -> Unit
) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        EqSectionTile(
            content = {
                BasicInfoSectionContent(
                    state.basicInfo,
                    { name -> onIntent.invoke(CharacterEquipmentIntent.OnNameChange(name)) },
                    { type ->
                        onIntent.invoke(CharacterEquipmentIntent.OnTypeChange(EqType.entries.find { it.name == type }
                            ?: throw IllegalArgumentException()))
                    },
                    { rarity ->
                        onIntent.invoke(CharacterEquipmentIntent.OnRarityChange(EqRarity.entries.find { it.name == rarity }
                            ?: throw IllegalArgumentException()))
                    },
                    { description ->
                        onIntent.invoke(
                            CharacterEquipmentIntent.OnDescriptionChange(
                                description
                            )
                        )
                    }
                )
            },
            eqSectionInfo = state.basicInfo.eqSectionInfo,
            toggleIsActive = { onIntent.invoke(CharacterEquipmentIntent.OnBaseInfoSectionToggle) }
        )
        EqSectionTile(
            content = {
                ArmorValuesSectionContent(
                    state.armorValues,
                    changeArmorCategory = { armorCategory ->
                        onIntent.invoke(
                            CharacterEquipmentIntent.OnArmorCategoryChange(
                                armorCategory
                            )
                        )
                    },
                    changeArmorClass = { value ->
                        onIntent.invoke(
                            CharacterEquipmentIntent.OnArmorClassChangeByValue(
                                value
                            )
                        )
                    },
                    changeStrengthReq = { value ->
                        onIntent.invoke(
                            CharacterEquipmentIntent.OnStrengthReqChangeByValue(
                                value
                            )
                        )
                    },
                    changeProperties = { property ->
                        onIntent.invoke(
                            CharacterEquipmentIntent.OnPropertiesChange(
                                property
                            )
                        )
                    },
                    toggleStealthDisadvantage = { onIntent.invoke(CharacterEquipmentIntent.OnStealthDisadvantageToggle) }
                )
            },
            eqSectionInfo = state.armorValues.eqSectionInfo,
            toggleIsActive = { onIntent.invoke(CharacterEquipmentIntent.OnArmorValuesSectionToggle) }
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable(onClick = {onIntent.invoke(CharacterEquipmentIntent.OnAddEquipment)})
                .fillMaxWidth()
                .padding(horizontal = Spacing.spacing12, vertical = Spacing.spacing8)
                .background(
                    Colors.primary,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(Spacing.spacing16)){
            Text(text = "Add Equipment")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterEquipmentScreenPreview() {
    CharacterEquipmentScreen(CharacterEquipmentState(), {})
}