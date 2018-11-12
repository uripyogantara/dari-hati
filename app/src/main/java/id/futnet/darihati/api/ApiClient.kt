package id.futnet.darihati.api

import android.content.Context
import id.futnet.darihati.utils.PreferencesHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient{
    companion object {
        fun create(context: Context): ApiService {
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
                            RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build())
                    .baseUrl("http://192.168.137.1:8000/api/member/")
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
