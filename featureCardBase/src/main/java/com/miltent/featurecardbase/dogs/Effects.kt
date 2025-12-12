package com.miltent.featurecardbase.dogs

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.miltent.resources.R as ResR
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun Effects(events: SharedFlow<SearchEvent>) {
    val localContext = LocalContext.current
    LaunchedEffect(events) {
        events.collect { event ->
            when(event){
                is SearchEvent.DogsSearch -> {
                    val msg = if (event.success) {
                        ResR.string.dogs_coming
                    } else {
                        ResR.string.dogs_not_coming
                    }
                    Toast.makeText(localContext,msg, Toast.LENGTH_SHORT).show()
                }
                is SearchEvent.NetworkingError -> {
                    Toast.makeText(
                        localContext,
                        localContext.getString(
                            ResR.string.networking_failed, event.code),
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}