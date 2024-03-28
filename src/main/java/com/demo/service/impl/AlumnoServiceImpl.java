package com.demo.service.impl;

import com.demo.models.dto.AlumnoRequest;
import com.demo.models.dto.AlumnoResponse;
import com.demo.models.dto.Estado;
import com.demo.models.entity.AlumnoEntidad;
import com.demo.common.exception.AlumnoException;
import com.demo.mapper.AlumnoMapper;
import com.demo.repository.AlumnoRepository;
import com.demo.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Override
    public Mono<Void> agregar(AlumnoRequest alumnoRequest) {
        AlumnoEntidad alumnoEntidad = AlumnoMapper
                .INSTANCE.alumnoRequestToAlumnoEntidad(alumnoRequest);
        return alumnoRepository.guardar(alumnoEntidad);
    }

    @Override
    public Flux<AlumnoResponse> listarTodo() {
        return alumnoRepository.listarTodo()
                .map(AlumnoMapper.INSTANCE::alumnoEntidadToAlumnoResponse);
    }

    @Override
    public Flux<AlumnoResponse> listarPorEstado(Estado estado) {
        return alumnoRepository.listarPorEstado(estado)
                                .map(AlumnoMapper.INSTANCE::alumnoEntidadToAlumnoResponse);
    }

    @Override
    public Mono<Void> eliminar(Long id) {
        return alumnoRepository.eliminar(id);
    }

    @Override
    public Mono<Void> actualizar(AlumnoRequest alumnoRequest) {
        return alumnoRepository.buscar(alumnoRequest.getId())
            .doOnNext(alumnoEntidad -> AlumnoMapper.INSTANCE.updateAlumno(alumnoRequest, alumnoEntidad))
                .map(alumnoRepository::actualizar)
                .switchIfEmpty(Mono.error(new AlumnoException()))
                .then();
    }
}
