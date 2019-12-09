@file:Suppress("unused")

package br.com.gabriellferreira.baseclean.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class NewsData(val id: String? = null,
               val url: String? = null,
               @SerializedName("count_type")
               val countType: String? = null,
               val column: String? = null,
               val section: String? = null,
               val byline: String? = null,
               val title: String? = null,
               val abstract: String? = null,
               val source: String? = null,
               @SerializedName("published_date")
               val publishedDate: String? = null,
               val media: List<MediaData>? = null) : Serializable