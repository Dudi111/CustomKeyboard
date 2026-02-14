package com.dude.keyboardlibrary.data

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.dude.keyboardlibrary.data.model.TextUtilityKey

class TextUtilityKeyTest {
    
    @Test
    fun numericObjectTest(){
        val str= KeysConstants.NUMERIC_KEY
        val result= TextUtilityKey.Numeric
        assertEquals(str,result.text)
    }
    
    @Test
    fun aBCObjectTest(){
        val str= KeysConstants.ABC_KEY
        val result= TextUtilityKey.ABC
        assertEquals(str,result.text)
    }
    
    @Test
    fun spaceObjectTest(){
        val str=KeysConstants.SPACE_KEY
        val result=TextUtilityKey.SPACE
        assertEquals(str,result.text)
    }
}