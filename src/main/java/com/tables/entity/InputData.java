package com.tables.entity;

import javax.persistence.*;

@Entity
@Table(name = "input_data")
public class InputData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "source_lang")
    private String sourceLang;
    @Column(name = "target_lang")
    private String targetLang;
    private String text;
    @Column(name = "query_datetime")
    private String queryDatetime;
    @Column(name = "request_ip")
    private String requestIp;

    public InputData(long id, String sourceLang, String targetLang, String text, String queryDatetime, String requestIp) {
        this.id = id;
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
        this.text = text;
        this.queryDatetime = queryDatetime;
        this.requestIp = requestIp;
    }

    public InputData() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String source_lang) {
        this.sourceLang = source_lang;
    }

    public String getTargetLang() {
        return targetLang;
    }

    public void setTargetLang(String target_lang) {
        this.targetLang = target_lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQueryDatetime() {
        return queryDatetime;
    }

    public void setQueryDatetime(String query_datetime) {
        this.queryDatetime = query_datetime;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String request_ip) {
        this.requestIp = request_ip;
    }
}
