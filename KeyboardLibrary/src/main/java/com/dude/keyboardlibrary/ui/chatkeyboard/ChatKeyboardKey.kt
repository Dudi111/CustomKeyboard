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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dude.keyboardlibrary.data.Generated
import com.dude.keyboardlibrary.data.model.*
import com.dude.keyboardlibrary.ui.theme.*
import com.intuit.sdp.R.dimen

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
        height = dimensionResource(dimen._42sdp)
    )
    when (keyboardKey) {
        is UtilityKey.Enter -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = action_key_background_color,
                contentColor = Color.White
            )

            buttonParams.width = dimensionResource(dimen._68sdp)
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                color = colors,
                shapes = RoundedCornerShape(dimensionResource(dimen._15sdp)),
                iconSize = dimensionResource(dimen._15sdp),
                buttonParams = buttonParams
            )
        }

        is UtilityKey.UppercaseEnable, UtilityKey.UppercaseDisable, UtilityKey.UppercaseLong -> {
            val colors = ButtonDefaults.buttonColors(
                containerColor = icon_key_background_color,
                contentColor = action_key_background_color
            )
            buttonParams.width = dimensionResource(dimen._40sdp)
            buttonParams.contentPadding = PaddingValues(
                bottom = dimensionResource(dimen._9sdp),
                start = 2.dp,
                end = dimensionResource(dimen._6sdp)
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
                    start = dimensionResource(dimen._11sdp),
                    bottom = dimensionResource(dimen._9sdp),
                    end = content_padding_value
                )
                buttonParams.modifier = modifier
            } else {
                buttonParams.width = dimensionResource(dimen._41sdp)
            }
            ChatKeyboardKeyView(
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
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimensionResource(com.intuit.ssp.R.dimen._12ssp).value.sp,
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
                end = dimensionResource(dimen._11sdp),
                start = content_padding_value,
                bottom = dimensionResource(dimen._9sdp)
            )
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimensionResource(com.intuit.ssp.R.dimen._19ssp).value.sp,
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
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimensionResource(com.intuit.ssp.R.dimen._19ssp).value.sp,
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
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimensionResource(com.intuit.ssp.R.dimen._12ssp).value.sp,
                color = colors,
                buttonParams = buttonParams
            )
        }

        is Alphabets.A, Alphabets.L, UppercaseAlphabets.A, UppercaseAlphabets.L -> {

            ChatKeyboardKeyView(
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
            ChatKeyboardKeyView(
                keyboardKey = keyboardKey,
                textSize = dimensionResource(com.intuit.ssp.R.dimen._19ssp).value.sp,
                color = colors,
                buttonParams = buttonParams
            )
        }
    }
}