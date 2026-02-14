package com.dude.keyboardlibrary.data

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import com.dude.keyboardlibrary.data.model.BlankKey

class BlankKeyTest {

    @Test
    fun emptyKeyTest() {
        val result = BlankKey.EmptyKey
        Assertions.assertEquals("", result.text)
    }
}