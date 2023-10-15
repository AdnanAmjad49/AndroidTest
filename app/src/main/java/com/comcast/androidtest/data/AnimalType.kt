package com.comcast.androidtest.data

sealed class AnimalType(val name: String) {
    object Dog : AnimalType("Dog")
    object Bird : AnimalType("Bird")
    object Bug : AnimalType("Bug")
}

val animalTypeList = arrayOf(AnimalType.Dog.name, AnimalType.Bird.name, AnimalType.Bug.name)