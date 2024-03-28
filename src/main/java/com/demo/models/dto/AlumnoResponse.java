package com.demo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AlumnoResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Estado estado;
    private int edad;
}
