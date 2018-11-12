package id.futnet.darihati.model

import com.google.gson.annotations.SerializedName

data class Event(

	@field:SerializedName("start_event")
	val startEvent: String? = null,

	@field:SerializedName("student_name")
	val studentName: String? = null,

	@field:SerializedName("community_id")
	val communityId: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("end_event")
	val endEvent: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("student_id")
	val studentId: Int? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null
)