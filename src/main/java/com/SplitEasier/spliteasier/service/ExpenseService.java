package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Expense;
import com.SplitEasier.spliteasier.model.ExpenseType;
import com.SplitEasier.spliteasier.model.Vendor;
import com.SplitEasier.spliteasier.repository.ExpenseRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ExpenseService {


    private final VendorService vendorService;

    private final ExpenseRepository expenseRepository;

    private List<Expense> expenseList = new ArrayList<>();

    public ExpenseService(VendorService vendorService, ExpenseRepository expenseRepository) {

        this.vendorService = vendorService;
        this.expenseRepository = expenseRepository;
    }


    @Transactional
    public Expense createExpense(String expenseName, String expenseDate, String vendorName, Double amount, ExpenseType expenseType) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseDate(expenseDate);
        expense.setVendorId(vendorService.create(vendorName));
        expense.setAmount(amount);
        expense.setExpenseType(expenseType);
        return expenseRepository.save(expense);
    }
    @Transactional
    public Iterable<Expense> findAll(){
        return expenseRepository.findAll();
    }



}
