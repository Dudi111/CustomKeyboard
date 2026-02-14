-keepattributes *Annotation*, Signature

-keep class com.dude.keyboardlibrary.* {
    public <methods>;
    protected <methods>;
    public static <methods>;
    public <init>(...);
}
-keep class com.dude.keyboardlibrary.ui.keyboard.FKeyboardViewKt

-keepclassmembers class com.dude.keyboardlibrary.ui.keyboard.KeyboardOption{
 <methods>;
  <fields>;
}
-keepclassmembers class com.dude.keyboardlibrary.data.keyboardAction.KeyboardType{
 <methods>;
  <fields>;
}