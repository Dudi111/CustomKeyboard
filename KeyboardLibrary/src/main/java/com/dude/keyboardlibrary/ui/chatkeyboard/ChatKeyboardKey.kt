package com.dude.keyboardlibrary.ui.chatkeyboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.dude.keyboardlibrary.data.Generated
import com.dude.keyboardlibrary.data.model.*
import com.dude.keyboardlibrary.ui.theme.*

/**
 * ChatKeyboardKey : This method is used for create ui of chat keyboard key bases on condition
 * @param keyboardKey : pass key parameter
 * @param onClick : Pass onclick action of keyboard key
 * @param modifier : pass modifier for space key only
 * @param onLongPress: pass onLongPress action of keyboard key
 * @param isNumeric: pass true if key is numeric keyboard key else pass false
 */
@Composable
@Generated
internal fun ChatKeyboardKey(
    keyboardKey: Key,
    onClick: (key: Key) -> Unit,
    modifier: Modifier,
    onLongPress: (key: Key) -> Unit,
    isNumeric: Boolean = false
) {
    val buttonParams = ButtonParams(
        onLongClick = { onLongPress(keyboardKey) },
        onClick = { onClick(keyboardKey) },
        enabled = true,
        height = dimen_55dp
    )
    when (keyboardKey) {
        is UtilityKey.Enter -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = action_key_background_color,
                contentColor = Color.White
            )

            buttonParams.width = dimen_88dp
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                color = colors,
                shapes = RoundedCornerShape(dimen_20dp),
                iconSize = dimen_20dp,
                buttonParams = buttonParams
            )
        }

        is UtilityKey.UppercaseEnable, UtilityKey.UppercaseDisable, UtilityKey.UppercaseLong -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = icon_key_background_color,
                contentColor = action_key_background_color
            )
            buttonParams.width = dimen_52dp
            buttonParams.contentPadding = PaddingValues(
                bottom = dimen_12dp,
                start =content_padding_value,
                end = dimen_8dp
            )
            KeyButtonLongClick(
                colors = colors,
                buttonParams = buttonParams,
                content = {
                    val keyId = (keyboardKey as UtilityKey).id
                    Icon(
                        ImageVector.vectorResource(id = keyId),
                        contentDescription = keyboardKey.text,
                        modifier = Modifier.align(Alignment.Center),
                        tint = action_key_background_color
                    )
                }
            )
        }

        is UtilityKey -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = icon_key_background_color,
                contentColor = Color.Black
            )
            if (isNumeric) {
                buttonParams.contentPadding = PaddingValues(
                    start = dimen_14dp,
                    bottom = dimen_12dp,
                    end = content_padding_value
                )
                buttonParams.modifier = modifier
            } else {
                buttonParams.width = dimen_53dp
            }
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                color = colors,
                iconSize = dimen_20dp,
                buttonParams = buttonParams
            )
        }

        is TextUtilityKey.SPACE -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = text_key_background_color,
                contentColor = Color.Black
            )
            buttonParams.modifier = modifier
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_16sp,
                color = colors,
                buttonParams = buttonParams
            )
        }

        is SpecialCharactersKey.UnderScore -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = icon_key_background_color,
                contentColor = Color.Black
            )
            buttonParams.modifier = modifier
            buttonParams.contentPadding = PaddingValues(
                end = dimen_14dp,
                start = content_padding_value,
                bottom = dimen_12dp
            )
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_25sp,
                color = colors,
                buttonParams = buttonParams
            )
        }

        is SpecialCharactersKey.Dot, SpecialCharactersKey.Comma, SpecialCharactersKey.Question, SpecialCharactersKey.Exclamation, SpecialCharactersKey.SingleQuotes -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = text_key_background_color,
                contentColor = Color.Black
            )
            buttonParams.width = dimen_52dp
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_25sp,
                color = colors,
                buttonParams = buttonParams
            )
        }

        is TextUtilityKey -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = icon_key_background_color,
                contentColor = Color.Black
            )
            buttonParams.width = dimen_88dp
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_16sp,
                color = colors,
                buttonParams = buttonParams
            )
        }

        is Alphabets.A, Alphabets.L, UppercaseAlphabets.A, UppercaseAlphabets.L -> {

            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_25sp,
                color = ButtonDefaults.buttonColors(
                    containerColor = text_key_background_color,
                    contentColor = Color.Black
                ),
                buttonParams = getPaddingParamsOfSecondRow(buttonParams, keyboardKey)
            )
        }

        else -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = text_key_background_color,
                contentColor = Color.Black
            )
            buttonParams.modifier = modifier
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_25sp,
                color = colors,
                buttonParams = buttonParams
            )
        }
    }
}