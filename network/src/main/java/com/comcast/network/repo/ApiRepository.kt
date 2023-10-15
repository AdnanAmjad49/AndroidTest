package com.comcast.network.repo

import com.comcast.model.Animal
import kotlinx.coroutines.flow.Flow

interface ApiRepository {
    suspend fun getAnimal(name: String): Flow<List<Animal>>
}