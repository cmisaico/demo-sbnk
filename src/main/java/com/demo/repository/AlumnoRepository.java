package com.demo.repository;

import com.demo.dto.AlumnoRequest;
import com.demo.dto.AlumnoResponse;
import com.demo.dto.Estado;
import com.demo.entity.AlumnoEntidad;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AlumnoRepository {

    public Mono<Void> guardar(AlumnoEntidad alumnoEntidad);

    public Flux<AlumnoEntidad> listarTodo();

    public Mono<AlumnoEntidad> buscar(UUID id);

    public Flux<AlumnoEntidad> listarPorEstado(Estado estado);

}
