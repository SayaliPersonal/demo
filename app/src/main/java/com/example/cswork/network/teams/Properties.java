package com.example.cswork.network.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("Pax")
    @Expose
    private Integer pax;
    @SerializedName("Transaction")
    @Expose
    private String transaction;
    @SerializedName("Type")
    @Expose
    private String type;

    public Integer getPax() {
        return pax;
    }

    public void setPax(Integer pax) {
        this.pax = pax;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
