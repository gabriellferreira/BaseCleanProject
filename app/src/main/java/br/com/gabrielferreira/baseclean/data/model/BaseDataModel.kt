package br.com.gabrielferreira.baseclean.data.model

import com.google.gson.annotations.SerializedName

open class BaseDataModel constructor(val status: String? = null,
                                     val copyright: String? = null,
                                     @SerializedName("num_results")
                                     val num_results: Long? = null)