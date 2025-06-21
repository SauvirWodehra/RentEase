package com.sauvir.RentEase.Controllers;

import com.sauvir.RentEase.model.Tenant;
import com.sauvir.RentEase.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TenantController {

    @Autowired
    private TenantService serviceTenant;

    @PostMapping("/tenants")
    public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant){
        Tenant tenant1=serviceTenant.registerTenant(tenant);
        return new ResponseEntity<>(tenant1, HttpStatus.OK);
    }

    @GetMapping("/tenants/{id}")
    public ResponseEntity<Tenant> getTenantByid(@PathVariable int id){
       return new ResponseEntity<>(serviceTenant.getTenantById(id),HttpStatus.OK);
    }

    @GetMapping("/tenants")
    public ResponseEntity<List<Tenant>> getAllTenants(){
        return new ResponseEntity<>(serviceTenant.getAllTenants(),HttpStatus.OK);
    }

    @DeleteMapping("/tenants/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable int id){
        serviceTenant.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/tenants/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable int id, @RequestBody Tenant updatedTenant){
        Tenant tenant=serviceTenant.update(id,updatedTenant);
        return new ResponseEntity<>(tenant,HttpStatus.OK);
    }
}
