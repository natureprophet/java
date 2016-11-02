package concesionaria.repository;

import concesionaria.models.Marca;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends MongoRepository<Marca, String> {
    List<Marca> findByConcesionariaID(String concesionariaID);
    Long deleteByConcesionariaID(String concesionariaID);
}
