package com.simon.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Concesionaria {

    @Id
    private String id;

    @NotNull
    private String nombre;

    @NotNull
    private String direccion;

    @NotNull
    private String telefono;

    @DBRef
    private List<Marca> marcas = new ArrayList<Marca>();

}
