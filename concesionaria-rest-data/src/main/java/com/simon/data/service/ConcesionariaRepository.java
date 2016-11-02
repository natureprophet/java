package com.simon.data.service;

import com.simon.data.domain.Concesionaria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface ConcesionariaRepository extends MongoRepository<Concesionaria, String> {
    @RestResource
    List<Concesionaria> findByNombre(@Param("nombre") String nombre);
}
