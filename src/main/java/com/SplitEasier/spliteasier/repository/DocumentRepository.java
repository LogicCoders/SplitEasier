package com.SplitEasier.spliteasier.repository;

import com.SplitEasier.spliteasier.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface DocumentRepository extends CrudRepository<Document, UUID> {

    Optional<Document> findByCurrDt(String date);
    Optional<Document> findByPath(String path);
}
