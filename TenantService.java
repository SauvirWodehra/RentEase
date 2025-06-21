package com.sauvir.RentEase.service;

import com.sauvir.RentEase.NullObjectException;
import com.sauvir.RentEase.model.Tenant;
import com.sauvir.RentEase.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantService {

    @Autowired
    private TenantRepository repoTenant;

    public Tenant registerTenant(Tenant tenant){
        repoTenant.save(tenant);
        return tenant;
    }

    public Tenant getTenantById(int id){
        Optional<Tenant> optionalTenant=repoTenant.findById(id);
        if(optionalTenant.isEmpty()) throw new NullObjectException("No tenant Found By TenantId :"+id);
        Tenant tenant= optionalTenant.get();
        return tenant;
    }

    public List<Tenant> getAllTenants(){return repoTenant.findAll();}

    public void delete(int id) {
        Optional<Tenant> optionalTenant=repoTenant.findById(id);
        if(optionalTenant.isEmpty()) throw new NullObjectException("No tenant Found By TenantId :"+id);
        Tenant tenant= optionalTenant.get();
        repoTenant.delete(tenant);
    }

    public Tenant update(int id, Tenant updatedTenant) {
        Optional<Tenant> optionalTenant=repoTenant.findById(id);
        if(optionalTenant.isEmpty()) throw new NullObjectException("No tenant Found By TenantId :"+id);
        Tenant tenant= optionalTenant.get();
        tenant.setTenantName(updatedTenant.getTenantName());
        tenant.setTenantEmail(updatedTenant.getTenantEmail());
        tenant.setTenantPhoneNo(updatedTenant.getTenantPhoneNo());
        tenant.setBookings(updatedTenant.getBookings());
        repoTenant.save(tenant);
        return tenant;
    }
}
