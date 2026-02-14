package com.dude.keyboardlibrary.ui.keyboard

import android.app.Activity
import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.dude.keyboardlibrary.data.Generated
import com.dude.keyboardlibrary.data.KeyboardActionHelper
import com.dude.keyboardlibrary.ui.keyboard.KeyActionHandler.Companion.keyboardType
import com.dude.keyboardlibrary.ui.keyboard.KeyActionHandler.Companion.keyboardVisible

/**
 * KeyboardView : This method will be called from app in which keyboard library will integrate
 * @param activity : pass activity
 * @param modifier : modifier for keyboard view
 */
@Composable
@Generated
fun KeyboardView(
    activity: Activity,
    modifier: Modifier = Modifier
) {
    val rememberedKeyboardType = remember {
        mutableStateOf("")
    }
    val rememberKeyboardVisibility = remember {
        mutableStateOf(false)
    }
    rememberedKeyboardType.value = keyboardType.value
    rememberKeyboardVisibility.value = keyboardVisible.value

    AnimatedVisibility(
        visible = rememberKeyboardVisibility.value,
        enter = EnterTransition.None,
        exit = ExitTransition.None
    ) {
        if (rememberedKeyboardType.value == KeyboardActionHelper.ALPHANUMERIC) {
            AlphanumericKeyboard(
                modifier, KeyActionHandler(activity)
            )
        } else {
            NumericKeyboardView(
                modifier, KeyActionHandler(activity)
            )
        }
    }

    if (!rememberKeyboardVisibility.value) {
        activity.currentFocus?.clearFocus()
    }
}