package com.dude.keyboardlibrary

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dude.keyboardlibrary.data.KeyboardActionHelper
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.dude.keyboardlibrary.ui.keyboard.KeyActionHandler
import com.dude.keyboardlibrary.ui.keyboard.KeyboardView

@RunWith(AndroidJUnit4::class)
class KeyboardViewTest {

    @Rule
    @JvmField
    val composeTestRule = createAndroidComposeRule<androidx.activity.ComponentActivity>()

    @Test
    fun keyboardViewTestNumericVisible(){
        composeTestRule.setContent {
            KeyActionHandler.keyboardVisible.value=true
            KeyActionHandler.keyboardType.value= KeyboardActionHelper.NUMERIC
            KeyboardView(composeTestRule.activity)
        }
    }

    @Test
    fun keyboardViewTestTextVisible(){
        composeTestRule.setContent {
            KeyActionHandler.keyboardVisible.value=true
            KeyActionHandler.keyboardType.value= KeyboardActionHelper.ALPHANUMERIC
            KeyboardView(composeTestRule.activity)
        }
    }
}