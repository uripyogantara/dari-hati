package id.futnet.darihati.model

import com.google.gson.annotations.SerializedName

data class StudentDetail(

	@field:SerializedName("foto_rumah")
	val fotoRumah: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("student_id")
	val studentId: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)