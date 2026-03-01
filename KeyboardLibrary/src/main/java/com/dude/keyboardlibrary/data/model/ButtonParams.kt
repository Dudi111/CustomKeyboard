package com.dude.keyboardlibrary.data.model

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dude.keyboardlibrary.ui.theme.content_padding_value
import com.dude.keyboardlibrary.ui.theme.dimen_12dp
import com.dude.keyboardlibrary.ui.theme.dimen_16dp
import com.dude.keyboardlibrary.ui.theme.dimen_55dp

internal data class ButtonParams(
    var modifier: Modifier = Modifier,
    var onLongClick: () -> Unit = {},
    var onClick: () -> Unit,
    var contentPadding: PaddingValues? = null,
    var enabled: Boolean = true,
    var height: Dp = 0.dp,
    var width: Dp = 0.dp
)

/**
 * getPaddingParamsOfSecondRow : This method will provide parameters of A and L key
 * @param keyboardKey : pass key
 * @param buttonParams : pass initial object of ButtonParams
 */
@Composable
internal fun getPaddingParamsOfSecondRow(
    buttonParams: ButtonParams,
    keyboardKey: Key
): ButtonParams {
    buttonParams.width = dimen_55dp
    if (keyboardKey is Alphabets.A || keyboardKey is UppercaseAlphabets.A) {
        buttonParams.contentPadding = PaddingValues(
            bottom = dimen_12dp,
            start = dimen_16dp,
            end = content_padding_value
        )
    } else {
        buttonParams.contentPadding = PaddingValues(
            bottom = dimen_12dp,
            start = content_padding_value,
            end = dimen_16dp
        )
    }
    return buttonParams
}
