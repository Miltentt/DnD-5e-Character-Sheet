package com.miltent.designsystem.formatter

import com.miltent.domain.model.Race
import com.miltent.resources.R as ResR

object RaceFormatter {

    fun formatRace(race: Race): Int = when(race) {
        Race.Dwarf -> ResR.string.race_dwarf
        Race.Drow -> ResR.string.race_drow
    }
}