package id.futnet.darihati.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Payment(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("funding_id")
	val fundingId: Int? = null,

	@field:SerializedName("month")
	val month: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null
):Parcelable