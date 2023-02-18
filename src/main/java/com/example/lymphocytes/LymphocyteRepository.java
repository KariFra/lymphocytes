package com.example.lymphocytes;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LymphocyteRepository extends MongoRepository<Lymphocyte, Long> {

    Optional<Lymphocyte> findById(Long id);
}
