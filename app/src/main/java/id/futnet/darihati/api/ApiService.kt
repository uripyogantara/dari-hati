package id.futnet.darihati.api

import id.futnet.darihati.model.Student
import id.futnet.darihati.model.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import rx.Observable

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email:String,@Field("password") password:String):Observable<User>

    @GET("student")
    fun allStudent():Observable<List<Student>>
}