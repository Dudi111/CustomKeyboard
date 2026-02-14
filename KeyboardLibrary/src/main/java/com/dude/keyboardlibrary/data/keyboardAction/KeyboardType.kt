package com.dude.keyboardlibrary.data.keyboardAction

import com.dude.keyboardlibrary.data.KeyboardActionHelper

//this class is used for handle keyboard types
sealed class KeyboardType(var keyboardType: String) {
    data object Text : KeyboardType(KeyboardActionHelper.ALPHANUMERIC)
    data object Numeric : KeyboardType(KeyboardActionHelper.NUMERIC)
}