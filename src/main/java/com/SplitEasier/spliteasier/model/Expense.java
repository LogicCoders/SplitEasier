package com.SplitEasier.spliteasier.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table("EXPENSE")
public class Expense {


    @Id
    private String id;

    private String expenseName;
    private String expenseDate;

    private String vendorId;
    private Double amount;

    private ExpenseType expenseType;



    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }


    public Expense(String expenseName, String expenseDate, String vendorId, Double amount, ExpenseType expenseType) {
        this.expenseName = expenseName;
        this.expenseDate = expenseDate;
        this.vendorId = vendorId;
        this.amount = amount;
        this.expenseType = expenseType;
        this.id = UUID.randomUUID().toString();
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

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
