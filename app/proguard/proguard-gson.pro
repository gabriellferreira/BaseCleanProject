-keepattributes Signature
-keepattributes *Annotation*

-keepclassmembers class com.movile.learning.core.data.** { <fields>; }

-keep class com.movile.learning.core.data.** { <fields>; }

# This class is related to data, but actually it is used on domain and presentation logic too
-keep class com.movile.learning.core.domain.showcase.base.model.highlights.HighlightItem { <fields>; }