package com.example.desainmu.presentation.common.sharedComponents

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CustomOutlinedTextField(
    modifier: Modifier = Modifier,
    placeHolder: String = "",
    label: String = placeHolder,
    value: String,
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeHolder) },
        label = { Text(text = label) },
        singleLine = false,
        isError = isError,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onDone()
            keyboardController?.hide()
            focusManager.clearFocus()
        })
    )
}

@Composable
fun CustomOutlinedTextFieldNumber(
    modifier: Modifier = Modifier,
    placeHolder: String = "",
    label: String = placeHolder,
    value: String,
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeHolder) },
        label = { Text(text = label) },
        singleLine = false,
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onDone()
            keyboardController?.hide()
            focusManager.clearFocus()
        })
    )
}

@Composable
fun CustomClickableOutlinedTextField(
    modifier: Modifier = Modifier,
    placeHolder: String,
    trailingIcon: ImageVector,
    value: String,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    OutlinedTextField(
        readOnly = true,
        modifier = modifier,
        value = value,
        shape = MaterialTheme.shapes.small,
        onValueChange = {},
        placeholder = {
            Text(text = placeHolder)
        },
        label = {
            Text(text = placeHolder)
        },
        maxLines = 1,
        trailingIcon = {
            Icon(
                imageVector = trailingIcon,
                contentDescription = null,
            )
        },
        interactionSource = interactionSource.also { interaction ->
            LaunchedEffect(key1 = interaction) {
                interaction.interactions.collect {
                    if (it is PressInteraction.Release) {
                        onClick.invoke()
                    }
                }
            }
        }
    )
}