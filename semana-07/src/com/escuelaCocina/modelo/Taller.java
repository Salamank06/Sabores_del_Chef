package com.escuelaCocina.modelo;

public class Taller extends Content {
    private Chef chefInstructor;
    private String temaEspecifico;
    private boolean incluyeMateriales;
    private int maxParticipantes;
    private int participantesActuales;
    
    public Taller(String codigo, String nombre, String nivel, int duracionHoras, 
                 double precio, Chef chefInstructor, String temaEspecifico, 
                 boolean incluyeMateriales, int maxParticipantes) {
        super(codigo, nombre, nivel, duracionHoras, precio);
        setChefInstructor(chefInstructor);
        setTemaEspecifico(temaEspecifico);
        setMaxParticipantes(maxParticipantes);
        this.incluyeMateriales = incluyeMateriales;
        this.participantesActuales = 0;
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
    
    public String getTemaEspecifico() {
        return temaEspecifico;
    }
    
    public void setTemaEspecifico(String temaEspecifico) {
        if (temaEspecifico == null || temaEspecifico.trim().isEmpty()) {
            throw new IllegalArgumentException("Tema específico no puede ser nulo o vacío");
        }
        this.temaEspecifico = temaEspecifico;
    }
    
    public boolean isIncluyeMateriales() {
        return incluyeMateriales;
    }
    
    public void setIncluyeMateriales(boolean incluyeMateriales) {
        this.incluyeMateriales = incluyeMateriales;
    }
    
    public int getMaxParticipantes() {
        return maxParticipantes;
    }
    
    public void setMaxParticipantes(int maxParticipantes) {
        if (maxParticipantes <= 0) {
            throw new IllegalArgumentException("Máximo de participantes debe ser mayor a 0");
        }
        this.maxParticipantes = maxParticipantes;
    }
    
    public int getParticipantesActuales() {
        return participantesActuales;
    }
    
    public boolean hayDisponibilidad() {
        return participantesActuales < maxParticipantes;
    }
    
    public void inscribirParticipante() {
        if (participantesActuales >= maxParticipantes) {
            throw new IllegalStateException("Taller lleno, no hay cupos disponibles");
        }
        participantesActuales++;
    }
    
    @Override
    public double calcularPrecioFinal() {
        double precioFinal = this.precio;
        if (incluyeMateriales) {
            precioFinal *= 1.15;
        }
        if (chefInstructor != null && chefInstructor.esExperto()) {
            precioFinal *= 1.10;
        }
        return precioFinal;
    }
    
    @Override
    public String obtenerTipo() {
        return "Taller";
    }
}


