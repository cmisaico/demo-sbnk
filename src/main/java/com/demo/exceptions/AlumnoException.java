package com.demo.exceptions;

public class AlumnoException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Usuario no existe en la base de datos";
    }
}
