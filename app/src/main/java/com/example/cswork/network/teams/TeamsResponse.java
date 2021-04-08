package com.example.cswork.network.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamsResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("calculatedStatus")
    @Expose
    private String calculatedStatus;
    @SerializedName("calculatedStage")
    @Expose
    private String calculatedStage;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("details")
    @Expose
    private Details details;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("office")
    @Expose
    private String office;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("modifiedAt")
    @Expose
    private String modifiedAt;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("modifiedBy")
    @Expose
    private String modifiedBy;
    @SerializedName("network")
    @Expose
    private List<Object> network = null;
    @SerializedName("signedDocuments")
    @Expose
    private List<Object> signedDocuments = null;
    @SerializedName("paymentDetails")
    @Expose
    private List<Object> paymentDetails = null;
    @SerializedName("cardType")
    @Expose
    private Object cardType;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public List<Object> getNetwork() {
        return network;
    }

    public void setNetwork(List<Object> network) {
        this.network = network;
    }

    public List<Object> getSignedDocuments() {
        return signedDocuments;
    }

    public void setSignedDocuments(List<Object> signedDocuments) {
        this.signedDocuments = signedDocuments;
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
