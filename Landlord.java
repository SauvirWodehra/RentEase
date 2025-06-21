package com.sauvir.RentEase.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int landlordId;
    private String landlordName;
    private String landlordEmail;
    private String landlordPhoneNo;
    @OneToMany(mappedBy = "landlord")
    private List<Property> properties=new ArrayList<>();

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordEmail() {
        return landlordEmail;
    }

    public void setLandlordEmail(String landlordEmail) {
        this.landlordEmail = landlordEmail;
    }

    public String getLandlordPhoneNo() {
        return landlordPhoneNo;
    }

    public void setLandlordPhoneNo(String landlordPhoneNo) {
        this.landlordPhoneNo = landlordPhoneNo;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
