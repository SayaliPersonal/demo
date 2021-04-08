package com.example.cswork.network.keabis;

import com.example.cswork.network.auth.AuthResponse;
import com.example.cswork.network.teams.TeamsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface KeabisEndPoints {
    @Headers({
            "Accept: application/json",
            "Authorization: X-ApiKey 8eb8025e3b0b455fb7910b6f94e9f56bAQAAAAEAACcQAAAAEB2+lxF2saGuEOdks3TBWDJKFmpQAOTyPyTWzBczxiNlA3nOC3F3RAC6y5sNr545tA=="
    })
    @POST("/api/members/create")
        Call<Void> createMember(@Body MemberAuth memberAuth);


    /*
    *  @Headers({
            "Accept: application/json",
            "Authorization: X-ApiKey 8eb8025e3b0b455fb7910b6f94e9f56bAQAAAAEAACcQAAAAEB2+lxF2saGuEOdks3TBWDJKFmpQAOTyPyTWzBczxiNlA3nOC3F3RAC6y5sNr545tA=="
    })
    @POST("/api/members/create")
        Call<Void> createMember(/*@Header("Authorization") String auth
    @Field("memberId") String memberId,
    @Field("meetingRoomId") String meetingRoomId,
    @Field("fromDateTime") String fromDateTime,
    @Field("toDateTime") String toDateTime,
    @Field("accessType") String accessType,
    @Field("qrCode") String qrCode);

     */

//    @GET("api/v1/organizations/thebridge-india-staging/credit-accounts/stats?")
//    Call<Void> creditPoints(@Header("Authorization") String auth,
//                                            @Query("team") String team,
//                                            @Query("month") String month);
}
