package com.example.cswork.network

import com.example.cswork.data.model.ContactUs
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoints {

    @GET("api/Contact")
    fun contactUs(): Call<ContactUs?>?
}