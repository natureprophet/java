package concesionaria.services;

import concesionaria.dto.ConcesionariaDTO;
import concesionaria.models.Concesionaria;
import concesionaria.models.Marca;
import concesionaria.repository.ConcesionariaRepository;
import concesionaria.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Servicio para gestionar todas las operaciones del recurso concesionaria.
 */
@Service
public class ConcesionariaServices {

    @Autowired
    ConcesionariaRepository concesionariaRepository;

    @Autowired
    MarcaRepository marcaRepository;

    /**
     * Metodo para obtener todas las concesionarias en formato DTO
     */
    public List<ConcesionariaDTO> getConcesionarias() {
        List<Concesionaria> concesionarias = concesionariaRepository.findAll();

        List<ConcesionariaDTO> dtoList = new ArrayList<>();

        for (Concesionaria concesionaria: concesionarias) {
            ConcesionariaDTO dto = new ConcesionariaDTO();
            dto.setNombre(concesionaria.getNombre());
            dto.setDireccion(concesionaria.getDireccion());
            dto.setTelefono(concesionaria.getTelefono());

            List<Marca> marcasDeLaConcesionaria = marcaRepository.findByConcesionariaID(concesionaria.getID());
            for (Marca marca: marcasDeLaConcesionaria) {
                dto.getMarcas().add(marca.getNombre());
            }

            dtoList.add(dto);
        }

        return dtoList;
    }

    /**
     * Metodo para obtener una concesionaria en formato DTO
     */
    public ConcesionariaDTO getConcesionaria(String nombre) {
        Concesionaria concesionaria = concesionariaRepository.findByNombre(nombre);

        ConcesionariaDTO dto = new ConcesionariaDTO();
        dto.setNombre(concesionaria.getNombre());
        dto.setDireccion(concesionaria.getDireccion());
        dto.setTelefono(concesionaria.getTelefono());

        List<Marca> marcasDeLaConcesionaria = marcaRepository.findByConcesionariaID(concesionaria.getID());
        for (Marca marca: marcasDeLaConcesionaria) {
            dto.getMarcas().add(marca.getNombre());
        }

        return dto;
    }

    /**
     * Metodo para crear una concesionaria y sus marcas a partir de un DTO
     */
    public void createConcesionaria(ConcesionariaDTO dto) {
        Concesionaria concesionaria = new Concesionaria();
        concesionaria.setID(UUID.randomUUID().toString());
        concesionaria.setNombre(dto.getNombre());
        concesionaria.setDireccion(dto.getDireccion());
        concesionaria.setTelefono(dto.getTelefono());
        concesionaria = concesionariaRepository.save(concesionaria);

        for (String nombreMarca: dto.getMarcas()) {
            Marca marca = new Marca();
            marca.setID(UUID.randomUUID().toString());
            marca.setNombre(nombreMarca);
            marca.setConcesionariaID(concesionaria.getID());
            marcaRepository.save(marca);
        }
    }


    /**
     * Metodo para actualizar una concesionaria y sus marcas a partir de un DTO y el nombre actual
     */
    public void updateConcesionaria(String nombre, ConcesionariaDTO dto) {
        Concesionaria concesionaria = concesionariaRepository.findByNombre(nombre);
        concesionaria.setNombre(dto.getNombre());
        concesionaria.setTelefono(dto.getTelefono());
        concesionaria.setDireccion(dto.getDireccion());
        concesionariaRepository.save(concesionaria);
    }

    /**
     * Metodo para eliminar una concesionaria y sus marcas a partir de su nombre
     */
    public void deleteConcesionaria(String nombre) {
        Concesionaria concesionaria = concesionariaRepository.findByNombre(nombre);
        marcaRepository.deleteByConcesionariaID(concesionaria.getID());
        concesionariaRepository.delete(concesionaria);
    }
}
