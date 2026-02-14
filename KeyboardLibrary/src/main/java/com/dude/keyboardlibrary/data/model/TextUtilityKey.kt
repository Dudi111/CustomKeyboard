package com.dude.keyboardlibrary.data.model

import com.dude.keyboardlibrary.data.KeysConstants

internal sealed class TextUtilityKey(
    override val text: String
) : Key {
    data object Numeric : TextUtilityKey(KeysConstants.NUMERIC_KEY)
    data object ABC : TextUtilityKey(KeysConstants.ABC_KEY)
    data object SPACE : TextUtilityKey(KeysConstants.SPACE_KEY)
    data object EmptyTextUtilityKey : TextUtilityKey("")
}