package com.sayali.network

import android.telecom.CallScreeningService
import com.example.cswork.ui.quickLinks.contactUs.ContactUS
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query


interface APIService {

    //get child subscribed packages
    @PUT("api/Users/UpdatePassword")
    fun changePassword(@Query("userId") subscriber_id: String?, @Query("password") password: String?): Response<ResponseBody?>

    @GET("api/Contact")
    fun getHeroes():Call<ContactUS?>?

    @GET("api/Contact")
    suspend fun getContact():  Response<ContactUS?>?

    //check software update apk
//    @GET("/Contact")
//    fun  suspend fun(): Call<ResponseBody?>?
}