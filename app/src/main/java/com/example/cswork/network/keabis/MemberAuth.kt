package com.example.cswork.network.keabis

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MemberAuth(
    @field:Expose @field:SerializedName("memberId") private val memberId: String,
    @field:Expose @field:SerializedName(
        "meetingRoomId"
    ) private val meetingRoomId: String,
    @field:Expose @field:SerializedName("fromDateTime") private val fromDateTime: String,
    @field:Expose @field:SerializedName(
        "toDateTime"
    ) private val toDateTime: String,
    @field:Expose @field:SerializedName("accessType") private val accessType: String,
    @field:Expose @field:SerializedName(
        "qrCode"
    ) private val qrCode: String
)