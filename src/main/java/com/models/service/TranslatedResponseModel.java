package com.models.service;

import java.util.List;

public class TranslatedResponseModel {

    private List<String> text;

    public TranslatedResponseModel(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TranslatedResponse{" +
                ", text=" + text +
                '}';
    }
}
