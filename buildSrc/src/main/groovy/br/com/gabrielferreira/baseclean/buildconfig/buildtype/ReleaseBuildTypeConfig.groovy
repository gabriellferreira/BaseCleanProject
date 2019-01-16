package br.com.gabrielferreira.baseclean.buildconfig.buildtype

final class ReleaseBuildTypeConfig extends BuildTypeConfig {

    @Override
    boolean isMinifyEnabled() {
        return true
    }

    @Override
    boolean isShrinkResourcesEnabled() {
        return true
    }

    @Override
    List<String> getProguardFiles() {
        def proguardFolder = "proguard"
        return ["$proguardFolder/proguard-android-support.pro",
                "$proguardFolder/proguard-crashlytics.pro",
                "$proguardFolder/proguard-gson.pro",
                "$proguardFolder/proguard-retrofit.pro",
                "$proguardFolder/proguard-rxjava.pro",
                "$proguardFolder/proguard-project.pro"]
    }
}