package com.yandx_client_new;

import com.models.yandex.YandxTranslateModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class YandxTranslationClient {

    private static final String API_KEY = "Api-Key AQVNzeS-_b0_EkQTP3KID2b1tlCvbdrsAOsePbcn";
    static RestTemplate restTemplate = new RestTemplate();

    public static YandxTranslateModel translate(String sourceLang, String targetLang, String text) {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", API_KEY);
        header.setContentType(MediaType.APPLICATION_JSON);

        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("sourceLanguageCode", sourceLang);
        jsonRequest.put("targetLanguageCode", targetLang);
        jsonRequest.put("format", "PLAIN_TEXT");

        String[] splittedInput = text.split(" ");
        JSONArray textToTranslate = new JSONArray();
        for (String inputEntry : splittedInput) {
            textToTranslate.put(inputEntry);
        }

        jsonRequest.put("texts", textToTranslate);

        HttpEntity<String> request = new HttpEntity<>(jsonRequest.toString(), header);

        return restTemplate.postForObject(
                "https://translate.api.cloud.yandex.net/translate/v2/translate", request, YandxTranslateModel.class);
    }
}
