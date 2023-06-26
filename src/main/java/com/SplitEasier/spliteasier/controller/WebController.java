package com.SplitEasier.spliteasier.controller;

import com.SplitEasier.spliteasier.model.Document;
import com.SplitEasier.spliteasier.model.Expense;
import com.SplitEasier.spliteasier.repository.DocumentRepository;
import com.SplitEasier.spliteasier.repository.ExpenseRepository;
import com.SplitEasier.spliteasier.service.DocumentServices;
import com.SplitEasier.spliteasier.service.ExpenseServices;
import com.SplitEasier.spliteasier.service.PDFParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class WebController {

private final ExpenseServices expenseServices;
private final DocumentServices documentServices;

    public WebController(ExpenseServices expenseServices, DocumentServices documentServices) {
        this.expenseServices = expenseServices;
        this.documentServices = documentServices;
    }

    @PostMapping("/document")
    public void setDocumentDetails(@RequestParam String name, @RequestParam String path){
        documentServices.createdoc(name,path);
    }


    @PostMapping("/")
    public void setExpenseDetails() throws IOException {
        PDFParser pdfParser = new PDFParser(documentServices,expenseServices);
        ArrayList<Expense> expenseArrayList = new ArrayList<>();
        expenseArrayList = pdfParser.createExpense();
        for(Expense expense : expenseArrayList){
            expenseServices.createExpense(expense.getDescription(),expense.getExpDate(),expense.getCost());
        }
    }
}
