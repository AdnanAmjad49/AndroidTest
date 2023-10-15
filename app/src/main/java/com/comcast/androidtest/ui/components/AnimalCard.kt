package com.comcast.androidtest.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comcast.androidtest.R
import com.comcast.androidtest.data.AnimalType
import com.comcast.androidtest.data.AnimalUI

@Composable
fun AnimalCard(animalUI: AnimalUI, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier.padding(8.dp)) {
            val animalName = "${stringResource(id = R.string.name)} ${animalUI.name ?: stringResource(id = R.string.not_available)}"
            Text(text = animalName)

            val phylum = "${stringResource(id = R.string.phylum)} ${animalUI.phylum ?: stringResource(id = R.string.not_available)}"
            Text(text = phylum)

            val scientificName = "${stringResource(id = R.string.scientific_name)} ${animalUI.scientificName ?: stringResource(id = R.string.not_available)}"
            Text(text = scientificName)

            if (animalUI.animalType.equals(AnimalType.Dog.name, true)) {
                val slogan = "${stringResource(id = R.string.slogan)} ${animalUI.slogan ?: stringResource(id = R.string.not_available)}"
                Text(text = slogan)

                val lifespan = "${stringResource(id = R.string.lifespan)} ${animalUI.lifeSpan ?: stringResource(id = R.string.not_available)}"
                Text(text = lifespan)

            } else if (animalUI.animalType.equals(AnimalType.Bird.name, true)) {
                val wingspan = "${stringResource(id = R.string.wingspan)} ${animalUI.wingSpan ?: stringResource(id = R.string.not_available)}"
                Text(text = wingspan)

                val habitat = "${stringResource(id = R.string.habitat)} ${animalUI.habitat ?: stringResource(id = R.string.not_available)}"
                Text(text = habitat)

            } else if (animalUI.animalType.equals(AnimalType.Bug.name, true)) {
                val prey = "${stringResource(id = R.string.prey)} ${animalUI.prey ?: stringResource(id = R.string.not_available)}"
                Text(text = prey)

                val predators = "${stringResource(id = R.string.predators)} ${animalUI.predators ?: stringResource(id = R.string.not_available)}"
                Text(text = predators)
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun previewAnimalCard() {
    AnimalCard(AnimalUI())
}