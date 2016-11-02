package concesionaria.controller;

import concesionaria.dto.ConcesionariaDTO;
import concesionaria.services.ConcesionariaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para los endpoints de concesionarias
 */
@RestController
public class ConcesionariaController {

    @Autowired
    ConcesionariaServices concesionariaServices;

    /**
     * -------------------------------------------------------------------------
     * METODO QUE DEVUELVE EL LISTADO DE CONCESIONARIAS EN FORMATO JSON
     * -------------------------------------------------------------------------
     */
    @RequestMapping(method = RequestMethod.GET, value = "/concesionarias")
    @ResponseStatus(HttpStatus.OK)
    public List<ConcesionariaDTO> getConcesionarias() {
        return concesionariaServices.getConcesionarias();
    }


    /**
     * -------------------------------------------------------------------------
     * METODO QUE DEVUELVE UNA CONCESIONARIA EN FORMATO JSON
     * -------------------------------------------------------------------------
     */
    @RequestMapping(method = RequestMethod.GET, value = "/concesionarias/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public ConcesionariaDTO getConcesionaria(@PathVariable(value = "nombre") String nombre) {
        return concesionariaServices.getConcesionaria(nombre);
    }


    /**
     * -------------------------------------------------------------------------
     * METODO QUE CREA UNA CONCESIONARIA A PARTIR DE UN JSON
     * EJEMPLO:
     *   {
     *      "nombre": "yacopini",
     *      "direccion": "san martin 12345",
     *      "telefono": "123123123",
     *      "marcas": ["ford","bmw","mercedes"]
     *   }
     * -------------------------------------------------------------------------
     */
    @RequestMapping(method = RequestMethod.POST, value = "/concesionarias")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ConcesionariaDTO dto) {
        concesionariaServices.createConcesionaria(dto);
    }

    /**
     * -------------------------------------------------------------------------
     * METODO QUE ACTUALIZA UNA CONCESIONARIA A PARTIR DE UN JSON
     *  EJEMPLO:
     *   {
     *      "nombre": "yacopini",
     *      "direccion": "san martin 12345",
     *      "telefono": "123123123",
     *      "marcas": ["ford","bmw","mercedes"]
     *   }
     * -------------------------------------------------------------------------
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/concesionarias/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public void updateConcesionaria(@PathVariable(value = "nombre") String nombre, @RequestBody ConcesionariaDTO dto) {
        concesionariaServices.updateConcesionaria(nombre, dto);
    }

    /**
     * -------------------------------------------------------------------------
     * METODO QUE BORRA UNA CONCESIONARIA A PARTIR DEL NOMBRE EN EL PATH
     * -------------------------------------------------------------------------
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/concesionarias/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public void updateConcesionaria(@PathVariable(value = "nombre") String nombre) {
        concesionariaServices.deleteConcesionaria(nombre);
    }
}
