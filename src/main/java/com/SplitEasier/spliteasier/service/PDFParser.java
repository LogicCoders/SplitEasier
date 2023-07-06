package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Expense;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PDFParser {
    private String content;
    private final ArrayList<Expense> expenseArrayList = new ArrayList<>();
    private final Logger logger = LoggerFactory.getLogger(PDFParser.class);

    public PDFParser loadAndSetContent(File file) throws IOException {
        PDDocument pdDocument = PDDocument.load(file);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        content = pdfTextStripper.getText(pdDocument);
        return this;
    }

    public ArrayList<Expense> createExpenseList() {
        String expenseDetails = getExpenseDetails();
        String[] lines = expenseDetails.split("\n");

        Arrays.stream(lines).forEach((line) -> {
            String vendorName = "";
            String pattern = vendorName + "\\D*(\\d+\\.\\d+)";
            if (line.contains("DUNNES")) {
                vendorName = "DUNNES";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                String cost = matcher.group(1);
                expenseArrayList.add(new Expense(vendorName, formatter.format(date), cost));
            } else if (line.contains("TESCO")) {
                vendorName = "TESCO";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                String cost = matcher.group(1);
                expenseArrayList.add(new Expense(vendorName, formatter.format(date), cost));
            } else if (line.contains("ALDI")) {
                vendorName = "ALDI";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                String cost = matcher.group(1);
                expenseArrayList.add(new Expense(vendorName, formatter.format(date), cost));
            } else if (line.contains("BORD GAIS")) {
                vendorName = "BORD GAIS";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                String cost = matcher.group(1);
                expenseArrayList.add(new Expense(vendorName, formatter.format(date), cost));
            } else if (line.contains("DELIVEROO")) {
                vendorName = "DELIVEROO";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                String cost = matcher.group(1);
                expenseArrayList.add(new Expense(vendorName, formatter.format(date), cost));
            } else if (line.contains("LIDL")) {
                vendorName = "LIDL";
                Pattern compiledPattern = Pattern.compile(pattern);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Matcher matcher = compiledPattern.matcher(line);
                String cost = matcher.group(1);
                expenseArrayList.add(new Expense(vendorName, formatter.format(date), cost));
            }
        });
        logger.debug("Expense list: {}", expenseArrayList);
        return expenseArrayList;
    }
    private String getExpenseDetails() {
        int startingIndex = content.indexOf("Date Details Debit € Credit € Balance €\n");
        int endingIndex = content.indexOf("This is an eligible deposit under the Deposit Guarantee Scheme. For more information, ");
        return content.substring(startingIndex + 40, endingIndex);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Expense> getExpenseArrayList() {
        return expenseArrayList;
    }
}
