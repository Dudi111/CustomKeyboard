# 📱 Compose Keyboard Library

A fully customizable **Jetpack Compose Keyboard Library** that provides multiple keyboard types without relying on the Android system keyboard (IME).

Built entirely with Jetpack Compose.

---

## ✨ Features

- 🔤 Alphanumeric Keyboard (Caps Only)
- 🔣 Symbol Layout Support (Special Characters)
- 💬 Chat Keyboard (Lowercase + Enter Support)
- 🔢 Numeric Keyboard
- 🚫 No Android system keyboard dependency
- ⚡ Lightweight & modular
- 🎯 Easy integration
- 🧩 Fully Compose-based

---

## 📋 Requirements

- **Minimum SDK: 33**
- Jetpack Compose
- Activity reference required

---

# 📦 Installation

Add dependency in your app-level `build.gradle(.kts)`:

```kotlin
dependencies {
    api("dude.keyboard:keyboardLibrary:1.0.0")
}
```

Sync your project.

---

# ⌨️ Available Keyboard Types

---

## 1️⃣ Alphanumeric Keyboard

Includes:

- Uppercase letters (A–Z)
- Number row (0–9)
- Shift key
- Backspace key
- Space key
- Symbol layout toggle

### 🔣 Symbol Layout

Alphanumeric keyboard also supports special characters:

```
-  /  :  ;  (  )  &  @  "
_  .  ,  ?  !  '
```

Users can switch between:
- Alphabet layout
- Symbol layout

---

## 2️⃣ Chat Keyboard

Includes:

- Lowercase letters (a–z)
- Space key
- Enter key
- Backspace key
- Symbol layout support
- Toggle to ABC layout

Best suited for:
- Messaging apps
- Comment input
- Chat interfaces

---

## 3️⃣ Numeric Keyboard

Includes:

- Digits (0–9)
- Backspace key

Best suited for:
- OTP input
- PIN entry
- Numeric-only forms

---

# 🚀 Usage Guide

---

# 🔤 1. Using Alphanumeric & Numeric Keyboard

---

## Step 1: Add `KeyboardView` to Your Screen

```kotlin
/**
 * KeyboardView : This method will be called from app in which keyboard library will integrate
 * @param activity : pass current activity
 * @param modifier : modifier for keyboard view
 */
KeyboardView(
    activity = activity,
    modifier = Modifier
)
```

### Recommended Layout Placement

```kotlin
Box(modifier = Modifier.fillMaxSize()) {

    // Your Screen Content

    KeyboardView(
        activity = activity,
        modifier = Modifier.align(Alignment.BottomCenter)
    )
}
```

---

## Step 2: Show Keyboard on TextField Focus

```kotlin
TextField(
    value = number.value,
    onValueChange = {
        number.value = it
    },
    readOnly = true, // Prevent system keyboard
    modifier = Modifier.onFocusChanged {
        if (it.isFocused) {
            KeyboardOption.apply {
                keyboardType(KeyboardType.Numeric)   // Numeric keyboard
                keyboardVisible(true)                // Show keyboard
            }
        }
    }
)
```

---

## Available Keyboard Types

```kotlin
KeyboardType.Numeric   // Numeric Keyboard
KeyboardType.Text      // Alphanumeric Keyboard
```

---

# 💬 2. Using Chat Keyboard

---

## Step 1: Add ChatKeyboard

```kotlin
/**
 * @param activity : pass current activity
 * @param modifier : modifier for keyboard view
 * @param textFieldValue : pass textfield state
 */

val mActivity = LocalContext.current
val textField = remember { mutableStateOf(TextFieldValue()) }

ChatKeyboard(
    activity = mActivity,
    modifier = Modifier,
    textFieldValue = textField
)
```

---

## Step 2: Show / Hide Chat Keyboard

```kotlin
KeyActionHandler.chatKeyboardVisible.value = true   // Show
KeyActionHandler.chatKeyboardVisible.value = false  // Hide
```

---

# ⚠️ Important

To prevent Android system keyboard from appearing:

```kotlin
val keyboardController = LocalSoftwareKeyboardController.current
val focusRequester = remember { FocusRequester() }

TextField(
    value = text,
    onValueChange = { text = it },
    modifier = Modifier
        .focusRequester(focusRequester)
        .onFocusChanged {
            if (it.isFocused) {
                focusRequester.requestFocus()
                keyboardController?.hide() // Hide system keyboard
            } 
        }
)
```

# 📄 Version

Current Version: `1.0.0`

---