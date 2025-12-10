package com.miltent.featurecardbase.dogs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.miltent.designsystem.theme.Spacing
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.miltent.domain.model.networking.Breed
import com.miltent.domain.model.networking.DogFact

@Composable
fun DogsScreen() {
    val viewModel = hiltViewModel<DogsViewModel>()
    val breedText = viewModel.breedText.collectAsStateWithLifecycle()
    val listOfBreeds = viewModel.dogBreeds.collectAsStateWithLifecycle()
    val listOfBreedFacts = viewModel.breedFacts.collectAsStateWithLifecycle()

    DogsScreen(
        breedText = breedText.value,
        listOfBreeds = listOfBreeds.value,
        listOfBreedFacts = listOfBreedFacts.value,
        changeText = viewModel::changeText,
        searchDogBreeds = viewModel::searchDogBreeds,
        searchBreedFacts = viewModel::searchBreedFacts
        )
}

@Composable
fun DogsScreen(
    breedText: String,
    listOfBreeds: List<Breed>,
    listOfBreedFacts: List<DogFact>?,
    changeText: (String) -> Unit,
    searchDogBreeds: () -> Unit,
    searchBreedFacts: (Int?) -> Unit
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = Spacing.spacing24),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        TextField(
            value = breedText,
            onValueChange = { changeText(it) },
        )
        Button(
            onClick = { searchDogBreeds() },
            content = { Text(text = "SEARCH") }
        )
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(listOfBreeds) { breed ->
                AsyncImage(
                    modifier = Modifier.clickable(onClick = { searchBreedFacts(breed.id) }),
                    model = breed.image.url,
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                )
            }
        }
        if(listOfBreedFacts != null) {
            Dialog(onDismissRequest = { searchBreedFacts(null)} ) {
                Column {
                    listOfBreedFacts.forEach { fact ->
                        Text(listOfBreeds.find { it.id.toString() == fact.id }?.name ?: "No Name")
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
        "",
        emptyList(),
        null,
        {},
        {},
        {}
    )
}