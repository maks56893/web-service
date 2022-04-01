package com.models.service;

public class ToTranslateRequestDao {

    private String text;
    private String sourceLang;
    private String targetLang;

    public ToTranslateRequestDao() {
    }

    public ToTranslateRequestDao(String text, String sourceLang, String targetLang) {
        this.text = text;
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
    }

    public ToTranslateRequestDao(ToTranslateRequestDao request) {
        this.text = request.getText();
        this.sourceLang = request.getSourceLang();
        this.targetLang = request.targetLang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
    }

    public String getTargetLang() {
        return targetLang;
    }

    public void setTargetLang(String targetLang) {
        this.targetLang = targetLang;
    }

    @Override
    public String toString() {
        return "ToTranslateInput{" +
                "text='" + text + '\'' +
                ", sourceLang='" + sourceLang + '\'' +
                ", targetLang='" + targetLang + '\'' +
                '}';
    }
}
