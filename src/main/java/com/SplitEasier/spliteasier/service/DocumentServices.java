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
    public DocumentServices(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    public Document createDoc(String name, String path){
        Document newDocument = new Document(name, path);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        newDocument.setCurrDt(formatter.format(date));
        return documentRepository.save(newDocument);
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
