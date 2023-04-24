package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Expense;
import com.SplitEasier.spliteasier.model.Vendor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ExpenseService {


    private final VendorService vendorService;

    private List<Expense> expenseList = new ArrayList<>();

    public ExpenseService(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    public Expense createExpense(String expenseName, Date expenseDate, String vendorName, Double amount) {
        Vendor vendor = vendorService.findByName(vendorName);
        Expense expense = new Expense(expenseName, expenseDate, vendorName, amount);
        expenseList.add(expense);
        return expense;
    }
    public List<Expense> findAll(){
        return expenseList;
    }
}
