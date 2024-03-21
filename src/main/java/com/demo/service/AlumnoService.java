package com.demo.service;

import com.demo.dto.AlumnoRequest;
import com.demo.dto.AlumnoResponse;
import com.demo.dto.Estado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoService {
    public Mono<Void> agregar(AlumnoRequest alumnoRequest);
    public Flux<AlumnoResponse> listarTodo();

    public Flux<AlumnoResponse> listarPorEstado(Estado estado);

}
