package com.comcast.androidtest.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.comcast.androidtest.R

@Composable
fun AlertDialog(
    message: String,
    modifier: Modifier = Modifier,
    onRetry: () -> Unit,
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = { },
        title = { Text(stringResource(id = R.string.error)) },
        text = { Text(message) },
        confirmButton = {
            Button(
                onClick = { onRetry() }
            ) {
                Text(stringResource(id = R.string.retry))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAlertDialog() {
    AlertDialog(message = "", onRetry = {})
}