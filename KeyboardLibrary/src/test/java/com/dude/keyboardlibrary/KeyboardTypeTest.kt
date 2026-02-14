package com.dude.keyboardlibrary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.dude.keyboardlibrary.data.keyboardAction.KeyboardType

class KeyboardTypeTest {
    
    @Test
    fun testTextClass() {
        val str = com.dude.keyboardlibrary.data.KeyboardActionHelper.ALPHANUMERIC
        val result = KeyboardType.Text
        assertEquals(str, result.keyboardType)
    }

    @Test
    fun testNumericClass() {
        val str = com.dude.keyboardlibrary.data.KeyboardActionHelper.NUMERIC
        val result = KeyboardType.Numeric
        assertEquals(str, result.keyboardType)
    }
}