package com.dude.keyboardlibrary.data

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.dude.keyboardlibrary.R
import com.dude.keyboardlibrary.data.model.UtilityKey

class UtilityKeyTest {
    
    @Test
    fun backspaceTest() {
        val id = R.drawable.outline_backspace_24
        val result = UtilityKey.Backspace
        assertEquals(id, result.id)
    }

    @Test
    fun uppercaseLongTest() {
        val id = R.drawable.icon_shift_double_selected
        val result = UtilityKey.UppercaseLong
        assertEquals(id, result.id)
    }

    @Test
    fun upperCaseEnableTest() {
        val id = R.drawable.icon_shift_selected
        val result = UtilityKey.UppercaseEnable
        assertEquals(id, result.id)
    }

    @Test
    fun upperCaseDisableTest() {
        val id = R.drawable.icon_shift_not_selected
        val result = UtilityKey.UppercaseDisable
        assertEquals(id, result.id)
    }

    @Test
    fun upperCaseEnterTest() {
        val id = R.drawable.baseline_keyboard_return_24
        val result = UtilityKey.Enter
        assertEquals(id, result.id)
    }
}