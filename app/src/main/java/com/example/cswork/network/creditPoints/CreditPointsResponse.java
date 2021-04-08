package com.example.cswork.network.creditPoints;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreditPointsResponse {

    @SerializedName("creditAccount")
    @Expose
    private String creditAccount;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("rates")
    @Expose
    private List<Object> rates = null;
    @SerializedName("resourceTypes")
    @Expose
    private List<String> resourceTypes = null;
    @SerializedName("oneOffPlans")
    @Expose
    private List<Object> oneOffPlans = null;
    @SerializedName("validFor")
    @Expose
    private String validFor;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("monthly")
    @Expose
    private Monthly monthly;
    @SerializedName("once")
    @Expose
    private Once once;

    public String getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getRates() {
        return rates;
    }

    public void setRates(List<Object> rates) {
        this.rates = rates;
    }

    public List<String> getResourceTypes() {
        return resourceTypes;
    }

    public void setResourceTypes(List<String> resourceTypes) {
        this.resourceTypes = resourceTypes;
    }

    public List<Object> getOneOffPlans() {
        return oneOffPlans;
    }

    public void setOneOffPlans(List<Object> oneOffPlans) {
        this.oneOffPlans = oneOffPlans;
    }

    public String getValidFor() {
        return validFor;
    }

    public void setValidFor(String validFor) {
        this.validFor = validFor;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Monthly getMonthly() {
        return monthly;
    }

    public void setMonthly(Monthly monthly) {
        this.monthly = monthly;
    }

    public Once getOnce() {
        return once;
    }

    public void setOnce(Once once) {
        this.once = once;
    }

}


