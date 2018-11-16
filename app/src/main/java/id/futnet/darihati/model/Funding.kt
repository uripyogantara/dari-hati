package id.futnet.darihati.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Funding(

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("community_cp")
	val communityCp: String? = null,

	@field:SerializedName("community_name")
	val communityName: String? = null,

	@field:SerializedName("max_member")
	val maxMember: String? = null,

	@field:SerializedName("student_id")
	val studentId: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("isJoin")
	val isJoin: Boolean? = null,

	@field:SerializedName("student_name")
	val studentName: String? = null,

	@field:SerializedName("community_id")
	val communityId: Int? = null,

	@field:SerializedName("student_foto")
	val studentFoto: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("jumlah")
	val jumlah: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("iuran_bulanan")
	val iuranBulanan: String? = null,

	@field:SerializedName("start_date")
	val startDate: String? = null
):Parcelable