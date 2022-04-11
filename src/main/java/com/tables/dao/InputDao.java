package com.tables.dao;

import com.models.service.ToTranslateRequestModel;

import javax.servlet.http.HttpServletRequest;

public interface InputDao {
    long getIdByText(String text);
    int insertData(ToTranslateRequestModel inputData, HttpServletRequest httpServletRequest);
}
