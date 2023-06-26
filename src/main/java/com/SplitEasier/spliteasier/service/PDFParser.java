package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Expense;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFParser {

    private ArrayList<Expense> expenseArrayList = new ArrayList<>();

    private final DocumentServices documentServices;
    private final ExpenseServices expenseServices;


    public PDFParser(DocumentServices documentServices, ExpenseServices expenseServices) {
        this.documentServices = documentServices;
        this.expenseServices = expenseServices;
    }

    public String getContents() throws IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String dateformat = formatter.format(date);
        String path = documentServices.getPath(dateformat);
        String name = documentServices.getName(path);
        String pathname = path + "/" +name;
        System.out.println(pathname);
        File file = new File(path+"/"+name);
        PDDocument doc = PDDocument.load(file);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String content = pdfTextStripper.getText(doc);
        return content;
    }
    public String getExpenseDetails() throws IOException {
        String content = this.getContents();
        int startingindex = content.indexOf("Date Details Debit € Credit € Balance €\n");
        int endingindex = content.indexOf("This is an eligible deposit under the Deposit Guarantee Scheme. For more information, ");
        String expenseDetails = content.substring(startingindex+40,endingindex);
        System.out.println(expenseDetails);
        return expenseDetails;
    }

    public ArrayList<Expense> createExpense() throws IOException {
        String expensedetails = getExpenseDetails();
        String[] lines = expensedetails.split("\n");

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
                expense.setCost(cost);
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
                expense.setCost(cost);
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
                expense.setCost(cost);
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
                expense.setCost(cost);
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
                expense.setCost(cost);
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
                expense.setCost(cost);
                expense.setExpDate(formatter.format(date));
            }
            if (expense.getDescription()!=null) {
                expenseArrayList.add(new Expense(expense.getDescription(), expense.getExpDate(), expense.getCost()));
            }
        }

        return expenseArrayList;
    }
}
