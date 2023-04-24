package com.SplitEasier.spliteasier.model;



import java.util.Date;
import java.util.UUID;

public class Expense {


    private String id;
    private String expenseName;
    private Date expenseDate;
    private String vendorName;
    private Double amount;

    public Expense(String expenseName, Date expenseDate, String vendorName, Double amount) {
        this.id = UUID.randomUUID().toString();
        this.expenseName = expenseName;
        this.expenseDate = expenseDate;
        this.vendorName = vendorName;
        this.amount = amount;
    }

    public Expense() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
