package com.dude.keyboardlibrary

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.dude.keyboardlibrary.data.model.*
import com.dude.keyboardlibrary.ui.keyboard.AlphabetKeyboardKey

@RunWith(AndroidJUnit4::class)
class KeyboardKeyAlphabetTest {

    @Rule
    @JvmField
    val composeTestRule = createComposeRule()

    @Test
    fun keyboardKeyAlphabetTestNormalKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = UppercaseAlphabets.A,
                onClick = {},
                modifier = Modifier,
                false
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestNormalKeyZ() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = UppercaseAlphabets.Z,
                onClick = {},
                modifier = Modifier,
                false
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestSpaceTextKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = TextUtilityKey.SPACE,
                onClick = {},
                modifier = Modifier,
                false
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestSpaceNumericKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = TextUtilityKey.SPACE,
                onClick = {},
                modifier = Modifier,
                true
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestABCKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = TextUtilityKey.ABC,
                onClick = {},
                modifier = Modifier,
                false
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestUtilityKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = UtilityKey.Backspace,
                onClick = {},
                modifier = Modifier,
                true
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestUppercaseKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = UtilityKey.UppercaseLong,
                onClick = {},
                modifier = Modifier,
                false
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestBlankKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = BlankKey.EmptyKey,
                onClick = {},
                modifier = Modifier,
                true
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestDashTextKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = SpecialCharactersKey.Dash,
                onClick = {},
                modifier = Modifier,
                false
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestDashNumericKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = SpecialCharactersKey.Dash,
                onClick = {},
                modifier = Modifier,
                true
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestDotKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = SpecialCharactersKey.Dot,
                onClick = {},
                modifier = Modifier,
                true
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestCommaKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = SpecialCharactersKey.Comma,
                onClick = {},
                modifier = Modifier,
                true
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestQuestionKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = SpecialCharactersKey.Question,
                onClick = {},
                modifier = Modifier,
                true
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestExclamationKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = SpecialCharactersKey.Exclamation,
                onClick = {},
                modifier = Modifier,
                true
            )
        }
    }

    @Test
    fun keyboardKeyAlphabetTestSingleQuoteKey() {
        composeTestRule.setContent {
            AlphabetKeyboardKey(
                keyboardKey = SpecialCharactersKey.SingleQuotes,
                onClick = {},
                modifier = Modifier,
                true
            )
        }
    }
}