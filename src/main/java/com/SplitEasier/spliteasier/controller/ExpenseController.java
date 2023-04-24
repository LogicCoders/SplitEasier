package com.SplitEasier.spliteasier.controller;

import com.SplitEasier.spliteasier.model.Expense;
import com.SplitEasier.spliteasier.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/")
    public List<Expense> findAllExpenses(){
        return expenseService.findAll();
    }

    @PostMapping("/")
    public Expense createExpense(@RequestBody Expense expense){
        return expenseService.createExpense(expense.getExpenseName(),expense.getExpenseDate(),expense.getVendorName(),expense.getAmount());
    }

}
