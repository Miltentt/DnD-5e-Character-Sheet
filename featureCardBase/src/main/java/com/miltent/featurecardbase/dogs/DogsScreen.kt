package com.miltent.featurecardbase.dogs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.miltent.designsystem.theme.Spacing
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage

@Composable
fun DogsScreen() {
    val viewModel = hiltViewModel<DogsViewModel>()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val events = viewModel.searchEvent
    Effects(events)
    DogsScreen(
        uiState = uiState.value,
        changeText = viewModel::changeText,
        searchDogBreeds = viewModel::searchDogBreeds,
        searchBreedFacts = viewModel::searchBreedFacts
        )
}

@Composable
fun DogsScreen(
    uiState: DogsUiState,
    changeText: (String) -> Unit,
    searchDogBreeds: () -> Unit,
    searchBreedFacts: (Int?) -> Unit
    ) {
    val localFocusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = Spacing.spacing24),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        TextField(
            value = uiState.breedText,
            onValueChange = { changeText(it) },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    localFocusManager.clearFocus()
                    searchDogBreeds()
                }
            )
        )
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(uiState.dogBreeds) { breed ->
                AsyncImage(
                    modifier = Modifier.clickable(onClick = { searchBreedFacts(breed.id) }),
                    model = breed.image.url,
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                )
            }
        }
        if(uiState.breedFacts != null) {
            Dialog(onDismissRequest = { searchBreedFacts(null)} ) {
                Column {
                    uiState.breedFacts.forEach { fact ->
                        Text(uiState.dogBreeds.find { it.id.toString() == fact.id }?.name ?: "No Name")
                        Text(fact.fact)
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DogsScreenPreview(){
    DogsScreen(
        uiState = DogsUiState("", emptyList(), null),
        changeText = {},
        searchDogBreeds = {},
        searchBreedFacts = {}
    )
}