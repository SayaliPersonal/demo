package com.example.cswork.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cswork.data.model.ContactUs
import com.example.cswork.data.repository.ContactUsRepository

class ContactUsViewModel : ViewModel() {

    var contactUsData: MutableLiveData<ContactUs>? = null

    fun getContactUsData() : LiveData<ContactUs>? {
        contactUsData = ContactUsRepository.getContactUsCall()
        return contactUsData
    }
}