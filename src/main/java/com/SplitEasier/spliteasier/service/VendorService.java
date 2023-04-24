package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Vendor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VendorService {

    public Vendor findByName(String vendorName) {
        return new Vendor(vendorName);
    }
}
