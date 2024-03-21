package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlumnoRequest {

    @NotNull(message = "{alumno.id.vacio}")
    private Long id;

    @NotBlank(message = "{alumno.nombre.vacio}")
    @Size(min = 3, max = 50, message = "{user.nombre.longitud}")
    private String nombre;

    @NotBlank(message = "{alumno.apellido.vacio}")
    @Size(min = 3, max = 50, message = "{user.apellido.longitud}")
    private String apellido;

    @NotNull(message = "{alumno.estado.nulo}")
    private Estado estado;

    @Min(value = 18, message = "{alumno.edad.menor}")
    @Max(value = 40, message = "{alumno.edad.mayor}")
    private int edad;

}
