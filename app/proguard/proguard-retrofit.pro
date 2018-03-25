-dontwarn retrofit.**
-keep class retrofit.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-dontnote retrofit2.Platform
-dontwarn retrofit2.Platform$Java8
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-keepattributes Signature
-keepattributes Exceptions

# Fixing build problems
-dontwarn retrofit2.**