package com.frontend.frontendMicroservice.beans;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NoteBean {

    private String id;
    private String name;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // grosse erreur 400 à cause d'avoir oublié cette ligne !!!!!
    private Date date;
    public Long patId;

    public NoteBean() {
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
