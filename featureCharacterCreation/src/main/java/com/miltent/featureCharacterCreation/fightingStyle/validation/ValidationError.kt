package com.miltent.featureCharacterCreation.fightingStyle.validation

import androidx.annotation.StringRes
import com.miltent.resources.R as ResR

sealed class ValidationError(@StringRes val errorResId: Int) {
    object EmptyFightingStyle : ValidationError(ResR.string.fighting_style_empty)
}