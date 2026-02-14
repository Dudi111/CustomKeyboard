package com.dude.keyboardlibrary

import androidx.activity.ComponentActivity
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.text.input.TextFieldValue
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.dude.keyboardlibrary.ui.chatkeyboard.ChatKeyboard

@RunWith(AndroidJUnit4::class)
class ChatKeyboardTest {

    @Rule
    @JvmField
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun chatKeyboardViewTest() {
        val mockTextField = mutableStateOf(TextFieldValue(""))
        composeTestRule.setContent {
            ChatKeyboard(
                composeTestRule.activity,
                modifier = Modifier,
                mockTextField
            )
        }
    }
}