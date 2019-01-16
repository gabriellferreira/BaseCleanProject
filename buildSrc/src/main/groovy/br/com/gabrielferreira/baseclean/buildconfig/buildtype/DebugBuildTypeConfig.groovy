package br.com.gabrielferreira.baseclean.buildconfig.buildtype

final class DebugBuildTypeConfig extends BuildTypeConfig {

    @Override
    boolean isMinifyEnabled() {
        return false
    }

    @Override
    boolean isShrinkResourcesEnabled() {
        return false
    }

    @Override
    List<String> getProguardFiles() {
        return []
    }
}