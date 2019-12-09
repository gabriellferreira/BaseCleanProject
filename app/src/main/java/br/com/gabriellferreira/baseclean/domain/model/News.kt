@file:Suppress("unused")

package br.com.gabriellferreira.baseclean.domain.model

class News(val url: String,
           val column: String,
           val section: String,
           val title: String,
           val abstract: String,
           val source: String,
           val publishedDate: String,
           val thumbnailUrl: String)