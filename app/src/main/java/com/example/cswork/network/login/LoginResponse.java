package com.example.cswork.network.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("list")
    @Expose
    private Object list;
    @SerializedName("isValid")
    @Expose
    private Boolean isValid;
    @SerializedName("successMsg")
    @Expose
    private Object successMsg;
    @SerializedName("errorMsg")
    @Expose
    private Object errorMsg;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Object getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(Object successMsg) {
        this.successMsg = successMsg;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }
}
