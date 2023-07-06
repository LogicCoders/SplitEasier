package com.SplitEasier.spliteasier.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("EXPENSE")
public class Expense {
    @Id
    private String id;
    private String description;
    private String expDate;
    private String cost;
    private String docID;

    public Expense(String description, String expDate, String cost) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.expDate = expDate;
        this.cost = cost;
    }

    public Expense() {
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
