package com.SplitEasier.spliteasier.model;
import org.springframework.data.annotation.Id;

import org.springframework.data.relational.core.mapping.Table;
import java.util.UUID;

@Table("DOCUMENT")
public class Document {

    @Id
    private String id;

    private String name;
    private String path;


    private String currDt;

    public Document() {
    }

    public Document(String name, String path, String currDt) {
        this.name = name;
        this.path = path;
        this.id = UUID.randomUUID().toString();
        this.currDt = currDt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCurrDt() {
        return currDt;
    }

    public void setCurrDt(String currDt) {
        this.currDt = currDt;
    }
}
