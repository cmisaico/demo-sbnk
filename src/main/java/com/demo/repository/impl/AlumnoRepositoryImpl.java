package com.demo.repository.impl;

import com.demo.dto.Estado;
import com.demo.entity.Alumno;
import com.demo.entity.AlumnoEntidad;
import com.demo.common.exception.RegistroException;
import com.demo.repository.AlumnoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository {

    private List<AlumnoEntidad> alumnos;

    public AlumnoRepositoryImpl(){
        this.alumnos = new ArrayList<>();
    }

    @Override
    public Mono<Void> guardar(AlumnoEntidad alumnoEntidad) {
        if(alumnos.stream().noneMatch(alumno -> Objects.equals(alumno.getId(), alumnoEntidad.getId()))){
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
    public Mono<AlumnoEntidad> buscar(Long id) {
        return Mono.justOrEmpty(alumnos.stream()
                .filter(alumno -> Objects.equals(alumno.getId(), id))
                .findFirst());
    }

    @Override
    public Flux<AlumnoEntidad> listarPorEstado(Estado estado) {
        return Flux.fromStream(alumnos.stream().filter(alumno -> alumno.getEstado().equals(estado)));
    }

    @Override
    public Mono<Void> eliminar(Long id) {
        alumnos.stream().filter(alumno -> Objects.equals(alumno.getId(), id))
                .findAny()
                .ifPresent(alumnos::remove);
        return Mono.empty();
    }

    @Override
    public Mono<Void> actualizar(AlumnoEntidad alumno) {
        alumnos.stream().filter(alumnoEntidad -> Objects.equals(alumnoEntidad.getId(), alumno.getId()))
                .findAny()
                .ifPresent(alumnoEntidad -> {
                    alumnoEntidad.setNombre(alumno.getNombre());
                    alumnoEntidad.setApellido(alumno.getApellido());
                    alumnoEntidad.setEdad(alumno.getEdad());
                    alumnoEntidad.setEstado(alumno.getEstado());
                });
        return Mono.empty();
    }


}
