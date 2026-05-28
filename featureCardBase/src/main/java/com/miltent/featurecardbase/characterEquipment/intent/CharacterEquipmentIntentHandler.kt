package com.miltent.featurecardbase.characterEquipment.intent

import com.miltent.core.cash.CharacterCache
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.useCase.InsertEquipmentUseCase
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnArmorCategoryChange
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnArmorClassChangeByValue
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnArmorValuesSectionToggle
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnBaseInfoSectionToggle
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnDescriptionChange
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnNameChange
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnPropertiesChange
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnRarityChange
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnStealthDisadvantageToggle
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnStrengthReqChangeByValue
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent.OnTypeChange
import com.miltent.featurecardbase.characterEquipment.state.CharacterEquipmentState
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CharacterEquipmentIntentHandler @Inject constructor(
    private val characterCache: CharacterCache,
    private val viewStateProvider: ViewStateProvider<CharacterEquipmentState>,
    private val insertEquipmentUseCase: InsertEquipmentUseCase
) : IntentHandler<CharacterEquipmentIntent> {
    override suspend fun handle(intent: CharacterEquipmentIntent) {
        when (intent) {
            is OnBaseInfoSectionToggle -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        basicInfo = viewStateProvider.viewState.value.basicInfo.copy(
                            eqSectionInfo = viewStateProvider.viewState.value.basicInfo.eqSectionInfo.copy(
                                isActive = !viewStateProvider.viewState.value.basicInfo.eqSectionInfo.isActive
                            )
                        )
                    )
                )
            }

            is OnArmorValuesSectionToggle -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        armorValues = viewStateProvider.viewState.value.armorValues.copy(
                            eqSectionInfo = viewStateProvider.viewState.value.armorValues.eqSectionInfo.copy(
                                isActive = !viewStateProvider.viewState.value.armorValues.eqSectionInfo.isActive
                            )
                        )
                    )
                )
            }

            is OnNameChange -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        basicInfo = viewStateProvider.viewState.value.basicInfo.copy(
                            name = intent.name
                        )
                    )
                )
            }

            is OnTypeChange -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        basicInfo = viewStateProvider.viewState.value.basicInfo.copy(
                            type = intent.type
                        )
                    )
                )
            }

            is OnRarityChange -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        basicInfo = viewStateProvider.viewState.value.basicInfo.copy(
                            rarity = intent.rarity
                        )
                    )
                )
            }

            is OnDescriptionChange -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        basicInfo = viewStateProvider.viewState.value.basicInfo.copy(
                            description = intent.description
                        )
                    )
                )
            }

            is OnArmorCategoryChange -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        armorValues = viewStateProvider.viewState.value.armorValues.copy(
                            armorCategory = intent.armorCategory
                        )
                    )
                )
            }

            is OnArmorClassChangeByValue -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        armorValues = viewStateProvider.viewState.value.armorValues.copy(
                            armorClassValue = viewStateProvider.viewState.value.armorValues.armorClassValue + intent.armorClassChangeValue
                        )
                    )
                )
            }

            is OnStrengthReqChangeByValue -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        armorValues = viewStateProvider.viewState.value.armorValues.copy(
                            strengthRequirement = viewStateProvider.viewState.value.armorValues.strengthRequirement + intent.strengthReqChangeValue
                        )
                    )
                )
            }

            is OnPropertiesChange -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        armorValues = viewStateProvider.viewState.value.armorValues.copy(
                            properties = if (intent.property in viewStateProvider.viewState.value.armorValues.properties) {
                                viewStateProvider.viewState.value.armorValues.properties - intent.property
                            } else {
                                viewStateProvider.viewState.value.armorValues.properties + intent.property
                            }
                        )
                    )
                )
            }

            is OnStealthDisadvantageToggle -> {
                viewStateProvider.updateState(
                    viewStateProvider.viewState.value.copy(
                        armorValues = viewStateProvider.viewState.value.armorValues.copy(
                            stealthDisadvantage = !viewStateProvider.viewState.value.armorValues.stealthDisadvantage
                        )
                    )
                )
            }

            is CharacterEquipmentIntent.OnAddEquipment -> {
                insertEquipmentUseCase.invoke(equipment = characterCache.equipmentCache.value,
                    characterCache.characterCache.value?.id ?: throw IllegalArgumentException()
                )
                viewStateProvider.updateState(CharacterEquipmentState())
            }
        }
    }

}