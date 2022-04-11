package com.tables.dao;

import java.util.List;

public interface TranslatedDao {
    int insertTranslatedData(long inputId, String text);
    List<String> getAllTextById(long id);
}
