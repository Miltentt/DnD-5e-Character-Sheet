package com.miltent.featureCharacterCreation.baseInfo.validator

import androidx.annotation.StringRes
import com.miltent.domain.model.StatisticType
import com.miltent.resources.R as ResR

sealed class ValidationError(@StringRes val errorResId: Int) {
    object EmptyName : ValidationError(ResR.string.base_info_error_empty_name)
    object EmptyRace : ValidationError(ResR.string.base_info_error_empty_race)
    object EmptyClass : ValidationError(ResR.string.base_info_error_empty_class)
    class AttributeOutOfRange(val type: StatisticType) : ValidationError(ResR.string.base_info_error_statistic_out_of_range)
    object StrengthTooHigh : ValidationError(ResR.string.base_info_error_statistic_out_of_range)
    object DexterityTooHigh : ValidationError(ResR.string.base_info_error_statistic_out_of_range)
    object ConstitutionTooHigh : ValidationError(ResR.string.base_info_error_statistic_out_of_range)
    object IntelligenceTooHigh : ValidationError(ResR.string.base_info_error_statistic_out_of_range)
    object WisdomTooHigh : ValidationError(ResR.string.base_info_error_statistic_out_of_range)
    object CharismaTooHigh : ValidationError(ResR.string.base_info_error_statistic_out_of_range)
}