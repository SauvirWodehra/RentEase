package com.sauvir.RentEase.repository;

import com.sauvir.RentEase.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    @Query("SELECT b FROM Booking b WHERE b.property.propertyId = :propertyId")
    List<Booking> findBookingByPropertyId(@Param("propertyId") int propertyId);

    @Query("SELECT b FROM Booking b WHERE b.tenant.tenantId = :tenantId")
    List<Booking> findBookingByTenantId(@Param("tenantId") int tenantId);

    @Query("SELECT b FROM Booking b WHERE b.property.propertyId = :propertyId AND b.tenant.tenantId = :tenantId")
    Booking findByBothTenantAndPropertyId(@Param("propertyId") int propertyId,
                                          @Param("tenantId") int tenantId);

}
