package id.futnet.darihati.api

import id.futnet.darihati.model.*
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email:String,@Field("password") password:String): Observable<User>

    @GET("student")
    fun allStudent():Observable<MutableList<Student>>

    @GET("event")
    fun allEvent():Observable<List<Event>>

    @GET("community")
    fun allCommunity():Observable<MutableList<Community>>

    @GET("funding")
    fun allFunding():Observable<MutableList<Funding>>

    @GET("community/limit")
    fun limitCommunity():Observable<MutableList<Community>>

    @GET("funding/limit")
    fun limitFunding():Observable<MutableList<Funding>>
}