package com.example.cswork.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Contact(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("contactNumber")
    @Expose
    var contactNumber: String? = null,

    @SerializedName("address")
    @Expose
    var address: String? = null,

    @SerializedName("emailId")
    @Expose
    var emailId: String? = null,

    @SerializedName("isActive")
    @Expose
    var isActive: Boolean? = null,

    @SerializedName("createdBy")
    @Expose
    var createdBy: Int? = null,

    @SerializedName("createdDate")
    @Expose
    var createdDate: String? = null,

    @SerializedName("modifiedBy")
    @Expose
    var modifiedBy: Any? = null,

    @SerializedName("modifiedDate")
    @Expose
    var modifiedDate: Any? = null
)