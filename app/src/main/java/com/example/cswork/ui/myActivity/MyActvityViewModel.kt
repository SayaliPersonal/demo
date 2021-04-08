package com.example.cswork.ui.myActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.cswork.ui.myActivity.DataClass.MyActivityData
import com.sayali.network.APIClient
import com.sayali.network.APIClientS
import com.sayali.network.APIService
import com.sayali.network.APIServices
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class MyActvityViewModel : ViewModel() {
    fun getMyActivity(userId:Int) = liveData<Response<MyActivityData?>?>(Dispatchers.IO) {
        val apiService = APIClientS.getRetrofitInstance().create(APIServices::class.java)
        emit(apiService.getMyActivity(userId))

    }
}