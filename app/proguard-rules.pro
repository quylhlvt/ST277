# Keep line information so Firebase Crashlytics can retrace release stack traces.
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Gson serializes these local models by their field names.
-keepclassmembers class com.warrior.oc.ca.data.model.custom.** {
    <fields>;
}
-keepclassmembers class com.warrior.oc.ca.data.model.api.** {
    <fields>;
}

# Preserve generic type information used by Gson TypeToken.
-keepattributes Signature
-keepattributes AnnotationDefault,RuntimeVisibleAnnotations
-keep class * extends com.google.gson.reflect.TypeToken

# Glide discovers the generated application module reflectively.
-keep public class * extends com.bumptech.glide.module.AppGlideModule
