package com.tables.repositories;

import com.tables.entity.InputData;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InputRepo extends JpaRepository<InputData, Long> {
    @Query(value = "select id from InputData data where data.text=:text")
    List<Long> findIdByText(@Param("text") String text, Sort sort);


    @Transactional
    @Modifying
    @Query(value = "insert into Input_Data (target_lang, source_lang, text, query_datetime, request_ip) values (:targetLang, :sourceLang, :text, CURRENT_TIMESTAMP, :requestIP)", nativeQuery = true)
    int insertInputData(@Param("targetLang") String targetLang, @Param("sourceLang") String sourceLang,
                         @Param("text") String text, @Param("requestIP") String requestIP);
}
