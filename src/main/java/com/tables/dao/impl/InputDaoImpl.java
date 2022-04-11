package com.tables.dao.impl;

import com.models.service.ToTranslateRequestModel;
import com.tables.repositories.InputRepo;
import com.tables.dao.InputDao;
import com.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class InputDaoImpl implements InputDao {

    @Autowired
    private InputRepo inputRepo;


    @Override
    public long getIdByText(String text) {
        List<Long> sortedListOfEntries = inputRepo.findIdByText(text, Sort.by(Sort.Direction.DESC, "queryDatetime"));
        return sortedListOfEntries.get(0);
    }

    @Override
    public int insertData(ToTranslateRequestModel data, HttpServletRequest httpServletRequest) {
        return inputRepo.insertInputData(data.getTargetLang(), data.getSourceLang(), data.getText(), HttpUtils.getRequestIP(httpServletRequest));
    }
}
