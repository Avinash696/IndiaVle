package com.example.panindia.model

data class stateCodeModel(var cityCode: String?, var cityName: String?, var countryCode: String?) {
    constructor() : this(null,null,null)
}