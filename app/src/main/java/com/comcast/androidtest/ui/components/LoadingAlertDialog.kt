package com.comcast.androidtest.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.comcast.androidtest.R

@Composable
fun LoadingAlertDialog() {
    AlertDialog(
        onDismissRequest = { },
        title = { Text(stringResource(id = R.string.loading)) },
        text = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
                Text(text = stringResource(id = R.string.loading_wait))
            }
        },
        confirmButton = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoadingAlertDialog() {
    LoadingAlertDialog()
}