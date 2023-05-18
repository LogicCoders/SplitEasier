package com.SplitEasier.spliteasier.controller;

import com.SplitEasier.spliteasier.model.Expense;
import com.SplitEasier.spliteasier.service.ExpenseService;
import com.SplitEasier.spliteasier.service.VendorService;
import com.SplitEasier.spliteasier.web.form.ExpenseForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    private final ExpenseService expenseService;
    private final VendorService vendorService;
    public WebController(ExpenseService expenseService, VendorService vendorService) {
        this.expenseService = expenseService;
        this.vendorService = vendorService;
    }
    @PostMapping("/expense")
    public String newExpense(@ModelAttribute ExpenseForm expenseForm, Model model) {
       Expense exp = expenseService.createExpense(expenseForm.getExpenseName(),expenseForm.getDate(),expenseForm.getVendorName(),expenseForm.getAmount(),expenseForm.getExpenseType());
        System.out.println(exp.toString());
       return "redirect:/expense";
    }
    @GetMapping("/expense")
    public String getExpenses(Model model){
        model.addAttribute("expenses",expenseService.findAll());
        model.addAttribute("expenseForm",new ExpenseForm());
        return "expense";
    }

}
