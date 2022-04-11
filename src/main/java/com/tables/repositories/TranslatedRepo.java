package com.tables.repositories;

import com.tables.entity.TranslatedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TranslatedRepo extends JpaRepository<TranslatedData, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO translated_data (query_id, text) VALUES (:queryId, :text)", nativeQuery = true)
    int insertData(@Param("queryId") long queryId, @Param("text") String text);

    @Query(value = "SELECT text FROM TranslatedData WHERE query_id = :id")
    List<String> getTextById(@Param("id") long id);
}
