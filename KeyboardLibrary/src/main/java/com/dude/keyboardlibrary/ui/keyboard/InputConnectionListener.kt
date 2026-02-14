package com.dude.keyboardlibrary.ui.keyboard

interface InputConnectionListener {
    fun onCommitText(it: String)
    fun onBackSpace()
}