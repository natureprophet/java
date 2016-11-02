package com.simon.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document
public class Auto {

    @Id
    private String id;

    @NotNull
    private String nombre;

    @NotNull
    private int precio;

    @NotNull
    private String descripcion;

}
