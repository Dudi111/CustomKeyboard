package com.dude.keyboardlibrary

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.dude.keyboardlibrary.data.model.ButtonParams
import com.dude.keyboardlibrary.data.model.TextUtilityKey
import com.dude.keyboardlibrary.data.model.UppercaseAlphabets
import com.dude.keyboardlibrary.data.model.UtilityKey
import com.dude.keyboardlibrary.ui.chatkeyboard.ChatKeyboardKeyView
import com.dude.keyboardlibrary.ui.theme.action_key_background_color

@RunWith(AndroidJUnit4::class)
class ChatKeyboardKeyViewTest {
    @Rule
    @JvmField
    val composeTestRule = createComposeRule()

    private  var buttonParams = ButtonParams(
        onClick = {},
        enabled = true,
        height = 50.dp,
        width = 50.dp
    )
    @Test
    fun chatKeyboardKeyViewTestNormalKey() {
        composeTestRule.setContent {
            val colors = ButtonDefaults.buttonColors(
                containerColor = action_key_background_color, contentColor = Color.White
            )
            ChatKeyboardKeyView(
                UppercaseAlphabets.Z,
                10.sp,
                colors,
                24.dp,
                MaterialTheme.shapes.extraSmall,
                buttonParams
            )
        }
    }

    @Test
    fun chatKeyboardKeyKeyViewTestUpperCaseKey() {
        composeTestRule.setContent {
            val colors = ButtonDefaults.buttonColors(
                containerColor = action_key_background_color, contentColor = Color.White
            )
            ChatKeyboardKeyView(
                UtilityKey.UppercaseLong,
                10.sp,
                colors,
                24.dp,
                MaterialTheme.shapes.extraSmall,
                buttonParams
            )
        }
    }

    @Test
    fun chatKeyboardKeyViewTestBackspaceKey() {
        composeTestRule.setContent {
            val colors = ButtonDefaults.buttonColors(
                containerColor = action_key_background_color, contentColor = Color.White
            )
            ChatKeyboardKeyView(
                UtilityKey.Backspace,
                10.sp,
                colors,
                24.dp,
                MaterialTheme.shapes.extraSmall,
                buttonParams
            )
        }
    }

    @Test
    fun chatKeyboardKeyViewTestEnterKey() {
        composeTestRule.setContent {
            val colors = ButtonDefaults.buttonColors(
                containerColor = action_key_background_color, contentColor = Color.White
            )
            ChatKeyboardKeyView(
                TextUtilityKey.ABC,
                10.sp,
                colors,
                24.dp,
                MaterialTheme.shapes.extraSmall,
                buttonParams
            )
        }
    }

    @Test
    fun chatKeyboardKeyViewTestSpecialChar() {
        composeTestRule.setContent {
            val colors = ButtonDefaults.buttonColors(
                containerColor = action_key_background_color, contentColor = Color.White
            )
            ChatKeyboardKeyView(
                UppercaseAlphabets.A,
                10.sp,
                colors,
                24.dp,
                MaterialTheme.shapes.extraSmall,
                buttonParams
            )
        }
    }
}