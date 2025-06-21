package com.sauvir.RentEase.service;

import com.sauvir.RentEase.NullObjectException;
import com.sauvir.RentEase.model.Landlord;
import com.sauvir.RentEase.model.Property;
import com.sauvir.RentEase.repository.LandLordRepository;
import com.sauvir.RentEase.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository repoProperty;

    @Autowired
    private LandLordRepository repoLandlord;

    public List<Property> getAllProperties(){
            return repoProperty.findAll();
    }

    public Property getPropertybyId(int propertyId){
        Optional<Property> optionalProperty=repoProperty.findById(propertyId);
        if(optionalProperty.isEmpty()) throw  new NullObjectException("No Property Found with property id :"+ propertyId);
        Property property=optionalProperty.get();
        return property;
    }

    public Property addProperty(int landlordId, Property property){
        Optional<Landlord> landlordOptional=repoLandlord.findById(landlordId);
        if(landlordOptional.isEmpty()) throw new NullObjectException("No Landlord Found with LandLordId :"+landlordId);
        Landlord landlord= landlordOptional.get();
        property.setLandlord(landlord);
        repoProperty.save(property);
        return property;
    }

    public List<Property> getPropertiesByType(String type){
        return repoProperty.findPropertyByType(type);
    }

    public void deleteProperty(int id) {
        Optional<Property> optionalProperty=repoProperty.findById(id);
        if(optionalProperty.isEmpty()) throw new NullObjectException("No property Found with PropertyId: "+id);
        Property property=optionalProperty.get();
        repoProperty.delete(property);
    }

    public Property update(int id, Property updatedproperty) {
        Optional<Property> optionalProperty=repoProperty.findById(id);
        if(optionalProperty.isEmpty()) throw new NullObjectException("No property Found with PropertyId: "+id);
        Property property=optionalProperty.get();
        property.setPropertyTitle(updatedproperty.getPropertyTitle());
        property.setPropertyAddress(updatedproperty.getPropertyAddress());
        property.setPropertyRentPrice(updatedproperty.getPropertyRentPrice());
        property.setPropertyType(updatedproperty.getPropertyType());
        property.setLandlord(updatedproperty.getLandlord());
        property.setBookings(updatedproperty.getBookings());
        repoProperty.save(property);
        return property;
    }
}
