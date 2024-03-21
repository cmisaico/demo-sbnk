package com.demo.controller;


import com.demo.dto.AlumnoRequest;
import com.demo.dto.AlumnoResponse;
import com.demo.dto.Estado;
import com.demo.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Mono<Void> guardar(
            @Valid @RequestBody AlumnoRequest alumnoRequest) {
        alumnoService.agregar(alumnoRequest);
        return Mono.empty();
    }

    @GetMapping("/listar/{estado}")
    public Flux<AlumnoResponse> listarAlumnos(@PathVariable Estado estado) {
        return alumnoService.listar(estado);
    }

}
