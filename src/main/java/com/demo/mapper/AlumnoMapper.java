package com.demo.mapper;


import com.demo.dto.AlumnoRequest;
import com.demo.dto.AlumnoResponse;
import com.demo.entity.AlumnoEntidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {
//    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    AlumnoEntidad alumnoRequestToAlumnoEntidad(AlumnoRequest alumnoRequest);

    AlumnoResponse alumnoEntidadToAlumnoResponse(AlumnoEntidad alumnoEntidad);

}
