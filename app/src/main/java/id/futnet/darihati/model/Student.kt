package id.futnet.darihati.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student(

	@SerializedName("dateofbirth")
	val dateofbirth: String? ,

	@SerializedName("community_id")
	val communityId: Int? = null,

	@SerializedName("updated_at")
	val updatedAt: String? = null,

	@SerializedName("foto")
	val foto: String? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("created_at")
	val createdAt: String? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("deskripsi")
	val deskripsi: String? = null,

	@SerializedName("alamat")
	val alamat: String? = null
):Parcelable