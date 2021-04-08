package com.example.cswork.network.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Team {

    @SerializedName("twitterInfo")
    @Expose
    private TwitterInfo twitterInfo;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("details")
    @Expose
    private Details details;
    @SerializedName("calculatedStatus")
    @Expose
    private String calculatedStatus;
    @SerializedName("calculatedStage")
    @Expose
    private String calculatedStage;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("properties")
    @Expose
    private Properties properties;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("office")
    @Expose
    private String office;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("modifiedAt")
    @Expose
    private String modifiedAt;
    @SerializedName("modifiedBy")
    @Expose
    private String modifiedBy;
    @SerializedName("isTeam")
    @Expose
    private Boolean isTeam;
    @SerializedName("paymentDetails")
    @Expose
    private List<Object> paymentDetails = null;
    @SerializedName("cardType")
    @Expose
    private Object cardType;

    public TwitterInfo getTwitterInfo() {
        return twitterInfo;
    }

    public void setTwitterInfo(TwitterInfo twitterInfo) {
        this.twitterInfo = twitterInfo;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public String getCalculatedStatus() {
        return calculatedStatus;
    }

    public void setCalculatedStatus(String calculatedStatus) {
        this.calculatedStatus = calculatedStatus;
    }

    public String getCalculatedStage() {
        return calculatedStage;
    }

    public void setCalculatedStage(String calculatedStage) {
        this.calculatedStage = calculatedStage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Boolean getIsTeam() {
        return isTeam;
    }

    public void setIsTeam(Boolean isTeam) {
        this.isTeam = isTeam;
    }

    public List<Object> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<Object> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Object getCardType() {
        return cardType;
    }

    public void setCardType(Object cardType) {
        this.cardType = cardType;
    }
}
