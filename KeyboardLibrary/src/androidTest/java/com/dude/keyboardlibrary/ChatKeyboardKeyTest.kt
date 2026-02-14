package com.dude.keyboardlibrary

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.dude.keyboardlibrary.data.model.SpecialCharactersKey
import com.dude.keyboardlibrary.data.model.TextUtilityKey
import com.dude.keyboardlibrary.data.model.UppercaseAlphabets
import com.dude.keyboardlibrary.data.model.UtilityKey
import com.dude.keyboardlibrary.ui.chatkeyboard.ChatKeyboardKey

@RunWith(AndroidJUnit4::class)
class ChatKeyboardKeyTest {
    @Rule
    @JvmField
    val composeTestRule = createComposeRule()
    
    @Test
    fun chatKeyboardKeyTest() {
       composeTestRule.setContent {
           ChatKeyboardKey(keyboardKey = UtilityKey.UppercaseLong, onClick = {}, modifier = Modifier, onLongPress = {})
       }
    }

    @Test
    fun chatKeyboardKeyTest1() {
        composeTestRule.setContent {
            ChatKeyboardKey(keyboardKey = UtilityKey.Enter, onClick = {}, modifier = Modifier, onLongPress = {})
        }
    }

    @Test
    fun chatKeyboardKeyTest2() {
        composeTestRule.setContent {
            ChatKeyboardKey(keyboardKey = UtilityKey.Backspace, onClick = {}, modifier = Modifier, onLongPress = {})
        }
    }

    @Test
    fun chatKeyboardKeyTest3() {
        composeTestRule.setContent {
            ChatKeyboardKey(keyboardKey = UppercaseAlphabets.Z, onClick = {}, modifier = Modifier, onLongPress = {})
        }
    }

    @Test
    fun chatKeyboardKeyTest4() {
        composeTestRule.setContent {
            ChatKeyboardKey(keyboardKey = TextUtilityKey.SPACE, onClick = {}, modifier = Modifier, onLongPress = {})
        }
    }

    @Test
    fun chatKeyboardKeyTest5() {
        composeTestRule.setContent {
            ChatKeyboardKey(keyboardKey = SpecialCharactersKey.UnderScore, onClick = {}, modifier = Modifier, onLongPress = {})
        }
    }

    @Test
    fun chatKeyboardKeyTest6() {
        composeTestRule.setContent {
            ChatKeyboardKey(keyboardKey = TextUtilityKey.ABC, onClick = {}, modifier = Modifier, onLongPress = {})
        }
    }

    @Test
    fun chatKeyboardKeyTestDashNumericKey() {
        composeTestRule.setContent {
            ChatKeyboardKey(
                keyboardKey = SpecialCharactersKey.Dash,
                onClick = {},
                modifier = Modifier,
                onLongPress = {}
            )
        }
    }

    @Test
    fun chatKeyboardKeyTestDotKey() {
        composeTestRule.setContent {
            ChatKeyboardKey(
                keyboardKey = SpecialCharactersKey.Dot,
                onClick = {},
                modifier = Modifier,
                onLongPress = {}
            )
        }
    }

    @Test
    fun chatKeyboardKeyTestCommaKey() {
        composeTestRule.setContent {
            ChatKeyboardKey(
                keyboardKey = SpecialCharactersKey.Comma,
                onClick = {},
                modifier = Modifier,
                onLongPress = {}
            )
        }
    }

    @Test
    fun chatKeyboardKeyTestQuestionKey() {
        composeTestRule.setContent {
            ChatKeyboardKey(
                keyboardKey = SpecialCharactersKey.Question,
                onClick = {},
                modifier = Modifier,
                onLongPress = {}
            )
        }
    }

    @Test
    fun chatKeyboardKeyTestExclamationKey() {
        composeTestRule.setContent {
            ChatKeyboardKey(
                keyboardKey = SpecialCharactersKey.Exclamation,
                onClick = {},
                modifier = Modifier,
                onLongPress = {}
            )
        }
    }

    @Test
    fun chatKeyboardKeyTestSingleQuoteKey() {
        composeTestRule.setContent {
            ChatKeyboardKey(
                keyboardKey = SpecialCharactersKey.SingleQuotes,
                onClick = {},
                modifier = Modifier,
                onLongPress = {}
            )
        }
    }
}