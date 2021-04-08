package com.example.cswork.network.creditPoints;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Once {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("remaining")
    @Expose
    private Integer remaining;
    @SerializedName("used")
    @Expose
    private Integer used;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }
}
