package com.demo.entity;

import com.demo.dto.Estado;
import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Alumno {

    @Generated
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private Estado estado;
    private int edad;
}
