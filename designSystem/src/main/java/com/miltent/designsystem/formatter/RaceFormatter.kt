package com.miltent.designsystem.formatter

import com.miltent.domain.model.Race
import com.miltent.resources.R as ResR

object RaceFormatter {

    fun formatRace(race: Race): Int = when(race) {
        is Race.Dwarf -> ResR.string.race_dwarf
    }
}