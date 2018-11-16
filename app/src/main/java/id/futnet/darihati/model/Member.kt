package id.futnet.darihati.model

import com.google.gson.annotations.SerializedName

data class Member(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("identity")
	val identity: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null
)