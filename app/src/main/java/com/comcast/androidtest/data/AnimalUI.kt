package com.comcast.androidtest.data

import com.comcast.model.Animal

data class AnimalUI(
    val name: String? = null,
    val phylum: String? = null,
    val scientificName: String? = null,
    var slogan: String? = null,
    var lifeSpan: String? = null,
    var wingSpan: String? = null,
    var habitat: String? = null,
    var prey: String? = null,
    var predators: String? = null,
    var animalType: String = "",
)

fun List<Animal>.toAnimalUIData(type: String): List<AnimalUI> {
    val animals = mutableListOf<AnimalUI>()
    this.forEach { animal ->
        val animalUI = AnimalUI(
            name = animal.name,
            phylum = animal.taxonomy?.phylum,
            scientificName = animal.taxonomy?.scientificName,
            animalType = type
        )

        when (type) {
            AnimalType.Dog.name -> {
                animalUI.slogan = animal.characteristics?.slogan
                animalUI.lifeSpan = animal.characteristics?.lifespan
            }

            AnimalType.Bird.name -> {
                animalUI.wingSpan = animal.characteristics?.wingspan
                animalUI.habitat = animal.characteristics?.habitat
            }

            AnimalType.Bug.name -> {
                animalUI.prey = animal.characteristics?.prey
                animalUI.predators = animal.characteristics?.predators
            }
        }
        animals.add(animalUI)
    }
    return animals
}
