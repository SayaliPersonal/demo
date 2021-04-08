package com.example.cswork.network.keabis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cswork.network.EndPoints
import com.example.cswork.network.auth.AuthResponse
import okhttp3.OkHttpClient
import okhttp3.internal.http2.Http2Connection
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MeetingRoomRepository {

    private val AUTH_BASE_URL = "https://identity.officernd.com/"
    private var endPoints: EndPoints? = null
    private var authResponseMutableLiveData: MutableLiveData<AuthResponse?>? = null


    fun MeetingRoomRepository() {
        authResponseMutableLiveData = MutableLiveData()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        val client: OkHttpClient = Http2Connection.Builder().addInterceptor(interceptor).build()
        endPoints = Retrofit.Builder()
            .baseUrl(AUTH_BASE_URL)
//            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EndPoints::class.java)
    }

    fun authenticateAPI(
        clientId: String?, clientSecret: String?, grantType: String?,
        scope: String?
    ) {
        endPoints!!.authenticate(clientId, clientSecret, grantType, scope)
            .enqueue(object : Callback<AuthResponse?> {
                override fun onResponse(
                    call: Call<AuthResponse?>,
                    response: Response<AuthResponse?>
                ) {
                    if (response.body() != null) {
                        authResponseMutableLiveData!!.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<AuthResponse?>, t: Throwable) {
                    authResponseMutableLiveData!!.postValue(null)
                }
            })
    }

    fun getAuthenticateAPILivaData(): LiveData<AuthResponse?>? {
        return authResponseMutableLiveData
    }
}