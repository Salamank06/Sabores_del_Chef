package com.escuelaCocina.modelo;

public class CursoPresencial extends Content {
    private Chef chefInstructor;
    private int cuposDisponibles;
    private int cuposMaximos;
    private String sala;
    
    public CursoPresencial(String codigo, String nombre, String nivel, int duracionHoras, 
                          double precio, Chef chefInstructor, int cuposMaximos, String sala) {
        super(codigo, nombre, nivel, duracionHoras, precio);
        setChefInstructor(chefInstructor);
        setCuposMaximos(cuposMaximos);
        setSala(sala);
        this.cuposDisponibles = cuposMaximos;
    }
    
    public Chef getChefInstructor() {
        return chefInstructor;
    }
    
    public void setChefInstructor(Chef chefInstructor) {
        if (chefInstructor == null) {
            throw new IllegalArgumentException("Chef instructor no puede ser nulo");
        }
        this.chefInstructor = chefInstructor;
    }
    
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }
    
    public int getCuposMaximos() {
        return cuposMaximos;
    }
    
    public void setCuposMaximos(int cuposMaximos) {
        if (cuposMaximos <= 0) {
            throw new IllegalArgumentException("Cupos máximos debe ser mayor a 0");
        }
        this.cuposMaximos = cuposMaximos;
    }
    
    public String getSala() {
        return sala;
    }
    
    public void setSala(String sala) {
        if (sala == null || sala.trim().isEmpty()) {
            throw new IllegalArgumentException("Sala no puede ser nula o vacía");
        }
        this.sala = sala;
    }
    
    public boolean hayCupos() {
        return cuposDisponibles > 0;
    }
    
    public void reservarCupo() {
        if (cuposDisponibles <= 0) {
            throw new IllegalStateException("No hay cupos disponibles");
        }
        cuposDisponibles--;
    }
    
    @Override
    public double calcularPrecioFinal() {
        if (chefInstructor != null && chefInstructor.esExperto()) {
            return this.precio * 1.25;
        }
        return this.precio;
    }
    
    @Override
    public String obtenerTipo() {
        return "CursoPresencial";
    }
}


