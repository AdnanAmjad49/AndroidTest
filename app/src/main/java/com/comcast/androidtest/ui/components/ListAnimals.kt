package com.comcast.androidtest.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.comcast.androidtest.data.AnimalUI

@Composable
fun ListAnimals(data: List<AnimalUI>, isSearchResult: Boolean) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isSearchResult && isLandscape) {
        LazyRow {
            items(data) { animal ->
                AnimalCard(animalUI = animal)
            }
        }
    } else {
        LazyColumn {
            items(data) { animal ->
                AnimalCard(animalUI = animal)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListAnimals() {
    ListAnimals(emptyList(), false)
}