package com.comcast.androidtest.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comcast.androidtest.data.AnimalType
import com.comcast.androidtest.data.AnimalUI
import com.comcast.androidtest.data.UIState
import com.comcast.androidtest.data.toAnimalUIData
import com.comcast.network.repo.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<UIState>(UIState.Loading(false))
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()
    private var animalsList: List<AnimalUI> = emptyList()

    var searchText by mutableStateOf("")
    private var selectedAnimalName by mutableStateOf(AnimalType.Dog.name)

    init {
        loadUserData()
    }

    fun updateAnimalList(name: String) {
        selectedAnimalName = name
        loadUserData()
    }

    fun loadUserData() {
        _uiState.value = UIState.Loading(true)

        viewModelScope.launch {
            apiRepository.getAnimal(selectedAnimalName)
                .catch { exception ->
                    _uiState.value = UIState.Loading(false)
                    _uiState.value = UIState.Error(exception.message ?: "")
                }.map {
                    it.toAnimalUIData(selectedAnimalName)
                }.collect {
                    _uiState.value = UIState.Loading(false)
                    animalsList = it
                    _uiState.value = UIState.Data(animalsList)
                }
        }
    }

    fun filterData(searchValue: String) {
        searchText = searchValue

        if (searchText.isBlank()) {
            _uiState.value = UIState.Data(animalsList.filter {
                it.name?.contains(
                    searchText,
                    ignoreCase = true
                ) == true
            })
        } else {
            _uiState.value = UIState.Data(animalsList.filter {
                it.name?.contains(
                    searchText,
                    ignoreCase = true
                ) == true
            })
        }
    }

    fun onSearch() {
        if (searchText.isNotBlank()) {
            filterData(searchText)
        }
    }
}