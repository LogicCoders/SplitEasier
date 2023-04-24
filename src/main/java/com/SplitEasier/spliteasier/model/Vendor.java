package com.SplitEasier.spliteasier.model;

import java.util.UUID;

public class Vendor {

    private String vendorName;
    private String id;

    public Vendor(String vendorName) {
        this.vendorName = vendorName;
        this.id = UUID.randomUUID().toString();
    }

    public Vendor() {
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
