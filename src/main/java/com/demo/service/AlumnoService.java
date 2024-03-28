package com.demo.service;

import com.demo.models.dto.AlumnoRequest;
import com.demo.models.dto.AlumnoResponse;
import com.demo.models.dto.Estado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoService {
    public Mono<Void> agregar(AlumnoRequest alumnoRequest);
    public Flux<AlumnoResponse> listarTodo();

    public Flux<AlumnoResponse> listarPorEstado(Estado estado);

    public Mono<Void> eliminar(Long id);

    public Mono<Void> actualizar(AlumnoRequest alumnoRequest);

}
