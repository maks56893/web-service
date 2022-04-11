package com.tables.entity;

import javax.persistence.*;

@Entity
@Table(name = "translated_data")
public class TranslatedData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "query_id")
    private String queryId;
    private String text;

    public TranslatedData(long id, String queryId, String text) {
        this.id = id;
        this.queryId = queryId;
        this.text = text;
    }

    public TranslatedData() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
