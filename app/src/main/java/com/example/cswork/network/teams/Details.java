package com.example.cswork.network.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Details {

    @SerializedName("currency")
    @Expose
    private Object currency;
    @SerializedName("taxRate")
    @Expose
    private String taxRate;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("regId")
    @Expose
    private String regId;

    public Object getCurrency() {
        return currency;
    }

    public void setCurrency(Object currency) {
        this.currency = currency;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }
}
