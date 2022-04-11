package com.tables.dao.impl;

import com.tables.dao.TranslatedDao;
import com.tables.repositories.TranslatedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslatedDaoImpl implements TranslatedDao {
    @Autowired
    TranslatedRepo translatedRepo;

    @Override
    public int insertTranslatedData(long inputId, String text) {
        return translatedRepo.insertData(inputId, text);
    }

    @Override
    public List<String> getAllTextById(long id) {
        return translatedRepo.getTextById(id);
    }
}
