package com.dude.keyboardlibrary.ui.keyboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dude.keyboardlibrary.data.Generated
import com.dude.keyboardlibrary.data.model.ButtonParams
import com.dude.keyboardlibrary.data.model.Key
import com.dude.keyboardlibrary.data.model.UtilityKey

/**
 * KeyView : This method calls custom button of keyboard
 * @param keyboardKey : Key of keyboard
 * @param textSize : size of key's text
 * @param color: background and text color of key
 * @param iconSize: icon size of key
 * @param buttonParams : pass ButtonParams with required parameters
 */
@Generated
@Stable
@Composable
internal fun KeyView(
    keyboardKey: Key,
    textSize: TextUnit = 0.sp,
    color: ButtonColors,
    iconSize: Dp = 0.dp,
    buttonParams: ButtonParams,
) {

    when (keyboardKey) {
        is UtilityKey.UppercaseLong -> {
            KeyButton(
                colors = color,
                buttonParams = buttonParams,
                content = {
                    Icon(
                        ImageVector.vectorResource(id = keyboardKey.id),
                        contentDescription = keyboardKey.text,
                        modifier = Modifier
                            .size(iconSize)
                            .align(Alignment.Center),
                        tint = color.contentColor
                    )
                }
            )
        }

        is UtilityKey.Backspace -> {
            KeyButton(
                colors = color,
                buttonParams = buttonParams,
                content = {
                    Icon(
                        ImageVector.vectorResource(id = keyboardKey.id),
                        contentDescription = keyboardKey.text,
                        modifier = Modifier
                            .size(iconSize)
                            .align(Alignment.Center),
                        tint = color.contentColor
                    )
                },
                isBackSpaceKey = true
            )
        }

        else -> {
            KeyButton(
                colors = color,
                buttonParams = buttonParams,
                content = {
                    Text(
                        text = keyboardKey.text,
                        style = TextStyle(
                            fontSize = textSize,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.align(Alignment.Center),
                        color = color.contentColor
                    )
                }
            )
        }
    }
}