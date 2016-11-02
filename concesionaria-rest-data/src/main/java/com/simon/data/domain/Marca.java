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
public class Marca {

    @Id
    private String id;

    @NotNull
    private String nombre;

    @NotNull
    private String descripcion;

    @DBRef
    private List<Auto> autos = new ArrayList<Auto>();

}
