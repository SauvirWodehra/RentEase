package com.sauvir.RentEase.service;

import com.sauvir.RentEase.NullObjectException;
import com.sauvir.RentEase.model.Landlord;
import com.sauvir.RentEase.repository.LandLordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandLordService {

    @Autowired
    private LandLordRepository repoLandlord;

    public Landlord registerLandlord(Landlord landlord){
        repoLandlord.save(landlord);
        return landlord;
    }

    public Landlord getLandlordById(int id){
        Optional<Landlord> landlord=repoLandlord.findById(id);
        if(landlord.isEmpty()) throw new NullObjectException("No landlord Found with Landlord id :"+id);
        Landlord l= landlord.get();
        return l;
    }

    public List<Landlord> getAllLandlords(){ return repoLandlord.findAll();}

    public void delete(int id) {
        Optional<Landlord> landlord=repoLandlord.findById(id);
        if(landlord.isEmpty()) throw new NullObjectException("No landlord Found with Landlord id :"+id);
        Landlord l= landlord.get();
        repoLandlord.delete(l);
    }

    public Landlord update(int id, Landlord updatedLandlord) {
        Optional<Landlord> landlord=repoLandlord.findById(id);
        if(landlord.isEmpty()) throw new NullObjectException("No landlord Found with Landlord id :"+id);
        Landlord l= landlord.get();
        l.setLandlordName(updatedLandlord.getLandlordName());
        l.setLandlordEmail(updatedLandlord.getLandlordEmail());
        l.setLandlordPhoneNo(updatedLandlord.getLandlordPhoneNo());
        if(updatedLandlord.getProperties() !=null) l.setProperties(updatedLandlord.getProperties());
        repoLandlord.save(l);
        return l;
    }
}
