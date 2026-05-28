package com.miltent.featurecardbase.characterEquipment.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.featurecardbase.characterEquipment.model.EqArmorValues
import com.miltent.featurecardbase.characterEquipment.model.EqBasicInfo
import com.miltent.featurecardbase.characterEquipment.model.EqSectionInfo

@Composable
fun EqSectionTile(
    content: @Composable () -> Unit,
    eqSectionInfo: EqSectionInfo,
    toggleIsActive: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing.spacing12, vertical = Spacing.spacing8)
            .background(
                Colors.primary,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = Spacing.spacing12, vertical = Spacing.spacing4)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Spacing.spacing4),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = eqSectionInfo.imageVector,
                    contentDescription = null
                )
                Spacer(
                    modifier = Modifier.width(Spacing.spacing8)
                )
                Text(text = eqSectionInfo.name)
            }
            Switch(
                checked = eqSectionInfo.isActive,
                onCheckedChange = { toggleIsActive() }
            )
        }
        content()
    }
}

@Preview
@Composable
fun EqSectionTilePreview() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        EqSectionTile(
            content = {
                BasicInfoSectionContent(
                    EqBasicInfo(),
                    {}, {}, {}, {})
            },
            eqSectionInfo = EqSectionInfo(),
            {}
        )
        EqSectionTile(
            content = {
                ArmorValuesSectionContent(
                    EqArmorValues(), {}, {}, {}, {}, {}
                )
            },
            eqSectionInfo = EqSectionInfo(),
            {}
        )
    }
}