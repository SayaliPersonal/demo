package com.example.cswork.network;

import androidx.annotation.ColorRes;

import com.example.cswork.data.model.ContactUs;
import com.example.cswork.network.auth.AuthResponse;
import com.example.cswork.network.login.LoginRequest;
import com.example.cswork.network.login.LoginResponse;
import com.example.cswork.network.registration.CommonResponse;
import com.example.cswork.network.registration.RegistrationRequest;
import com.example.cswork.network.teams.TeamsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndPoints {

    @FormUrlEncoded
    @POST("api/Registration/getOtp")
    Call<Void> getOtp(@Field("ContactNumber") String contactNumber);

    @FormUrlEncoded
    @POST("api/Registration/verifyOtp")
    Call<Void> verifyOtp(@Field("otp") String otp,
                         @Field("contactNumber") String contactNumber);

    @FormUrlEncoded
    @POST("api/Registration/register")
    Call<Void> register(@Field("userName") String userName,
                        @Field("contactNumber") String contactNumber,
                        @Field("email") String email,
                        @Field("password") String password,
                        @Field("confirmPassword") String confirmPassword);

    @POST("api/Registration/register")
    Call<CommonResponse> register2(@Body RegistrationRequest request);

    @POST("api/Registration/register")
    Call<LoginResponse> login2(@Body LoginRequest request);

    @FormUrlEncoded
    @POST("api/Registration/emailsRegistered")
    Call<Void> emailsRegistered(@Field("userName") String userName,
                        @Field("contactNumber") String contactNumber,
                        @Field("email") String email,
                        @Field("password") String password,
                        @Field("confirmPassword") String confirmPassword);

    @GET("api/Token")
    Call<Void> loginEmail(@Path("Email") String Email,
                        @Path("Password") String Password);

    @GET("api/member/qr")
    Call<Void> generateMyQR(@Path("userId") String userId);

    @GET("api/Contact")
    Call<ContactUs> contactUs();



    /*TODO delete below ---------> */

    @FormUrlEncoded
    @POST("/oauth/token")
    Call<AuthResponse> authenticate(@Field("client_id") String client_id,
                                    @Field("client_secret") String client_secret,
                                    @Field("grant_type") String grant_type,
                                    @Field("scope") String scope);

    @GET("api/v1/organizations/thebridge-india-staging/members/{memberId}")
    Call<TeamsResponse> getTeams(@Header("Authorization") String auth, @Header("Content-Type") String contentType,
                                 @Path("memberId") String memberId);

    @GET("api/v1/organizations/thebridge-india-staging/credit-accounts/stats?")
    Call<Void> creditPoints(@Header("Authorization") String auth,
                            @Query("team") String team,
                            @Query("month") String month);
}
