package concesionaria.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marcas")
public class Marca {

    @Id
    private String ID;

    private String nombre;

    private String concesionariaID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConcesionariaID() {
        return concesionariaID;
    }

    public void setConcesionariaID(String concesionariaID) {
        this.concesionariaID = concesionariaID;
    }
}
