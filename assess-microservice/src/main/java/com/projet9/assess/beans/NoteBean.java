package com.projet9.assess.beans;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NoteBean {
    private String id;
    private String name;
    private String content;
    private Date date;
    private Long patId;

    public NoteBean() {
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

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }
}
