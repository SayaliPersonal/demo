//package com.example.cswork.network.creditPoints
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.example.cswork.network.EndPoints
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//abstract class CreditPointsRepository {
//    abstract val endPoints: EndPoints
//    private val creditPointsResponseMutableLiveData: MutableLiveData<CreditPointsResponse?> =
//        MutableLiveData()
//
//    fun creditPoints(team: String?, month: String?) {
//        endPoints.creditPoints(team, month)
//            .enqueue(object : Callback<CreditPointsResponse?> {
//                override fun onResponse(
//                    call: Call<CreditPointsResponse?>,
//                    response: Response<CreditPointsResponse?>
//                ) {
//                    if (response.body() != null) {
//                        creditPointsResponseMutableLiveData.postValue(response.body())
//                    }
//                }
//
//                override fun onFailure(call: Call<CreditPointsResponse?>, t: Throwable) {
//                    creditPointsResponseMutableLiveData.postValue(null)
//                }
//            })
//    }
//
//    val authenticateAPILivaData: LiveData<CreditPointsResponse?>
//        get() = creditPointsResponseMutableLiveData
//
//    companion object {
//        private const val AUTH_BASE_URL = "https://identity.officernd.com/"
//    }
//
//    init {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
////        val client: OkHttpClient = Builder().addInterceptor(interceptor).build()
////        endPoints = Retrofit.Builder()
////            .baseUrl(AUTH_BASE_URL)
////            .client(client)
////            .addConverterFactory(GsonConverterFactory.create())
////            .build()
////            .create(EndPoints::class.java)
//    }
//}