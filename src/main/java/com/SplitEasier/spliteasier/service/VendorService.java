package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Vendor;
import com.SplitEasier.spliteasier.repository.VendorRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public String create(String vendorName){
        Vendor v = new Vendor();
        v.setVendorName(vendorName);
        vendorRepository.save(v);
        return v.getId();
    }
    public List<String> findVendorNames(){
        List<String> namelist = new ArrayList<>();
        Iterable<Vendor> vendorIterable=vendorRepository.findAll();
        for(Vendor v : vendorIterable){
            namelist.add(v.getVendorName());
        }
        return namelist;
    }
}
