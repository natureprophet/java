package com.simon.data.service;

import com.simon.data.domain.Auto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AutoRepository extends MongoRepository<Auto, String> {
}
