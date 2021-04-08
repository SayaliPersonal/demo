package com.example.cswork.ui.myActivity.DataClass


import com.google.gson.annotations.SerializedName

data class MyActivityData(
    @SerializedName("data")
    val `data`: Any, // null
    @SerializedName("errorMsg")
    val errorMsg: Any, // null
    @SerializedName("isValid")
    val isValid: Boolean, // true
    @SerializedName("list")
    val list: List<MyActivityDataList>,
    @SerializedName("successMsg")
    val successMsg: Any // null
) {
    data class MyActivityDataList(
        @SerializedName("bookedBy")
        val bookedBy: String, // user
        @SerializedName("bookingId")
        val bookingId: String, // 7907
        @SerializedName("createdBy")
        val createdBy: Int, // 56
        @SerializedName("createdDate")
        val createdDate: String, // 2021-04-02T12:46:38.53
        @SerializedName("creditPointsUsed")
        val creditPointsUsed: Double, // 1.0000000000
        @SerializedName("date")
        val date: String, // 2021-04-05T12:46:38.53
        @SerializedName("duration")
        val duration: Double, // 1.0
        @SerializedName("fromTime")
        val fromTime: String, // 11:00 AM
        @SerializedName("id")
        val id: Int, // 4
        @SerializedName("isActive")
        val isActive: Boolean, // true
        @SerializedName("location")
        val location: Any, // null
        @SerializedName("locationId")
        val locationId: Int, // 1
        @SerializedName("meetingRoom")
        val meetingRoom: MeetingRoom,
        @SerializedName("meetingRoomId")
        val meetingRoomId: Int, // 2
        @SerializedName("modifiedBy")
        val modifiedBy: Int, // 6
        @SerializedName("modifiedDate")
        val modifiedDate: String, // 2021-04-02T12:46:38.53
        @SerializedName("status")
        val status: String, // Active
        @SerializedName("t0200UserFeedBacks")
        val t0200UserFeedBacks: List<Any>,
        @SerializedName("t0300MeetingRoomBookingAttendees")
        val t0300MeetingRoomBookingAttendees: List<Any>,
        @SerializedName("tenant")
        val tenant: Any, // null
        @SerializedName("tenantId")
        val tenantId: Int, // 1
        @SerializedName("toTime")
        val toTime: String, // 12:00 AM
        @SerializedName("user")
        val user: Any, // null
        @SerializedName("userId")
        val userId: Int // 1
    ) {
        data class MeetingRoom(
            @SerializedName("createdBy")
            val createdBy: Int, // 12345
            @SerializedName("createdDate")
            val createdDate: String, // 2021-04-02T12:43:49.93
            @SerializedName("floorNo")
            val floorNo: String, // 4th floor
            @SerializedName("id")
            val id: Int, // 2
            @SerializedName("isActive")
            val isActive: Boolean, // true
            @SerializedName("isPriviledge")
            val isPriviledge: Boolean, // true
            @SerializedName("location")
            val location: Any, // null
            @SerializedName("locationId")
            val locationId: Int, // 1
            @SerializedName("m0300MeetingRoomImages")
            val m0300MeetingRoomImages: List<Any>,
            @SerializedName("modifiedBy")
            val modifiedBy: Int, // 12345
            @SerializedName("modifiedDate")
            val modifiedDate: String, // 2021-04-02T12:43:49.93
            @SerializedName("mx0300MeetingRoomDetails")
            val mx0300MeetingRoomDetails: List<Any>,
            @SerializedName("name")
            val name: String, // Rocket
            @SerializedName("noOfPax")
            val noOfPax: Int, // 20
            @SerializedName("ratePerHour")
            val ratePerHour: Double, // 4.0
            @SerializedName("roomId")
            val roomId: Int, // 894526
            @SerializedName("roomNo")
            val roomNo: String, // 7th room
            @SerializedName("t0300MeetingRoomBookings")
            val t0300MeetingRoomBookings: List<T0300MeetingRoomBooking>
        ) {
            data class T0300MeetingRoomBooking(
                @SerializedName("bookedBy")
                val bookedBy: String, // user
                @SerializedName("bookingId")
                val bookingId: String, // 7907
                @SerializedName("createdBy")
                val createdBy: Int, // 56
                @SerializedName("createdDate")
                val createdDate: String, // 2021-04-02T12:48:07.7
                @SerializedName("creditPointsUsed")
                val creditPointsUsed: Double, // 1.0000000000
                @SerializedName("date")
                val date: String, // 2021-04-06T12:48:07.7
                @SerializedName("duration")
                val duration: Double, // 1.0
                @SerializedName("fromTime")
                val fromTime: String, // 10:00 AM
                @SerializedName("id")
                val id: Int, // 5
                @SerializedName("isActive")
                val isActive: Boolean, // true
                @SerializedName("location")
                val location: Any, // null
                @SerializedName("locationId")
                val locationId: Int, // 1
                @SerializedName("meetingRoomId")
                val meetingRoomId: Int, // 2
                @SerializedName("modifiedBy")
                val modifiedBy: Int, // 6
                @SerializedName("modifiedDate")
                val modifiedDate: String, // 2021-04-02T12:48:07.7
                @SerializedName("status")
                val status: String, // Active
                @SerializedName("t0200UserFeedBacks")
                val t0200UserFeedBacks: List<Any>,
                @SerializedName("t0300MeetingRoomBookingAttendees")
                val t0300MeetingRoomBookingAttendees: List<Any>,
                @SerializedName("tenant")
                val tenant: Any, // null
                @SerializedName("tenantId")
                val tenantId: Int, // 1
                @SerializedName("toTime")
                val toTime: String, // 11:00 AM
                @SerializedName("user")
                val user: Any, // null
                @SerializedName("userId")
                val userId: Int // 1
            )
        }
    }
}