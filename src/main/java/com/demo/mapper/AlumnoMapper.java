package com.demo.mapper;


import com.demo.models.dto.AlumnoRequest;
import com.demo.models.dto.AlumnoResponse;
import com.demo.models.entity.AlumnoEntidad;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);

//    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    AlumnoEntidad alumnoRequestToAlumnoEntidad(AlumnoRequest alumnoRequest);

    AlumnoResponse alumnoEntidadToAlumnoResponse(AlumnoEntidad alumnoEntidad);

    void updateAlumno(AlumnoRequest alumnoRequest, @MappingTarget  AlumnoEntidad alumnoEntidad);

}
