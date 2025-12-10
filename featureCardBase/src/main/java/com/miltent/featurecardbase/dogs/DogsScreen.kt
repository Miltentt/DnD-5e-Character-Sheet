package com.miltent.featurecardbase.dogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.miltent.designsystem.theme.Spacing
import androidx.compose.runtime.collectAsState



@Composable
fun DogsScreen() {
    val viewModel = hiltViewModel<DogsViewModel>()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = Spacing.spacing24),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        TextField(
            value = viewModel.breedText.collectAsState().value,
            onValueChange = { viewModel.changeText(it) },
        )
        Button(
            onClick = { viewModel.searchDogBreeds() },
            content = { Text(text = "SEARCH") }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DogsScreenPreview(){
    DogsScreen()
}