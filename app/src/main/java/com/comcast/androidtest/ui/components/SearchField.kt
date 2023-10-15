package com.comcast.androidtest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.comcast.androidtest.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(searchValue: String, onSearch: (String) -> Unit, onKeyboardDone: () -> Unit) {
    OutlinedTextField(
        value = searchValue,
        singleLine = true,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = onSearch,
        label = {
            Text(stringResource(id = R.string.search))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onKeyboardDone() })
    )
}