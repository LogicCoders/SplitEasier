package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Document;
import com.SplitEasier.spliteasier.repository.DocumentRepository;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Component
public class DocumentServices {

    private final DocumentRepository documentRepository;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public DocumentServices(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    public Document createdoc(String name, String path){
        Document newdoc = new Document(name, path);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        newdoc.setCurrDt(formatter.format(date));
        return documentRepository.save(newdoc);
    }
    public String getIdByCurrDt(String date){
        Optional<Document> optionalDocument = documentRepository.findByCurrDt(date);
        Document document = optionalDocument.orElseThrow();
        return document.getId();
    }
    public String getPath(String date){
        Optional<Document> optionalDocument = documentRepository.findByCurrDt(date);
        Document document = optionalDocument.orElseThrow();
        return document.getPath();
    }
    public String getName(String path){
        Optional<Document> optionalDocument = documentRepository.findByPath(path);
        Document document = optionalDocument.orElseThrow();
        return document.getName();
    }

}
