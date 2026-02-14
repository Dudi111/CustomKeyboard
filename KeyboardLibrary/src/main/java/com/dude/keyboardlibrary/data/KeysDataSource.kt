package com.dude.keyboardlibrary.data

import com.dude.keyboardlibrary.data.model.*
import com.dude.keyboardlibrary.data.model.SpecialCharactersKey.*

internal object KeysDataSource {

    val uppercaseAlphabets: MutableList<Key> =
        constructUpperCaseKeys()
    val numericKey: MutableList<Key> =
        constructNumericKeys()
    val numericKeyboardKey: MutableList<Key> =
        constructNumericKeyboardKeys()
    val chatKeyboardNormalKey: MutableList<Key> = constructChatKeyboardKeys()
    val chatKeyboardUpperCaseKey: MutableList<Key> = constructChatKeyboardUpperCaseKeys()
    val chatKeyboardNumericKey: MutableList<Key> = constructChatKeyboardNumericKeys()

    /**
     * constructNumericKeys : This method will prepare list of numeric key for alphanumeric keyboard
     */
    fun constructNumericKeys() = mutableListOf<Key>().apply {
        add(Digit.One)
        add(Digit.Two)
        add(Digit.Three)
        add(Digit.Four)
        add(Digit.Five)
        add(Digit.Six)
        add(Digit.Seven)
        add(Digit.Eight)
        add(Digit.Nine)
        add(Digit.Zero)
        add(Dash)
        add(BackSlash)
        add(Colon)
        add(Semicolon)
        add(ParenthesesBracketsLeft)
        add(ParenthesesBracketsRight)
        add(And)
        add(Ampersat)
        add(Quotes)
        add(BlankKey.EmptyKey)
        add(Dot)
        add(Comma)
        add(Question)
        add(Exclamation)
        add(SingleQuotes)
        add(UtilityKey.Backspace)
        add(TextUtilityKey.ABC)
        add(TextUtilityKey.SPACE)
        add(TextUtilityKey.EmptyTextUtilityKey)
    }

    /**
     * constructChatKeyboardNumericKeys: This method will prepare list of numeric keys for chat keyboard
     */
    fun constructChatKeyboardNumericKeys() = mutableListOf<Key>().apply {
        add(Digit.One)
        add(Digit.Two)
        add(Digit.Three)
        add(Digit.Four)
        add(Digit.Five)
        add(Digit.Six)
        add(Digit.Seven)
        add(Digit.Eight)
        add(Digit.Nine)
        add(Digit.Zero)
        add(Dash)
        add(BackSlash)
        add(Colon)
        add(Semicolon)
        add(ParenthesesBracketsLeft)
        add(ParenthesesBracketsRight)
        add(And)
        add(Ampersat)
        add(Quotes)
        add(UnderScore)
        add(Dot)
        add(Comma)
        add(Question)
        add(Exclamation)
        add(SingleQuotes)
        add(UtilityKey.Backspace)
        add(TextUtilityKey.ABC)
        add(TextUtilityKey.SPACE)
        add(UtilityKey.Enter)
    }

    /**
     * constructNumericKeyboardKeys : This method will prepare list of keys for numeric keyboard
     */
    fun constructNumericKeyboardKeys() = mutableListOf<Key>().apply {
        add(Digit.One)
        add(Digit.Two)
        add(Digit.Three)
        add(Digit.Four)
        add(Digit.Five)
        add(Digit.Six)
        add(Digit.Seven)
        add(Digit.Eight)
        add(Digit.Nine)
        add(BlankKey.EmptyKey)
        add(Digit.Zero)
        add(UtilityKey.Backspace)
    }

