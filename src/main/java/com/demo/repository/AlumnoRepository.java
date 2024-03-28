package com.demo.repository;

import com.demo.models.dto.Estado;
import com.demo.models.entity.AlumnoEntidad;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoRepository {

    public Mono<Void> guardar(AlumnoEntidad alumnoEntidad);

    public Flux<AlumnoEntidad> listarTodo();

    public Mono<AlumnoEntidad> buscar(Long id);

    public Flux<AlumnoEntidad> listarPorEstado(Estado estado);

    public Mono<Void> eliminar(Long id);

    public Mono<Void> actualizar(AlumnoEntidad alumnoEntidad);

}
