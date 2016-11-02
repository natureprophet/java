package com.simon.data.service;

import com.simon.data.domain.Marca;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarcaRepository extends MongoRepository<Marca, String> {
}
