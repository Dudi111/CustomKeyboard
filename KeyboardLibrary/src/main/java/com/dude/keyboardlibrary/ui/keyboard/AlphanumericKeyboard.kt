package com.dude.keyboardlibrary.ui.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.dude.keyboardlibrary.data.Generated
import com.dude.keyboardlibrary.data.KeysConstants.FIRST_ROW_ALPHANUMERIC_NUMBER
import com.dude.keyboardlibrary.data.KeysConstants.FIRST_ROW_ALPHANUMERIC_TEXT
import com.dude.keyboardlibrary.data.KeysConstants.FOUR_ROW_ALPHANUMERIC_NUMBER
import com.dude.keyboardlibrary.data.KeysConstants.FOUR_ROW_ALPHANUMERIC_TEXT
import com.dude.keyboardlibrary.data.KeysConstants.SECOND_ROW_ALPHANUMERIC_NUMBER
import com.dude.keyboardlibrary.data.KeysConstants.SECOND_ROW_ALPHANUMERIC_TEXT
import com.dude.keyboardlibrary.data.KeysConstants.THIRD_ROW_ALPHANUMERIC_NUMBER
import com.dude.keyboardlibrary.data.KeysConstants.THIRD_ROW_ALPHANUMERIC_TEXT
import com.dude.keyboardlibrary.data.KeysDataSource
import com.dude.keyboardlibrary.data.model.*
import com.dude.keyboardlibrary.ui.theme.*
import com.intuit.sdp.R.dimen

/**
 * AlphanumericKeyboard : This method create a keyboard view for alphanumeric keyboard
 * @param modifier : modifier for keyboard view
 * @param keyActionHandler : object of KeyActionHandler class
 */
//This SuppressWarnings is for method complexity is 16 for this method.
@SuppressWarnings("kotlin:S3776")
@Stable
@Composable
@Generated
internal fun AlphanumericKeyboard(modifier: Modifier, keyActionHandler: KeyActionHandler) {
    val uppercaseAlphabets = KeysDataSource.uppercaseAlphabets
    val numericKey = KeysDataSource.numericKey
    val rowList = remember {
        mutableStateOf(
            listOf(
                FIRST_ROW_ALPHANUMERIC_TEXT,
                SECOND_ROW_ALPHANUMERIC_TEXT,
                THIRD_ROW_ALPHANUMERIC_TEXT,
                FOUR_ROW_ALPHANUMERIC_TEXT
            )
        )
    }
    var firstIndexOfRow = 0
    var lastIndexOfRow = rowList.value[0]
    val keys: MutableList<Key>

    //this is change to true when user press 123 key for changing keys from alphabets to numeric with special character keys.
    val isNumeric = remember {
        mutableStateOf(false)
    }

    // when user press 123 for changing keys from alphabet to numeric then if block will execute.it will change keyboard's keys accordingly.
    if (isNumeric.value) {
        rowList.value = listOf(
            FIRST_ROW_ALPHANUMERIC_NUMBER,
            SECOND_ROW_ALPHANUMERIC_NUMBER,
            THIRD_ROW_ALPHANUMERIC_NUMBER,
            FOUR_ROW_ALPHANUMERIC_NUMBER
        )
        keys = numericKey
    } else {
        rowList.value = listOf(
            FIRST_ROW_ALPHANUMERIC_NUMBER,
            FIRST_ROW_ALPHANUMERIC_TEXT,
            SECOND_ROW_ALPHANUMERIC_TEXT,
            THIRD_ROW_ALPHANUMERIC_TEXT,
            FOUR_ROW_ALPHANUMERIC_TEXT
        )
        keys = uppercaseAlphabets
    }

    //this Box is most parent layout of keyboard
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = keyboard_background_color)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {},
        contentAlignment = Alignment.BottomEnd
    ) {
        //this column is holder for keyboard rows
        Column(
            modifier = Modifier
                .padding(
                    top = dimensionResource(dimen._6sdp),
                    start = default_padding_value,
                    end = default_padding_value
                )
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //this for loop create number of rows in keyboard based on row list value
            for (rowIndex in 0 until rowList.value.size) {
                //this if and else block keyboardRow method will be called based on row's arrangement
                KeyboardRow(
                    keys = keys.subList(firstIndexOfRow, lastIndexOfRow),
                    keyActionHandler = keyActionHandler,
                    isNumeric
                )

                if (rowIndex < rowList.value.size - 1) {
                    firstIndexOfRow = lastIndexOfRow
                    lastIndexOfRow += rowList.value[rowIndex + 1]
                }
            }
        }
    }
}

/**
 * KeyboardRow : This method create a keyboard's row
 * @param keys : pass list of keyboard keys that you want in one row
 * @param keyActionHandler : object of KeyActionHandler class
 * @param isNumeric : pass isNumeric mutable state of boolean for changing keyboard's key
 */

@Stable
@Composable
fun KeyboardRow(
    keys: List<Key>,
    keyActionHandler: KeyActionHandler,
    isNumeric: MutableState<Boolean>
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp),
        verticalAlignment = Alignment.Top
    ) {
        for (key in keys) {
            AlphabetKeyboardKey(
                keyboardKey = key,
                onClick = {
                    onButtonClick(
                        key = it,
                        keyActionHandler = keyActionHandler,
                        isNumeric = isNumeric,
                    )
                },
                modifier = Modifier.weight(1f),
                isNumeric.value
            )
        }
    }
}

/**
 * onButtonClick : This method will take action based on which key clicked in keyboard
 * @param key : pass pressed keyboard key
 * @param keyActionHandler : object of KeyActionHandler class
 * @param isNumeric : pass isNumeric mutable state of boolean for changing keyboard's key
 */
fun onButtonClick(key: Key, keyActionHandler: KeyActionHandler, isNumeric: MutableState<Boolean>) {
    when (key) {
        is TextUtilityKey.SPACE -> {
            keyActionHandler.onCommitText(" ")
        }

        is TextUtilityKey.Numeric -> {
            isNumeric.value = true
        }

        is TextUtilityKey.ABC -> {
            isNumeric.value = false
        }

        is UtilityKey.Backspace -> {
            keyActionHandler.onBackSpace()
        }

        else -> {
            keyActionHandler.onCommitText(key.text)
        }
    }
}