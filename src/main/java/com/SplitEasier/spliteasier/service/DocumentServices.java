package com.SplitEasier.spliteasier.service;

import com.SplitEasier.spliteasier.model.Document;
import com.SplitEasier.spliteasier.repository.DocumentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
public class DocumentServices {

    private final DocumentRepository documentRepository;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public DocumentServices(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    @Transactional
    public Document createdoc(String name, String path){
        Document newdoc = new Document();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        newdoc.setCurrDt(formatter.format(date));
        newdoc.setName(name);
        newdoc.setPath(path);
        return documentRepository.save(newdoc);
    }

    @Transactional
    public String getIdByCurrDt(String date){
        Optional<Document> optionalDocument = documentRepository.findByCurrDt(date);
        Document document = optionalDocument.get();
        return document.getId();
    }

    @Transactional
    public String getPath(String date){
        Optional<Document> optionalDocument = documentRepository.findByCurrDt(date);
        Document document = optionalDocument.get();
        return document.getPath();
    }
    @Transactional
    public String getName(String path){
        Optional<Document> optionalDocument = documentRepository.findByPath(path);
        Document document = optionalDocument.get();
        return document.getName();
    }


}
