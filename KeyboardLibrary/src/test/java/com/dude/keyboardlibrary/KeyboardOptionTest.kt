package com.dude.keyboardlibrary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.dude.keyboardlibrary.data.keyboardAction.KeyboardType
import com.dude.keyboardlibrary.ui.keyboard.KeyActionHandler
import com.dude.keyboardlibrary.ui.keyboard.KeyboardOption

class KeyboardOptionTest {

    @Test
    fun keyboardVisibleTestTrue(){
        KeyboardOption.keyboardVisible(true)
        assertEquals(KeyActionHandler.keyboardVisible.value,true)
    }
    @Test
    fun keyboardVisibleTestFalse(){
        KeyboardOption.keyboardVisible(false)
        assertEquals(KeyActionHandler.keyboardVisible.value,false)
    }

    @Test
    fun keyboardTypeTestTextCheck(){
        KeyboardOption.keyboardType(KeyboardType.Text)
        assertEquals(KeyActionHandler.keyboardType.value, com.dude.keyboardlibrary.data.KeyboardActionHelper.ALPHANUMERIC)
    }
    @Test
    fun keyboardTypeTestNumericCheck(){
        KeyboardOption.keyboardType(KeyboardType.Numeric)
        assertEquals(KeyActionHandler.keyboardType.value, com.dude.keyboardlibrary.data.KeyboardActionHelper.NUMERIC)
    }
}