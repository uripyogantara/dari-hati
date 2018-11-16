package id.futnet.darihati.model

import com.google.gson.annotations.SerializedName

data class ResponseApi(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)