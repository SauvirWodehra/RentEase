package com.sauvir.RentEase.repository;

import com.sauvir.RentEase.model.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandLordRepository extends JpaRepository<Landlord,Integer> {
}
