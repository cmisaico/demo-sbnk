package com.demo.entity;

import com.demo.dto.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AlumnoEntidad {
    private Long id;
    private String nombre;
    private String apellido;
    private Estado estado;
    private int edad;

}
