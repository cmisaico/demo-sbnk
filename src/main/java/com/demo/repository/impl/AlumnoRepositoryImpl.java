package com.demo.repository.impl;

import com.demo.dto.Estado;
import com.demo.entity.AlumnoEntidad;
import com.demo.exception.RegistroException;
import com.demo.repository.AlumnoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository {

    private List<AlumnoEntidad> alumnos;

    public AlumnoRepositoryImpl(){
        this.alumnos = new ArrayList<>();
    }

    @Override
    public Mono<Void> guardar(AlumnoEntidad alumnoEntidad) {
        if(alumnos.stream().noneMatch(alumno -> alumno.getId() == alumnoEntidad.getId())){
            alumnos.add(alumnoEntidad);
        } else {
            throw new RegistroException("El alumno ya existe");
        }
        return Mono.empty();
    }

    @Override
    public Flux<AlumnoEntidad> listarTodo() {
        return Flux.fromIterable(alumnos);
    }

    @Override
    public Mono<AlumnoEntidad> buscar(UUID id) {
        return Mono.justOrEmpty(alumnos.stream()
                .filter(alumno -> alumno.getId().equals(id))
                .findFirst());
    }

    @Override
    public Flux<AlumnoEntidad> listarPorEstado(Estado estado) {
        return Flux.fromStream(alumnos.stream().filter(alumno -> alumno.getEstado().equals(estado)));
    }


}
