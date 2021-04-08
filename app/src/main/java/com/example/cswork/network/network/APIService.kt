package com.sayali.network

import android.telecom.CallScreeningService
import com.example.cswork.ui.myActivity.DataClass.MyActivityData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query


interface APIServices {

    //get child subscribed packages
    @PUT("api/Users/UpdatePassword")
    fun changePassword(@Query("userId") subscriber_id: String?, @Query("password") password: String?): Response<ResponseBody?>

    @GET("api/Meeting/GetMeetingListById")
    suspend fun getMyActivity(@Query("userId") userId: Int?): Response<MyActivityData?>

////    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJOYW1lIjoiVGVzdCBVc2VyIiwiRW1haWwiOiJUZXN0QGdtYWlsLmNvbSIsIlVzZXJJZCI6IjEiLCJVc2VySWRlbnRpdHlLZXkiOiJUZXN0MTIzIiwiZXhwIjoxNjE4NjQ3MjI2LCJpc3MiOiJodHRwczovL2xvY2FsaG9zdDo0NDMwMC8iLCJhdWQiOiJodHRwczovL2xvY2FsaG9zdDo0NDMwMC8ifQ.p9eRs9tgZG9UITpdZHMMnYHr-Of0tzi77x4gnC8xVgc")
//    @GET("api/Meeting/GetMeetingListById")
//    fun getMyActivity(@Query("userId") userId: Int?):Call<MyActivityData?>?

}