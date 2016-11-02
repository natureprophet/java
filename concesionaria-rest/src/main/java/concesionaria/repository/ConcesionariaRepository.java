package concesionaria.repository;

import concesionaria.models.Concesionaria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcesionariaRepository extends MongoRepository<Concesionaria, String> {
    Concesionaria findByNombre(String nombre);
}
