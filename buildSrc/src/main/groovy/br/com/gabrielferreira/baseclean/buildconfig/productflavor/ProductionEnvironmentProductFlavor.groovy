package br.com.gabrielferreira.baseclean.buildconfig.productflavor

class ProductionEnvironmentProductFlavor extends ProductFlavorConfig {

    @Override
    Boolean isFabricEnable() {
        return true
    }

    @Override
    String isOkHttpLogEnabled() {
        return false.toString()
    }

    @Override
    String isEventLogEnabled() {
        return false.toString()
    }
}