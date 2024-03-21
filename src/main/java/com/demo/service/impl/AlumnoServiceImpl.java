package com.demo.service.impl;

import com.demo.dto.AlumnoRequest;
import com.demo.dto.AlumnoResponse;
import com.demo.dto.Estado;
import com.demo.entity.AlumnoEntidad;
import com.demo.mapper.AlumnoMapper;
import com.demo.repository.AlumnoRepository;
import com.demo.service.AlumnoService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@Service
public class AlumnoServiceImpl implements AlumnoService {
//    private AlumnoH2Repository alumnoH2Repository;
//
//    private AlumnoServiceImpl(AlumnoH2Repository alumnoRepository) {
//        this.alumnoH2Repository = alumnoRepository;
//    }
    private AlumnoRepository alumnoRepository;

    private AlumnoMapper alumnoMapper;

    private AlumnoServiceImpl(AlumnoMapper alumnoMapper, AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    @Override
    public Mono<Void> agregar(AlumnoRequest alumnoRequest) {
//        AlumnoEntidad alumnoEntidad = AlumnoEntidad.builder().id()
//                        .nombre(alumnoRequest.getNombre())
//                        .apellido(alumnoRequest.getApellido())
//                        .edad(alumnoRequest.getEdad())
//                        .estado(alumnoRequest.getEstado()).build();

        AlumnoEntidad alumnoEntidad = alumnoMapper.alumnoRequestToAlumnoEntidad(alumnoRequest);
        return alumnoRepository.guardar(alumnoEntidad);
    }

    @Override
    public Flux<AlumnoResponse> listar(Estado estado) {
        return alumnoRepository.listarPorEstado(estado)
                                .map(alumnoMapper::alumnoEntidadToAlumnoResponse);

//        Stream<AlumnoResponse> stream = alumnoRepository.listar().toStream().map(alumno -> {
//            return new AlumnoResponse(alumno.getId(), alumno.getNombre(), alumno.getApellido(), alumno.getEstado(), alumno.getEdad());
//        });
//        long contar = stream.count();
//        return Flux.fromStream(stream);
    }
}
