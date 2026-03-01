package com.dude.keyboardlibrary.ui.chatkeyboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.dude.keyboardlibrary.data.model.ButtonParams
import com.dude.keyboardlibrary.ui.theme.*

/**
 * KeyButtonLongClick : This method is for key's long press action
 * @param buttonParams : Passing parameter of Button-params data class
 * @param shape : pass shape of key
 * @param colors: pass color of key's background and content color as colors
 * @param content: content of key button
 */
@Composable
@OptIn(ExperimentalFoundationApi::class)
internal fun KeyButtonLongClick(
    buttonParams: ButtonParams,
    shape: Shape = MaterialTheme.shapes.extraSmall,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    content: @Composable BoxScope.() -> Unit
) {
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val backgroundColor = remember {
        mutableStateOf(colors.containerColor)
    }
    LaunchedEffect(Unit) {
        interactionSource.interactions.collect {
            if (it is PressInteraction.Press) {
                backgroundColor.value = button_pressed_backgroundColor
            } else {
                backgroundColor.value = colors.containerColor
            }
        }
    }

    Surface(
        modifier = buttonParams.modifier
            .height(buttonParams.height)
            .width(buttonParams.width)
            .combinedClickable(
                onLongClick = { buttonParams.onLongClick() },
                onDoubleClick = { buttonParams.onLongClick() },
                onClick = { buttonParams.onClick() },
                interactionSource = interactionSource,
                indication = null
            ),
        color = keyboard_background_color
    ) {
        Box(
            modifier = Modifier
                .padding(
                    bottom = dimen_12dp,
                    start = content_padding_value,
                    end = content_padding_value
                )
                .background(
                    color = backgroundColor.value, shape = shape
                ),
            content = content,
        )
    }
}