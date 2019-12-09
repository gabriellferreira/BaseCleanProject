package br.com.gabriellferreira.baseclean.data.model

@Suppress("UNUSED_PARAMETER")
open class DataException(message: String = "", cause: Exception?) : Exception(cause)

class GenericException(message: String = "", cause: Exception? = null) : DataException(message, cause)

class NoDataException(message: String = "", cause: Exception? = null) : DataException(message, cause)

class InvalidDataConversionException(message: String = "", cause: Exception? = null) : DataException(message, cause)
