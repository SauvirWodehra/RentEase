package com.sauvir.RentEase.repository;

import com.sauvir.RentEase.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer> {

    @Query("SELECT p FROM Property p WHERE p.propertyType = :type")
    List<Property> findPropertyByType(@Param("type") String type);
}
