package com.dude.keyboardlibrary.ui.keyboard

import com.dude.keyboardlibrary.data.KeyboardActionHelper
import com.dude.keyboardlibrary.data.keyboardAction.KeyboardType

object KeyboardOption {

    /**
     * keyboardVisible : This method is used to show and hide keyboard
     * @param visible : Pass true if show else pass false
     */
    fun keyboardVisible(visible: Boolean) {
        KeyActionHandler.keyboardVisible.value = visible
    }

    /**
     * keyboardType : This method is used to set keyboard type
     * @param keyboardType : Pass object of KeyboardType
     */
    fun keyboardType(keyboardType: KeyboardType) {
        if (keyboardType is KeyboardType.Text) {
            KeyActionHandler.keyboardType.value = KeyboardActionHelper.ALPHANUMERIC
        } else {
            KeyActionHandler.keyboardType.value = KeyboardActionHelper.NUMERIC
        }
    }
}
