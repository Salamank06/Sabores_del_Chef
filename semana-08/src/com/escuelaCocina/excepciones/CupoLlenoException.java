package com.escuelaCocina.excepciones;

public class CupoLlenoException extends Exception {
    
    public CupoLlenoException(String mensaje) {
        super(mensaje);
    }
    
    public CupoLlenoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

