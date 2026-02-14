package com.dude.keyboardlibrary.ui.keyboard

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dude.keyboardlibrary.data.Generated
import com.dude.keyboardlibrary.data.model.*
import com.dude.keyboardlibrary.ui.theme.*
import com.intuit.sdp.R.dimen

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
        height = dimensionResource(dimen._42sdp)
    )
    when (keyboardKey) {
        is UtilityKey.UppercaseLong -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = icon_key_background_color,
                contentColor = action_key_background_color
            )
            buttonParams.width = dimensionResource(dimen._41sdp)
            KeyView(
                keyboardKey = keyboardKey,
                color = colors,
                iconSize = dimensionResource(dimen._15sdp),
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
                buttonParams.width = dimensionResource(dimen._68sdp)
            }
            KeyView(
                keyboardKey = keyboardKey,
                textSize = dimensionResource(com.intuit.ssp.R.dimen._19ssp).value.sp,
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
                    start = dimensionResource(dimen._11sdp),
                    bottom = dimensionResource(dimen._9sdp),
                    end = 2.dp
                )
                buttonParams.modifier = modifier
            } else {
                buttonParams.width = dimensionResource(dimen._41sdp)
            }
            KeyView(
                keyboardKey = keyboardKey,
                color = colors,
                iconSize = dimensionResource(dimen._15sdp),
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
                end = dimensionResource(dimen._11sdp),
                start = 2.dp,
                bottom = dimensionResource(dimen._9sdp)
            )
            KeyView(
                keyboardKey = keyboardKey,
                color = colors,
                iconSize = dimensionResource(dimen._15sdp),
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
                textSize = dimensionResource(com.intuit.ssp.R.dimen._12ssp).value.sp,
                color = colors,
                buttonParams = buttonParams
            )
        }

        is TextUtilityKey -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = icon_key_background_color,
                contentColor = Color.Black
            )
            buttonParams.width = dimensionResource(dimen._68sdp)
            KeyView(
                keyboardKey = keyboardKey,
                textSize = dimensionResource(com.intuit.ssp.R.dimen._12ssp).value.sp,
                color = colors,
                buttonParams = buttonParams
            )
        }

        is SpecialCharactersKey.Dot, SpecialCharactersKey.Comma, SpecialCharactersKey.Question, SpecialCharactersKey.Exclamation, SpecialCharactersKey.SingleQuotes -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = text_key_background_color,
                contentColor = Color.Black
            )
            buttonParams.width = dimensionResource(dimen._40sdp)
            KeyView(
                keyboardKey = keyboardKey,
                textSize = dimensionResource(com.intuit.ssp.R.dimen._19ssp).value.sp,
                color = colors,
                buttonParams = buttonParams
            )
        }

        is Alphabets.A, Alphabets.L, UppercaseAlphabets.A, UppercaseAlphabets.L -> {
            KeyView(
                keyboardKey = keyboardKey,
                textSize = dimensionResource(com.intuit.ssp.R.dimen._19ssp).value.sp,
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
                textSize = dimensionResource(com.intuit.ssp.R.dimen._19ssp).value.sp,
                color = colors,
                buttonParams = buttonParams
            )
        }
    }
}