package com.sauvir.RentEase.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tenantId;
    private String tenantName;
    private String tenantEmail;
    private String tenantPhoneNo;

    @OneToMany(mappedBy = "tenant")
    private List<Booking> bookings= new ArrayList<>();

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public String getTenantPhoneNo() {
        return tenantPhoneNo;
    }

    public void setTenantPhoneNo(String tenantPhoneNo) {
        this.tenantPhoneNo = tenantPhoneNo;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
