package com.models.yandex;

import java.util.List;

public class YandxTranslateDao {
    private List<TranslationsDao> translations;

    public YandxTranslateDao(List<TranslationsDao> translations) {
        this.translations = translations;
    }

    public YandxTranslateDao() {
    }

    public List<TranslationsDao> getTranslations() {
        return translations;
    }

    public void setTranslations(List<TranslationsDao> translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return "YnxTranslateDao{" +
                "translations=" + translations +
                '}';
    }
}
