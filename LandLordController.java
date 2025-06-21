package com.sauvir.RentEase.Controllers;

import com.sauvir.RentEase.model.Landlord;
import com.sauvir.RentEase.service.LandLordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LandLordController {

    @Autowired
    private LandLordService serviceLandlord;

    @PostMapping("/landlords")
    public ResponseEntity<Landlord> addLandLord(@RequestBody Landlord landlord){
            Landlord landlord1=serviceLandlord.registerLandlord(landlord);
            return new ResponseEntity<>(landlord1, HttpStatus.CREATED);
    }

    @GetMapping("/landlords/{id}")
    public ResponseEntity<Landlord> getLandLordByid(@PathVariable int id){
        Landlord landlord=serviceLandlord.getLandlordById(id);
        return new ResponseEntity<>(landlord,HttpStatus.OK);
    }

    @GetMapping("/landlords")
    public ResponseEntity<List<Landlord>> allLandLords(){
        return new ResponseEntity<>(serviceLandlord.getAllLandlords(),HttpStatus.OK);
    }

    @DeleteMapping("/landlords/{id}")
    public ResponseEntity<Void> deleteLandlord(@PathVariable int id){
        serviceLandlord.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/landlords/{id}")
    public ResponseEntity<Landlord> updateLandlord(@PathVariable int id, @RequestBody Landlord updatedLandlord){
        Landlord landlord=serviceLandlord.update(id,updatedLandlord);
        return new ResponseEntity<>(landlord,HttpStatus.OK);
    }
}
