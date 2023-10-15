package com.comcast.androidtest.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.comcast.androidtest.data.AnimalUI
import com.comcast.androidtest.data.UIState
import com.comcast.androidtest.ui.components.AlertDialog
import com.comcast.androidtest.ui.components.ListAnimals
import com.comcast.androidtest.ui.components.LoadingAlertDialog
import com.comcast.androidtest.ui.components.SearchField
import com.comcast.androidtest.ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(modifier = Modifier
        .fillMaxSize(), topBar = {
        TopBar { selectedAnimal ->
            viewModel.updateAnimalList(selectedAnimal)
        }
    }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when (uiState) {
                is UIState.Loading -> {
                    val isShow = (uiState as UIState.Loading).isShow
                    if (isShow) {
                        LoadingAlertDialog()
                    }
                }

                is UIState.Error -> {
                    val data = (uiState as UIState.Error).message
                    AlertDialog(data) {
                        viewModel.loadUserData()
                    }
                }

                is UIState.Data -> {
                    val data = (uiState as UIState.Data).data
                    LoadScreenData(viewModel, data)
                }
            }
        }
    })
}

@Composable
fun LoadScreenData(viewModel: HomeScreenViewModel, data: List<AnimalUI>) {
    Column(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        SearchField(
            searchValue = viewModel.searchText,
            onSearch = { searchText ->
                viewModel.filterData(searchText)
            }, onKeyboardDone = {
                viewModel.onSearch()
            })

        ListAnimals(data = data, viewModel.searchText.isNotBlank())
    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen()
}