@file:Suppress("unused")
package br.com.gabrielferreira.baseclean.data.model

import com.google.gson.annotations.SerializedName

class NewsData(val url: String ?= null,
               @SerializedName("count_type")
               val countType: String? = null,
               val column: String? = null,
               val section: String? = null,
               val byline: String? = null,
               val title: String? = null,
               val source: String? = null,
               @SerializedName("abstract")
               val abs: String?=null,
               @SerializedName("published_date")
               val publishedDate: String ?=null,
               @SerializedName("media")
               val mediaList: Any ?= null) : BaseDataModel()