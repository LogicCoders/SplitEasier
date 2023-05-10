package com.SplitEasier.spliteasier.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;


@Table("VENDOR")
public class Vendor {

    private String vendorName;

    @Id
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
