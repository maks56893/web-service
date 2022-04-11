package com.controllers;

import com.models.service.ToTranslateRequestModel;
import com.models.service.TranslatedResponseModel;
import com.models.yandex.TranslationsModel;
import com.models.yandex.YandxTranslateModel;
import com.tables.dao.InputDao;
import com.tables.dao.TranslatedDao;
import com.yandx_client_new.YandxTranslationClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class InputControllerWeb {
    @Autowired
    InputDao inputDao;
    @Autowired
    TranslatedDao translatedDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(InputControllerJson.class);

    @PostMapping(value = "/translate", consumes = "application/x-www-form-urlencoded")
    public TranslatedResponseModel translateWeb(ToTranslateRequestModel toTranslateRequestModel, HttpServletRequest httpServletRequest) {
        LOGGER.info("Waiting for request...");
        inputDao.insertData(toTranslateRequestModel, httpServletRequest);
        LOGGER.info("Input data inserted to database");

        LOGGER.info("Translating " + toTranslateRequestModel.toString());
        YandxTranslateModel translationResponse = YandxTranslationClient.translate(toTranslateRequestModel.getSourceLang(), toTranslateRequestModel.getTargetLang(), toTranslateRequestModel.getText());
        LOGGER.info("Response from Yandex API received " + translationResponse.toString());

        long queryId = inputDao.getIdByText(toTranslateRequestModel.getText());
        for(TranslationsModel responseTextEntry : translationResponse.getTranslations()) {
            translatedDao.insertTranslatedData(queryId, responseTextEntry.getText());
        }
        LOGGER.info("Translated data inserted to database");

        List<String> translatedText = translatedDao.getAllTextById(queryId);
        LOGGER.info("Returning response with data: " + translatedText.toString());
        return new TranslatedResponseModel(translatedText);
    }
}
