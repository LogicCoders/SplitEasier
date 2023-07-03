package com.SplitEasier.spliteasier.controller;

import com.SplitEasier.spliteasier.model.Document;
import com.SplitEasier.spliteasier.service.PDFParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/document")
public class DocumentController {
    private final PDFParser parser;

    public DocumentController(PDFParser parser) {
        this.parser = parser;
    }

    @GetMapping("/upload")
    public String documentIndex(Model model){
       model.addAttribute("document", new Document());
       return "document/upload";
    }

    @PostMapping("/upload")
    public void processDoc(@RequestParam("file") MultipartFile file, Model model) throws IOException {

       if(file.isEmpty()) {
            throw new NullPointerException("File is empty");
       }

       String originalFinalName = file.getOriginalFilename();
        byte[] fileOutput = file.getBytes();
        File toConvertFile = File.createTempFile(originalFinalName, "_tmp");
        FileOutputStream fileOutputStream = new FileOutputStream(toConvertFile);
        fileOutputStream.write(fileOutput);
        fileOutputStream.close();
        toConvertFile.deleteOnExit();
        parser.loadAndSetContent(toConvertFile).createExpense();
    }
}
