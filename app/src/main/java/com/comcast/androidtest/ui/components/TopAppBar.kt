package com.comcast.androidtest.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comcast.androidtest.R
import com.comcast.androidtest.data.animalTypeList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onItemSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val items = animalTypeList

    TopAppBar(colors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.onPrimary
    ), title = { Text(stringResource(id = R.string.app_name)) }, actions = {
        IconButton(onClick = { expanded = true }) {
            Icon(
                Icons.Default.MoreVert,
                contentDescription = stringResource(id = R.string.title_menu),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(200.dp)
        ) {
            items.forEach { item ->
                DropdownMenuItem(text = {
                    Text(item, fontSize = 24.sp)
                }, onClick = { onItemSelect.invoke(item) }, leadingIcon = {
                    Icon(
                        Icons.Outlined.KeyboardArrowRight, contentDescription = null
                    )
                })
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun previewTopBar() {
    TopBar { }
}