package id.futnet.darihati.model

import com.google.gson.annotations.SerializedName

data class Student(

	@field:SerializedName("dateofbirth")
	val dateofbirth: String? = null,

	@field:SerializedName("community_id")
	val communityId: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null
)