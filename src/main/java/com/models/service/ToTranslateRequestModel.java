package com.models.service;

public class ToTranslateRequestModel {

    private String text;
    private String sourceLang;
    private String targetLang;

    public ToTranslateRequestModel() {
    }

    public ToTranslateRequestModel(String text, String sourceLang, String targetLang) {
        this.text = text;
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
    }

    public ToTranslateRequestModel(ToTranslateRequestModel request) {
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
