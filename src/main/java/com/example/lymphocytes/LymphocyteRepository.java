package com.example.lymphocytes;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LymphocyteRepository extends MongoRepository<Lymphocyte, String> {

    List<Lymphocyte> findById(Long id);

    List<Lymphocyte> findByType(String type);

    List<Lymphocyte> findByIdentifiedInvader(boolean identifiedInvader);
}
