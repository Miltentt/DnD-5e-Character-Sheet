package com.miltent.featureCharacterCreation.baseInfo.validator

import androidx.annotation.StringRes
import com.miltent.resources.R as ResR

sealed class ValidationError(@StringRes val errorResId: Int) {
    object EmptyName : ValidationError(ResR.string.base_info_error_empty_name)
    object EmptyRace : ValidationError(ResR.string.base_info_error_empty_race)
    object EmptyClass : ValidationError(ResR.string.base_info_error_empty_class)
    object StrengthTooHigh : ValidationError(ResR.string.base_info_error_statistic_too_high)
    object DexterityTooHigh : ValidationError(ResR.string.base_info_error_statistic_too_high)
    object ConstitutionTooHigh : ValidationError(ResR.string.base_info_error_statistic_too_high)
    object IntelligenceTooHigh : ValidationError(ResR.string.base_info_error_statistic_too_high)
    object WisdomTooHigh : ValidationError(ResR.string.base_info_error_statistic_too_high)
    object CharismaTooHigh : ValidationError(ResR.string.base_info_error_statistic_too_high)
}