package com.demo.models.entity;

import com.demo.models.dto.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
