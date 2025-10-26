package com.miltent.featurecardbase.characterCard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview


@Composable
internal fun CharacterCardScreen(){
    Box(modifier = Modifier.
    fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text ="Card"
        )
    }
}
@Preview(showBackground = true)
@Composable
fun CharacterCardScreenPreview(){
    CharacterCardScreen()
}