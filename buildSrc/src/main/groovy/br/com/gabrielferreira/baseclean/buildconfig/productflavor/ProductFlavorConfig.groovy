package br.com.gabrielferreira.baseclean.buildconfig.productflavor

/**
 * All methods of this class should return null and cannot be abstract, because
 * of dimension conflicts
 */
abstract class ProductFlavorConfig {

    Boolean isFabricEnable() {
        return null
    }

    Integer getMinSdkVersion() {
        return null
    }

    String isOkHttpLogEnabled() {
        return null
    }

    String isEventLogEnabled() {
        return null
    }
}