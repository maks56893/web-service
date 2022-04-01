package com.models.yandex;

public class TranslationsDao {
    private String text;

    public TranslationsDao(String text) {
        this.text = text;
    }

    public TranslationsDao() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                '}';
    }
}
