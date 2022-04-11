package com.models.yandex;

import java.util.List;

public class YandxTranslateModel {
    private List<TranslationsModel> translations;

    public YandxTranslateModel(List<TranslationsModel> translations) {
        this.translations = translations;
    }

    public YandxTranslateModel() {
    }

    public List<TranslationsModel> getTranslations() {
        return translations;
    }

    public void setTranslations(List<TranslationsModel> translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return "YnxTranslateDao{" +
                "translations=" + translations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YandxTranslateModel that = (YandxTranslateModel) o;

        return translations.equals(that.translations);
    }

    @Override
    public int hashCode() {
        return translations.hashCode();
    }
}
