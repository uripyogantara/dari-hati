package id.futnet.darihati.api

import id.futnet.darihati.model.*
import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email:String,@Field("password") password:String): Observable<User>

    @FormUrlEncoded
    @POST("register")
    fun register(@Field("name") name:String,
                 @Field("email") email:String,
                 @Field("phone") phone:String,
                 @Field("alamat") alamat:String,
                 @Field("identity") identity:String,
                 @Field("password") password:String
                 ): Observable<User>

    @GET("student")
    fun allStudent():Observable<MutableList<Student>>

    @GET("student/{id}")
    fun studentDetail(@Path("id") id:Int?):Observable<MutableList<StudentDetail>>

    @GET("event")
    fun allEvent():Observable<List<Event>>

    @GET("community")
    fun allCommunity():Observable<MutableList<Community>>

    @GET("community/{id}/news")
    fun newsCommunity(@Path("id") id: Int?):Observable<MutableList<News>>

    @GET("funding")
    fun allFunding():Observable<MutableList<Funding>>

    @GET("funding/{id}/member")
    fun fundingMember(@Path("id") id: Int?):Observable<MutableList<Member>>

    @GET("community/limit")
    fun limitCommunity():Observable<MutableList<Community>>

    @GET("funding/limit")
    fun limitFunding():Observable<MutableList<Funding>>

    @GET("news")
    fun allNews():Observable<MutableList<News>>

    @FormUrlEncoded
    @POST("funding/join")
    fun joinFunding(@Field("funding_id") fundingId:String):Observable<ResponseApi>

    @FormUrlEncoded
    @POST("community/join")
    fun joinCommunity(@Field("community_id") communityId:String):Observable<ResponseApi>
}