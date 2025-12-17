package com.escuelaCocina.excepciones;

public class CursoInvalidoException extends Exception {
    
    public CursoInvalidoException(String mensaje) {
        super(mensaje);
    }
    
    public CursoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}


