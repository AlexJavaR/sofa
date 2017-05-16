package com.prototype.sofa.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToBranch {
    private String placeId;
    private Double latitude;
    private Double longitude;
    private String nameDepartment;
    private String nameCategory;
    private String nameLanguage;
    private String phoneNumber;
    private String openHours;

    public ToBranch(@JsonProperty("placeId") String placeId, @JsonProperty("latitude") Double latitude, @JsonProperty("longitude") Double longitude,
                    @JsonProperty("nameDepartment") String nameDepartment, @JsonProperty("nameCategory") String nameCategory,
                    @JsonProperty("nameLanguage") String nameLanguage, @JsonProperty("phoneNumber") String phoneNumber,
                    @JsonProperty("openHours") String openHours) {
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nameDepartment = nameDepartment;
        this.nameCategory = nameCategory;
        this.nameLanguage = nameLanguage;
        this.phoneNumber = phoneNumber;
        this.openHours = openHours;
    }

    public String getPlaceId() {
        return placeId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOpenHours() {
        return openHours;
    }
}