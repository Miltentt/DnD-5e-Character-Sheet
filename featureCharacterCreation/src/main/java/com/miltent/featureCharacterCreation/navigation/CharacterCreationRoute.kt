package com.miltent.featureCharacterCreation.navigation

import android.os.Parcelable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.miltent.featureCharacterCreation.baseInfo.navigation.BaseInfoRoute
import com.miltent.featureCharacterCreation.baseInfo.ui.BaseInfoScreen
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
object CharacterCreationRoute

fun NavGraphBuilder.characterCreation() {

    navigation<CharacterCreationRoute>(
        startDestination = BaseInfoRoute
    ) {
        composable<BaseInfoRoute> {
            BaseInfoScreen()
        }

    }
}