package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Document;
import com.SplitEasier.spliteasier.model.Expense;
import com.SplitEasier.spliteasier.repository.ExpenseRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ExpenseServices {


    private final ExpenseRepository expenseRepository;
    private final DocumentServices documentServices;


    public ExpenseServices(ExpenseRepository expenseRepository, DocumentServices documentServices) {
        this.expenseRepository = expenseRepository;
        this.documentServices = documentServices;
    }

    @Transactional
    public Expense createExpense(String description, String expDate, String cost){
        Expense newExpense = new Expense();
        newExpense.setDescription(description);
        newExpense.setExpDate(expDate);
        newExpense.setCost(cost);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        newExpense.setDocID(documentServices.getIdByCurrDt(formatter.format(date)));
        return expenseRepository.save(newExpense);
    }






}
