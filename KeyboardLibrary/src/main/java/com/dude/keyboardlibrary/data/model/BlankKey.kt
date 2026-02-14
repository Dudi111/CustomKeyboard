package com.dude.keyboardlibrary.data.model

internal sealed class BlankKey(
    override val text: String,
) : Key {
    data object EmptyKey : BlankKey("")
}