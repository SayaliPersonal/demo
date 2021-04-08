package com.example.cswork.ui.quickLinks.contactUs


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("address")
    val address: String, // 2nd Floor, Park Square Mall, ITPB, Whitefield,   Bangalore - 560066
    @SerializedName("contactNumber")
    val contactNumber: String, // +91 8296999888
    @SerializedName("createdBy")
    val createdBy: Int, // 1
    @SerializedName("createdDate")
    val createdDate: String, // 2021-04-01T11:20:20.6266667
    @SerializedName("emailId")
    val emailId: String, // bridgeplusbangalore@capitaland.com
    @SerializedName("id")
    val id: Int, // 1
    @SerializedName("isActive")
    val isActive: Boolean, // true
//    @SerializedName("modifiedBy")
//    val modifiedBy: Any, // null
//    @SerializedName("modifiedDate")
//    val modifiedDate: Any // null
)