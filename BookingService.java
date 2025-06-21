package com.sauvir.RentEase.service;

import com.sauvir.RentEase.NullObjectException;
import com.sauvir.RentEase.model.Booking;
import com.sauvir.RentEase.model.Property;
import com.sauvir.RentEase.model.Tenant;
import com.sauvir.RentEase.repository.BookingRepository;
import com.sauvir.RentEase.repository.PropertyRepository;
import com.sauvir.RentEase.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repoBooking;

    @Autowired
    private PropertyRepository repoProperty;

    @Autowired
    private TenantRepository repoTenant;

    public Booking createBooking(int propertyId, int tenantId, Booking booking){
        Optional<Property>optionalProperty=repoProperty.findById(propertyId);
        Optional<Tenant>optionalTenant=repoTenant.findById(tenantId);

        if(optionalProperty.isPresent() && optionalTenant.isPresent()){
            Property property= optionalProperty.get();
            Tenant tenant= optionalTenant.get();
            booking.setProperty(property);
            booking.setTenant(tenant);
            repoBooking.save(booking);
            return booking;
        }
         throw new NullObjectException("No property Found with Property id :"+propertyId+"OR"+""+"No tenant found with TenantId:"+tenantId );
    }

    public Booking getBookingById(int id){
        Optional<Booking> bookingOptional=repoBooking.findById(id);
        if(bookingOptional.isEmpty()){
           throw new NullObjectException("No booking Found with booking id :"+id);
        }
        Booking booking=bookingOptional.get();
        return booking;
    }

    public List<Booking> getBookingsByPropertyId(int propertyId){
        return repoBooking.findBookingByPropertyId(propertyId);
    }

    public List<Booking> getBookingsByTenantId(int tenantId){
        return repoBooking.findBookingByTenantId(tenantId);
    }

    public Booking getBookingByBothId(int propertyId, int tenantId) {
        Booking booking=repoBooking.findByBothTenantAndPropertyId(propertyId,tenantId);
        if(booking==null) throw new NullObjectException("No Booking with such specifications  found..");
        return booking;
    }

    public void DeleteBooking(int id){
        Optional<Booking> optionalBooking=repoBooking.findById(id);
        if(optionalBooking.isEmpty()) throw new NullObjectException("No Booking found with Booking id :"+id);
        Booking booking= optionalBooking.get();
        repoBooking.delete(booking);
        }

    public Booking updateBookingStatus(int id, String status) {
        Optional<Booking> optionalBooking=repoBooking.findById(id);
        if(optionalBooking.isEmpty()) throw new NullObjectException("No Booking found with Booking id :"+id);
        Booking booking= optionalBooking.get();
        booking.setStatus(status);
        repoBooking.save(booking);
        return booking;
    }
}

