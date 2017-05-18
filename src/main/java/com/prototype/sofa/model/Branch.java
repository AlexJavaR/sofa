package com.prototype.sofa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "branches", uniqueConstraints = {@UniqueConstraint(columnNames = {"place_id", "department_id"}, name = "branches_unique_place_department_idx")})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Branch extends BaseEntity {

    @Column(name = "place_id", nullable = false)
    @NotEmpty
    private String placeId;

    @Column(name = "latitude", nullable = false)
    @NotNull
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    @NotNull
    private Double longitude;

    @Column(name = "phone", nullable = false)
    @NotEmpty
    private String phoneNumber;

    @Column(name = "hour", nullable = false)
    @NotEmpty
    private String openHours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    @JsonManagedReference
    private Department department;

    public Branch() {
    }

    public Branch(String placeId, Double latitude, Double longitude, String phoneNumber, String openHours) {
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.openHours = openHours;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
