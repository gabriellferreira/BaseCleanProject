package br.com.gabriellferreira.baseclean.data.model

import com.google.gson.annotations.SerializedName

class MediaData(val type: String? = null,
                val subtype: String? = null,
                val caption: String? = null,
                val copyright: String? = null,
                @SerializedName("media-metadata")
                val metadataList: List<MetaData>? = null)

