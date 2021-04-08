package com.example.cswork.ui.quickLinks.contactUs

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class ContactUS(
    @SerializedName("data")
    val `data`: Data,
//    @SerializedName("errorMsg")
//    val errorMsg: Any, // null
    @SerializedName("isValid")
    val isValid: Boolean, // true
//    @SerializedName("list")
//    val list: Any, // null
//    @SerializedName("successMsg")
//    val successMsg: Any // null
)
