@file:Suppress("unused")

package br.com.gabriellferreira.baseclean.data.model

import java.io.Serializable

class MetaData(val url: String? = null,
               val format: String? = null,
               val height: Int? = null,
               val width: Int? = null) : Serializable

