package com.example.cswork.ui.quickLinks.contactUs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sayali.network.APIClient
import com.sayali.network.APIService
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class ContactUsViewModel : ViewModel() {
    fun getContact() = liveData<Response<ContactUS?>?>(Dispatchers.IO) {
        val apiService = APIClient.getRetrofitInstance().create(APIService::class.java)
        emit(apiService.getContact())

    }
}