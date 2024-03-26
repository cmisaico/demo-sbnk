package com.demo.controller;


import com.demo.dto.AlumnoRequest;
import com.demo.dto.AlumnoResponse;
import com.demo.dto.Estado;
import com.demo.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/alumno")
@Validated
public class AlumnoController {
    private AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> guardar(
            @Valid @RequestBody AlumnoRequest alumnoRequest) {
        alumnoService.agregar(alumnoRequest);
        return Mono.empty();
    }

    @GetMapping(value = {"/listar", "/listar/{estado}"})
    @ResponseStatus(HttpStatus.OK)
    public Flux<AlumnoResponse> listarAlumnos(@PathVariable(required = false) Estado estado) {
        if(estado != null) {
            return alumnoService.listarPorEstado(estado);
        } else {
            return alumnoService.listarTodo();
        }
    }

    @PutMapping("/actualizar")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> actualizarAlumno(@Valid @RequestBody AlumnoRequest alumnoRequest) {
        return alumnoService.actualizar(alumnoRequest);
    }

}
