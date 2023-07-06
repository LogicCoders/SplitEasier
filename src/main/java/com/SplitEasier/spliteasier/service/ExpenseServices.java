package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Expense;
import com.SplitEasier.spliteasier.repository.ExpenseRepository;
import com.SplitEasier.spliteasier.splitwise.SplitwiseAPI;
import com.SplitEasier.spliteasier.splitwise.util.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ExpenseServices {
    private final ExpenseRepository expenseRepository;
    private final DocumentServices documentServices;
    private final SplitwiseAPI splitwiseAPI;
    public ExpenseServices(ExpenseRepository expenseRepository, DocumentServices documentServices, SplitwiseAPI splitwiseAPI) {
        this.expenseRepository = expenseRepository;
        this.documentServices = documentServices;
        this.splitwiseAPI = splitwiseAPI;
    }
    public Expense createExpense(String description, String expDate, String cost){
        Expense newExpense = new Expense(description, expDate, cost);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        newExpense.setDocID(documentServices.getIdByCurrDt(formatter.format(date)));
        return expenseRepository.save(newExpense);
    }
    public void createExpenseListInSplitwise(List<Expense> expenseList) throws JsonProcessingException, URISyntaxException {
        expenseList.stream().forEach((expense -> {
            try {
                splitwiseAPI.createExpenseInGroup(expense.getCost(), expense.getDescription(), Constants.GROUP_ID, true);
            } catch (JsonProcessingException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }));
    }
}
