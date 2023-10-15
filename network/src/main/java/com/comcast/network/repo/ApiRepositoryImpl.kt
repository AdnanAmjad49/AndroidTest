package com.comcast.network.repo

import com.comcast.model.Animal
import com.comcast.network.core.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ApiRepositoryImpl(private val apiService: ApiService) : ApiRepository {
    override suspend fun getAnimal(name: String): Flow<List<Animal>> = flow {
        emit(apiService.getAnimals(name))
    }.flowOn(Dispatchers.IO)
}