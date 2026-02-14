package com.dude.keyboardlibrary

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import com.dude.keyboardlibrary.data.KeysDataSource.constructNumericKeyboardKeys
import com.dude.keyboardlibrary.data.KeysDataSource.constructChatKeyboardKeys
import com.dude.keyboardlibrary.data.KeysDataSource.constructChatKeyboardNumericKeys
import com.dude.keyboardlibrary.data.KeysDataSource.constructChatKeyboardUpperCaseKeys
import com.dude.keyboardlibrary.data.KeysDataSource.constructNumericKeys
import com.dude.keyboardlibrary.data.KeysDataSource.constructUpperCaseKeys

class KeyDataSourceTest {

    @Test
    fun numericKeyTest(){
        val keyList= constructNumericKeys()
        assertArrayEquals(keyList.toTypedArray(), com.dude.keyboardlibrary.data.KeysDataSource.numericKey.toTypedArray())
    }

    @Test
    fun uppercaseAlphabetsTest(){
        val keyList=constructUpperCaseKeys()
        assertArrayEquals(keyList.toTypedArray(), com.dude.keyboardlibrary.data.KeysDataSource.uppercaseAlphabets.toTypedArray())
    }

    @Test
    fun numericKeyboardKeyTest() {
        val keyList = constructNumericKeyboardKeys()
        assertArrayEquals(
            keyList.toTypedArray(),
            com.dude.keyboardlibrary.data.KeysDataSource.numericKeyboardKey.toTypedArray()
        )
    }

    @Test
    fun chatKeyboardNormalKeyTest() {
        val keyList = constructChatKeyboardKeys()
        assertArrayEquals(
            keyList.toTypedArray(),
            com.dude.keyboardlibrary.data.KeysDataSource.chatKeyboardNormalKey.toTypedArray()
        )
    }

    @Test
    fun chatKeyboardUpperCaseKeyTest() {
        val keyList = constructChatKeyboardUpperCaseKeys()
        assertArrayEquals(
            keyList.toTypedArray(),
            com.dude.keyboardlibrary.data.KeysDataSource.chatKeyboardUpperCaseKey.toTypedArray()
        )
    }

    @Test
    fun chatKeyboardNumericKeyTest() {
        val keyList = constructChatKeyboardNumericKeys()
        assertArrayEquals(
            keyList.toTypedArray(),
            com.dude.keyboardlibrary.data.KeysDataSource.chatKeyboardNumericKey.toTypedArray()
        )
    }
}