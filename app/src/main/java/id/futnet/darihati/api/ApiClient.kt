package id.futnet.darihati.api

import android.content.Context
import id.futnet.darihati.utils.PreferencesHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient{
    companion object {
        fun create(context: Context,baseUrl:String="https://darihati.uripyogantara.id/api/member/"): ApiService {
            val okHttpClient=OkHttpClient.Builder()
            val interceptor=HttpLoggingInterceptor()
            val preferencesHelper=PreferencesHelper(context)

            interceptor.level=HttpLoggingInterceptor.Level.BODY

            okHttpClient.addInterceptor(interceptor)
                    .addInterceptor({ chain->
                        val request=chain.request()
                                .newBuilder()
                                .addHeader("Content-Type","application/json")
                                .addHeader("Authorization","Bearer "+preferencesHelper.token)
                                .build()
                        chain.proceed(request)
                    })
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build())
                    .baseUrl(baseUrl)
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
