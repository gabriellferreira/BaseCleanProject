@file:Suppress("unused")

package br.com.gabriellferreira.baseclean.data.model

import com.google.gson.annotations.SerializedName

class NYTimesResultData(val results: List<NewsData>? = null,
                        val status: String? = null,
                        val copyright: String? = null,
                        @SerializedName("num_results")
                        val numResults: Int? = null)