    /**
     * constructUpperCaseKeys: This method will prepare list of uppercase keys for alphanumeric keyboard
     */
    fun constructUpperCaseKeys() = mutableListOf<Key>().apply {
        add(Digit.One)
        add(Digit.Two)
        add(Digit.Three)
        add(Digit.Four)
        add(Digit.Five)
        add(Digit.Six)
        add(Digit.Seven)
        add(Digit.Eight)
        add(Digit.Nine)
        add(Digit.Zero)
        add(UppercaseAlphabets.Q)
        add(UppercaseAlphabets.W)
        add(UppercaseAlphabets.E)
        add(UppercaseAlphabets.R)
        add(UppercaseAlphabets.T)
        add(UppercaseAlphabets.Y)
        add(UppercaseAlphabets.U)
        add(UppercaseAlphabets.I)
        add(UppercaseAlphabets.O)
        add(UppercaseAlphabets.P)
        add(UppercaseAlphabets.A)
        add(UppercaseAlphabets.S)
        add(UppercaseAlphabets.D)
        add(UppercaseAlphabets.F)
        add(UppercaseAlphabets.G)
        add(UppercaseAlphabets.H)
        add(UppercaseAlphabets.J)
        add(UppercaseAlphabets.K)
        add(UppercaseAlphabets.L)
        add(UtilityKey.UppercaseLong)
        add(UppercaseAlphabets.Z)
        add(UppercaseAlphabets.X)
        add(UppercaseAlphabets.C)
        add(UppercaseAlphabets.V)
        add(UppercaseAlphabets.B)
        add(UppercaseAlphabets.N)
        add(UppercaseAlphabets.M)
        add(UtilityKey.Backspace)
        add(TextUtilityKey.Numeric)
        add(TextUtilityKey.SPACE)
        add(Dash)
    }

    /**
     * constructChatKeyboardKeys: This method will prepare list of alphabets lowercase key for chat keyboard
     */
    fun constructChatKeyboardKeys() = mutableListOf<Key>().apply {
        add(Alphabets.Q)
        add(Alphabets.W)
        add(Alphabets.E)
        add(Alphabets.R)
        add(Alphabets.T)
        add(Alphabets.Y)
        add(Alphabets.U)
        add(Alphabets.I)
        add(Alphabets.O)
        add(Alphabets.P)
        add(Alphabets.A)
        add(Alphabets.S)
        add(Alphabets.D)
        add(Alphabets.F)
        add(Alphabets.G)
        add(Alphabets.H)
        add(Alphabets.J)
        add(Alphabets.K)
        add(Alphabets.L)
        add(UtilityKey.UppercaseDisable)
        add(Alphabets.Z)
        add(Alphabets.X)
        add(Alphabets.C)
        add(Alphabets.V)
        add(Alphabets.B)
        add(Alphabets.N)
        add(Alphabets.M)
        add(UtilityKey.Backspace)
        add(TextUtilityKey.Numeric)
        add(TextUtilityKey.SPACE)
        add(UtilityKey.Enter)
    }

    /**
     * constructChatKeyboardUpperCaseKeys: This method will prepare list of uppercase alphabets for chat keyboard
     */
    fun constructChatKeyboardUpperCaseKeys() = mutableListOf<Key>().apply {
        add(UppercaseAlphabets.Q)
        add(UppercaseAlphabets.W)
        add(UppercaseAlphabets.E)
        add(UppercaseAlphabets.R)
        add(UppercaseAlphabets.T)
        add(UppercaseAlphabets.Y)
        add(UppercaseAlphabets.U)
        add(UppercaseAlphabets.I)
        add(UppercaseAlphabets.O)
        add(UppercaseAlphabets.P)
        add(UppercaseAlphabets.A)
        add(UppercaseAlphabets.S)
        add(UppercaseAlphabets.D)
        add(UppercaseAlphabets.F)
        add(UppercaseAlphabets.G)
        add(UppercaseAlphabets.H)
        add(UppercaseAlphabets.J)
        add(UppercaseAlphabets.K)
        add(UppercaseAlphabets.L)
        add(UtilityKey.UppercaseEnable)
        add(UppercaseAlphabets.Z)
        add(UppercaseAlphabets.X)
        add(UppercaseAlphabets.C)
        add(UppercaseAlphabets.V)
        add(UppercaseAlphabets.B)
        add(UppercaseAlphabets.N)
        add(UppercaseAlphabets.M)
        add(UtilityKey.Backspace)
        add(TextUtilityKey.Numeric)
        add(TextUtilityKey.SPACE)
        add(UtilityKey.Enter)
    }
}