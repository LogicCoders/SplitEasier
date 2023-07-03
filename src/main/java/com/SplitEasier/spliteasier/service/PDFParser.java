package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Expense;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PDFParser {
    private String content;
    private ArrayList<Expense> expenseArrayList = new ArrayList<>();
    private PDDocument pdDocument;
    private final DocumentServices documentServices;
    private final ExpenseServices expenseServices;

    private final Logger logger = LoggerFactory.getLogger(PDFParser.class);

    public PDFParser(DocumentServices documentServices, ExpenseServices expenseServices) {
        this.documentServices = documentServices;
        this.expenseServices = expenseServices;
    }

    public PDFParser loadAndSetContent(File file) throws IOException {
        pdDocument = PDDocument.load(file);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        content = pdfTextStripper.getText(pdDocument);
        return this;
    }

    public ArrayList<Expense> createExpense() {
        String expenseDetails = getExpenseDetails();
        String[] lines = expenseDetails.split("\n");

        for(String line : lines) {
            Expense expense = new Expense();
            String desc = "";
            String pattern = desc + "\\D*(\\d+\\.\\d+)";

            if (line.contains("DUNNES")) {
                desc = "DUNNES";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                matcher.find();
                String cost = matcher.group(1);
                expense.setDescription(desc);
                expense.setCost(new BigDecimal(cost));
                expense.setExpDate(formatter.format(date));
            } else if (line.contains("TESCO")) {
                desc = "TESCO";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                matcher.find();
                String cost = matcher.group(1);
                expense.setDescription(desc);
                expense.setCost(new BigDecimal(cost));
                expense.setExpDate(formatter.format(date));
            } else if (line.contains("ALDI")) {
                desc = "ALDI";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                matcher.find();
                String cost = matcher.group(1);
                expense.setDescription(desc);
                expense.setCost(new BigDecimal(cost));
                expense.setExpDate(formatter.format(date));
            } else if (line.contains("BORD GAIS")) {
                desc = "BORD GAIS";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                matcher.find();
                String cost = matcher.group(1);
                expense.setDescription(desc);
                expense.setCost(new BigDecimal(cost));
                expense.setExpDate(formatter.format(date));
            } else if (line.contains("DELIVEROO")) {
                desc = "DELIVEROO";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                matcher.find();
                String cost = matcher.group(1);
                expense.setDescription(desc);
                expense.setCost(new BigDecimal(cost));
                expense.setExpDate(formatter.format(date));
            } else if (line.contains("LIDL")) {
                desc = "LIDL";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                matcher.find();
                String cost = matcher.group(1);
                expense.setDescription(desc);
                expense.setCost(new BigDecimal(cost));
                expense.setExpDate(formatter.format(date));
            }
            if (expense.getDescription()!=null) {
                expenseArrayList.add(new Expense(expense.getDescription(), expense.getExpDate(), expense.getCost()));
            }
        }
        logger.debug("Expense list: {}", expenseArrayList);
        return expenseArrayList;
    }
    private String getExpenseDetails() {
        int startingIndex = content.indexOf("Date Details Debit € Credit € Balance €\n");
        int endingIndex = content.indexOf("This is an eligible deposit under the Deposit Guarantee Scheme. For more information, ");
        String expenseDetails = content.substring(startingIndex + 40, endingIndex);
        return expenseDetails;
    }
}
