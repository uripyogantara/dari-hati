package id.futnet.darihati.model

import com.google.gson.annotations.SerializedName

data class NewsDetailItem(

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("news_id")
	val newsId: Int? = null
)