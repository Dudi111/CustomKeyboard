package com.dude.keyboardlibrary

import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.remember
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test
import com.dude.keyboardlibrary.data.model.ButtonParams
import com.dude.keyboardlibrary.ui.chatkeyboard.KeyButtonLongClick
import com.dude.keyboardlibrary.ui.theme.dimen_63dp

class KeyButtonLongClickTest {

    @Rule
    @JvmField
    val composeTestRule = createComposeRule()

    @Test
    fun keyButtonLongClickTest(){
        composeTestRule.setContent {
            val interactionSource = remember { MutableInteractionSource() }

            val modifier = androidx.compose.ui.Modifier
                .focusable(interactionSource = interactionSource)
                .padding(1.dp)
                .height(dimen_63dp)
                .width(130.dp)
                .semantics { this.contentDescription = "test"; this.testTag = "test" }

            val buttonParams = ButtonParams(
                modifier,
                {},
                onClick = { },
                contentPadding = PaddingValues(0.dp),
                enabled = true
            )
            KeyButtonLongClick(buttonParams = buttonParams, content = {})
        }
    }
}