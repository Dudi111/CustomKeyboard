package com.dude.keyboardlibrary.ui.keyboard

import android.app.Activity
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import com.dude.keyboardlibrary.data.Generated

@Immutable
//this class is taking action based on key press
class KeyActionHandler(private var activity: Activity) : InputConnectionListener {
    companion object {
        var keyboardVisible = mutableStateOf(false)
        var keyboardType = mutableStateOf("")
        var chatKeyboardVisible = mutableStateOf(true)
    }

    private var inputConnection: InputConnection? = null

    /**
     * onCommitText: This method will write text in focus area
     * @param it: pass text that needs to write on text field
     */
    @Generated //Not able to cover all condition
    override fun onCommitText(it: String) {
        inputConnection = activity.window.currentFocus?.onCreateInputConnection(EditorInfo())
        inputConnection?.commitText(it, it.length)
    }

    /**
     * onBackSpace: This method will remove text from text field
     */
    @Generated //Not able to cover all condition
    override fun onBackSpace() {
        inputConnection = activity.window.currentFocus?.onCreateInputConnection(EditorInfo())
        inputConnection?.deleteSurroundingText(1, 0)
    }
}