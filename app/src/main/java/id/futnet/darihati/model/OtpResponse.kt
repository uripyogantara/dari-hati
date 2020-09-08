package id.futnet.darihati.model

import com.google.gson.annotations.SerializedName

data class OtpResponse(

	@field:SerializedName("code")
	val code: Int? = null
)