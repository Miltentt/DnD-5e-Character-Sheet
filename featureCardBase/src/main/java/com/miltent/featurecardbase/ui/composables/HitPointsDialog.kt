package com.miltent.featurecardbase.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.miltent.domain.model.HealthPoints
import com.miltent.domain.model.HealthPointsAction

private val DIGITS_REGEX = Regex("^\\d*\$")


private val actions = mapOf<HealthPointsAction, String>(
    HealthPointsAction.DAMAGE to "enter damage taken",
    HealthPointsAction.HEAL to " enter hit points healed",
    HealthPointsAction.ADD_TEMPORARY to "add temporary hit points",
    HealthPointsAction.RESET to "reset hit points"
)


@Composable
fun HitPointsDialog(
    modifier: Modifier = Modifier,
    healthPoints: HealthPoints,
    hideThisDialog: () -> Unit,
    changeHp: (HealthPoints) -> Unit
    ) {
    var changeHitPointsDialogOn: HealthPointsAction? by remember { mutableStateOf(null) }
    var text: String by remember { mutableStateOf("") }

    if (changeHitPointsDialogOn == null) {
        Dialog(onDismissRequest = hideThisDialog) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                actions.entries.forEach {
                    Button(
                        onClick = { changeHitPointsDialogOn = it.key }
                    ) {
                        Text(it.value)
                    }
                }
            }
        }
    } else {
        changeHitPointsDialogOn?.let { hitPointAction ->
            Dialog(onDismissRequest = hideThisDialog) {
                Column {
                    if(hitPointAction != HealthPointsAction.RESET) {
                        TextField(
                            value = text,
                            onValueChange = {
                                if (it.matches(DIGITS_REGEX)) text = it
                            },
                            label = { Text("Enter value") },
                            placeholder = {
                                Text("value")
                            }
                        )
                    }
                    Button(
                        onClick = {
                            changeHp(healthPoints.changeHealthPointsValue(hitPointAction,text.toInt(), new = true))
                            changeHitPointsDialogOn = null
                            hideThisDialog()
                        }
                    ) {
                        Text(text= "confirm")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HitPointsDialogPreview(modifier: Modifier = Modifier) {
    HitPointsDialog(
        healthPoints = HealthPoints(50),
        hideThisDialog = {},
        changeHp = {}
    )

}