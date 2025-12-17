package com.escuelaCocina.modelo;

public class Chef {
    private String id;
    private String nombre;
    private String especialidad;
    private int añosExperiencia;
    
    public Chef(String id, String nombre, String especialidad, int añosExperiencia) {
        setId(id);
        setNombre(nombre);
        setEspecialidad(especialidad);
        setAñosExperiencia(añosExperiencia);
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID no puede ser nulo o vacío");
        }
        if (!id.matches("CHEF-\\d{3}")) {
            throw new IllegalArgumentException("ID debe tener formato CHEF-### (ejemplo: CHEF-001)");
        }
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("Especialidad no puede ser nula o vacía");
        }
        this.especialidad = especialidad;
    }
    
    public int getAñosExperiencia() {
        return añosExperiencia;
    }
    
    public void setAñosExperiencia(int añosExperiencia) {
        if (añosExperiencia < 0) {
            throw new IllegalArgumentException("Años de experiencia no puede ser negativo");
        }
        this.añosExperiencia = añosExperiencia;
    }
    
    public boolean esExperto() {
        return añosExperiencia >= 10;
    }
    
    @Override
    public String toString() {
        return "Chef{id='" + id + "', nombre='" + nombre + "', especialidad='" + especialidad + "', experiencia=" + añosExperiencia + " años}";
    }
}

