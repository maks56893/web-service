package com.controllers;

import com.models.service.ToTranslateRequestDao;
import com.models.service.TranslatedResponseDao;
import com.utils.HttpUtils;
import com.yandx_client_new.YandxTranslationClient;
import com.models.yandex.TranslationsDao;
import com.models.yandex.YandxTranslateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static configuration.Queries.*;

@RestController
public class InputController {

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @PostMapping(value = "/translate", consumes = "application/json")
    public TranslatedResponseDao translate(@RequestBody ToTranslateRequestDao toTranslateRequestDao, HttpServletRequest httpServletRequest) {

        jdbcTemplate.update(INSERT_INPUT_DATA_QUERY, toTranslateRequestDao.getTargetLang(), toTranslateRequestDao.getSourceLang(), toTranslateRequestDao.getText(), HttpUtils.getRequestIP(httpServletRequest));

        YandxTranslateDao translationResponse = YandxTranslationClient.translate(toTranslateRequestDao.getSourceLang(), toTranslateRequestDao.getTargetLang(), toTranslateRequestDao.getText());

        Integer queryId = jdbcTemplate.queryForObject(GET_ID_QUERY, Integer.class, toTranslateRequestDao.getText());
        for(TranslationsDao responseTextEntry : translationResponse.getTranslations()) {
            jdbcTemplate.update(INSERT_TRANSLATED_DATA_QUERY, queryId, responseTextEntry.getText());
        }

        List<String> translatedText = jdbcTemplate.queryForList(GET_TRANSLATED_TEXT, String.class, queryId);
        return new TranslatedResponseDao(translatedText);
    }

    @PostMapping(value = "/translate", consumes = "application/x-www-form-urlencoded")
    public TranslatedResponseDao translateWeb(ToTranslateRequestDao toTranslateRequestDao, HttpServletRequest httpServletRequest) {

        jdbcTemplate.update(INSERT_INPUT_DATA_QUERY, toTranslateRequestDao.getTargetLang(), toTranslateRequestDao.getSourceLang(), toTranslateRequestDao.getText(), HttpUtils.getRequestIP(httpServletRequest));

        YandxTranslateDao translationResponse = YandxTranslationClient.translate(toTranslateRequestDao.getSourceLang(), toTranslateRequestDao.getTargetLang(), toTranslateRequestDao.getText());

        Integer queryId = jdbcTemplate.queryForObject(GET_ID_QUERY, Integer.class, toTranslateRequestDao.getText());
        for(TranslationsDao responseTextEntry : translationResponse.getTranslations()) {
            jdbcTemplate.update(INSERT_TRANSLATED_DATA_QUERY, queryId, responseTextEntry.getText());
        }

        List<String> translatedText = jdbcTemplate.queryForList(GET_TRANSLATED_TEXT, String.class, queryId);
        return new TranslatedResponseDao(translatedText);
    }
}
