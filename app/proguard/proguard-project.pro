# preventing build problems
-keep class com.google.android.gms.iid.zzd { *; }
-keep class android.support.v4.content.ContextCompat { *; }

### DATA MODELS ###
-keep class  br.com.gabriellferreira.baseclean.data.model.** { *; }

### DOMAIN MODELS ###
-keep class  br.com.gabriellferreira.baseclean.domain.model.** { *; }

### PRESENTATION MODELS ###
-keep class  br.com.gabriellferreira.baseclean.presentation.view.model.** { *; }

### ENUMS ###
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
