package com.dude.keyboardlibrary.data.model

internal sealed class SpecialCharactersKey(
    override val text: String
) : Key {
    data object Dot : SpecialCharactersKey(".")
    data object Dash : SpecialCharactersKey("-")
    data object And : SpecialCharactersKey("&")
    data object ParenthesesBracketsLeft : SpecialCharactersKey("(")
    data object ParenthesesBracketsRight : SpecialCharactersKey(")")
    data object BackSlash : SpecialCharactersKey("/")
    data object Quotes : SpecialCharactersKey("\"")
    data object SingleQuotes : SpecialCharactersKey("\'")
    data object Colon : SpecialCharactersKey(":")
    data object Semicolon : SpecialCharactersKey(";")
    data object Exclamation : SpecialCharactersKey("!")
    data object Question : SpecialCharactersKey("?")
    data object Ampersat : SpecialCharactersKey("@")
    data object Comma : SpecialCharactersKey(",")
    data object UnderScore : SpecialCharactersKey("_")
}