package com.example.cswork.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cswork.data.model.ContactUs
import com.example.cswork.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ContactUsRepository {

    val contactUs = MutableLiveData<ContactUs>()

    fun getContactUsCall(): MutableLiveData<ContactUs> {

        val call = RetrofitClient.apiEndPoints.contactUs()

        call!!.enqueue(object : Callback<ContactUs?> {
            override fun onFailure(call: Call<ContactUs?>, t: Throwable) {
                Log.d("Error", "*****************")
                Log.v("DEBUG : ", t.message.toString())
                Log.d("Error", t.localizedMessage!!)
            }

            override fun onResponse(call: Call<ContactUs?>, response: Response<ContactUs?>) {
                Log.i("D", "@@@@@@@@@@@@@@@@@@@@@@")
                Log.v("DEBUG : ", response.body().toString())
                if(response.isSuccessful) {
                    val data = response.body()
                    contactUs.value = ContactUs()
                }
            }
        })

        return contactUs
    }
}