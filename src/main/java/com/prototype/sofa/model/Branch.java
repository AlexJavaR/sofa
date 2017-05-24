package com.prototype.sofa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

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

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name="day")
    //@Column(name="hour", nullable = false)
    @NotEmpty
    private Map<Integer, String> openHours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonManagedReference
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    @JsonManagedReference
    private Department department;

    //@Type(type = "org.hibernate.spatial.GeometryType")
    @Column(name = "location", columnDefinition="geography(POINT, 4326)", nullable = false)
    //@Column(name = "location", nullable = false)
    @Transient
    private String location;

    public Branch() {
    }

    public Branch(String placeId, Double latitude, Double longitude, String phoneNumber, Map<Integer, String> openHours, String location) {
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.openHours = openHours;
        this.openHours = openHours;
        this.location = location;
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

    public Map<Integer, String> getOpenHours() {
        return openHours;
    }

    public void setOpenHours(Map<Integer, String> openHours) {
        this.openHours = openHours;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
