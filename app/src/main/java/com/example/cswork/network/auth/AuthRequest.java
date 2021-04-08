package com.example.cswork.network.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthRequest {
    @SerializedName("client_id")
    @Expose
    private String clientId;
    @SerializedName("client_secret")
    @Expose
    private String clientSecret;
    @SerializedName("grant_type")
    @Expose
    private String grantType;
    @SerializedName("scope")
    @Expose
    private String scope;

    public AuthRequest(String clientId, String clientSecret, String grantType, String scope) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
        this.scope = scope;
    }

}
