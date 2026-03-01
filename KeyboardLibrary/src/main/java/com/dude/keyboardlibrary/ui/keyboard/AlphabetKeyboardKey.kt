package com.dude.keyboardlibrary.ui.keyboard

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dude.keyboardlibrary.data.Generated
import com.dude.keyboardlibrary.data.model.*
import com.dude.keyboardlibrary.ui.theme.*

/**
 * AlphabetKeyboardKey : This method is used for calling keyboard view method based on different ui properties
 * @param keyboardKey : pass keyboard key
 * @param onClick : Pass onclick action of keyboard key
 * @param modifier : pass modifier for space key only
 * @param isNumeric: pass true if keyboard key is numeric with special keys false if keys is alphabets
 */
@Composable
@Stable
@Generated
internal fun AlphabetKeyboardKey(
    keyboardKey: Key,
    onClick: (key: Key) -> Unit,
    modifier: Modifier,
    isNumeric: Boolean
) {
    val buttonParams = ButtonParams(
        modifier = Modifier,
        onLongClick = {},
        onClick = { onClick(keyboardKey) },
        enabled = true,
        height = dimen_55dp
    )
    when (keyboardKey) {
        is UtilityKey.UppercaseLong -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = icon_key_background_color,
                contentColor = action_key_background_color
            )
            buttonParams.width = dimen_53dp
            KeyView(
                keyboardKey = keyboardKey,
                color = colors,
                iconSize = dimen_20dp,
                buttonParams = buttonParams
            )
        }

        is SpecialCharactersKey.Dash -> {
            var colors = ButtonDefaults.buttonColors(
                containerColor = icon_key_background_color,
                contentColor = Color.Black
            )
            if (isNumeric) {
                buttonParams.modifier = modifier
                colors = ButtonDefaults.buttonColors(
                    containerColor = text_key_background_color,
                    contentColor = Color.Black
                )
            } else {
                buttonParams.width = dimen_88dp
            }
            KeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_25sp,
                color = colors,
                buttonParams = buttonParams
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
            KeyView(
                keyboardKey = keyboardKey,
                color = colors,
                iconSize = dimen_20dp,
                buttonParams = buttonParams
            )
        }

        is BlankKey.EmptyKey -> {
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
            KeyView(
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
            KeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_16sp,
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
            KeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_16sp,
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
            KeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_25sp,
                color = colors,
                buttonParams = buttonParams
            )
        }

        is Alphabets.A, Alphabets.L, UppercaseAlphabets.A, UppercaseAlphabets.L -> {
            KeyView(
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
            KeyView(
                keyboardKey = keyboardKey,
                textSize = dimen_25sp,
                color = colors,
                buttonParams = buttonParams
            )
        }
    }
}