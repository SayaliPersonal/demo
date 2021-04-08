package com.example.cswork.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ContactUs(
    @SerializedName("data")
    @Expose
    val data: Contact? = null,

    @SerializedName("list")
    @Expose
    val list: Any? = null,

    @SerializedName("isValid")
    @Expose
    val isValid: Boolean? = null,

    @SerializedName("successMsg")
    @Expose
    val successMsg: Any? = null,

    @SerializedName("errorMsg")
    @Expose
    val errorMsg: Any? = null
)
