package id.futnet.darihati.model

import com.google.gson.annotations.SerializedName

data class News(

	@field:SerializedName("community_id")
	val communityId: Int? = null,


	@SerializedName("community_name")
	val communityName: String? = null,

	@field:SerializedName("news_detail")
	val newsDetail: List<NewsDetailItem?>? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("content")
	val content: String? = null
)