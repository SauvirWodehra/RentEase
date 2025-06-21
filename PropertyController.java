package com.sauvir.RentEase.Controllers;

import com.sauvir.RentEase.model.Property;
import com.sauvir.RentEase.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    private PropertyService serviceProperty;

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> allproperties(){
       return new ResponseEntity<>(serviceProperty.getAllProperties(),HttpStatus.OK);
    }

    @GetMapping("/properties/{id}")
    public ResponseEntity<Property> propertyById(@PathVariable int id){
        Property property=serviceProperty.getPropertybyId(id);
        return new ResponseEntity<>(property,HttpStatus.OK);
    }

    @PostMapping("/properties/{landlordId}")
    public ResponseEntity<Property> addPropertyToLandLord(@PathVariable int landlordId,@RequestBody Property property){
        Property property1=serviceProperty.addProperty(landlordId, property);
        return new ResponseEntity<>(property1,HttpStatus.CREATED);
    }

    @GetMapping("/properties/type/{type}")
    public ResponseEntity<List<Property>> getPropertyByType(@PathVariable String type){
        List<Property> properties=serviceProperty.getPropertiesByType(type);
        return new ResponseEntity<>(properties,HttpStatus.OK);
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable int id){
        serviceProperty.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable int id, @RequestBody Property property){
        Property property1=serviceProperty.update(id,property);
        return new ResponseEntity<>(property1,HttpStatus.OK);
    }
}
