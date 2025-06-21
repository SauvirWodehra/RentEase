package com.sauvir.RentEase.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyId;
    private String propertyTitle;
    private String propertyAddress;
    private double propertyRentPrice;
    private String propertyType;//{Apartments,Studio,House}
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;
    @OneToMany(mappedBy = "property")
    private List<Booking> bookings= new ArrayList<>();

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public double getPropertyRentPrice() {
        return propertyRentPrice;
    }

    public void setPropertyRentPrice(double propertyRentPrice) {
        this.propertyRentPrice = propertyRentPrice;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
