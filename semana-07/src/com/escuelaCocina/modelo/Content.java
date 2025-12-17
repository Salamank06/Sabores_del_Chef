package com.escuelaCocina.modelo;

public abstract class Content {
    protected String codigo;
    protected String nombre;
    protected String nivel;
    protected int duracionHoras;
    protected double precio;
    
    public Content(String codigo, String nombre, String nivel, int duracionHoras, double precio) {
        setCodigo(codigo);
        setNombre(nombre);
        setNivel(nivel);
        setDuracionHoras(duracionHoras);
        setPrecio(precio);
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código no puede ser nulo o vacío");
        }
        this.codigo = codigo;
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
    
    public String getNivel() {
        return nivel;
    }
    
    public void setNivel(String nivel) {
        if (nivel == null || nivel.trim().isEmpty()) {
            throw new IllegalArgumentException("Nivel no puede ser nulo o vacío");
        }
        if (!nivel.equals("Básico") && !nivel.equals("Intermedio") && !nivel.equals("Avanzado")) {
            throw new IllegalArgumentException("Nivel debe ser: Básico, Intermedio o Avanzado");
        }
        this.nivel = nivel;
    }
    
    public int getDuracionHoras() {
        return duracionHoras;
    }
    
    public void setDuracionHoras(int duracionHoras) {
        if (duracionHoras <= 0) {
            throw new IllegalArgumentException("Duración debe ser mayor a 0 horas");
        }
        this.duracionHoras = duracionHoras;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio debe ser mayor a 0");
        }
        this.precio = precio;
    }
    
    public abstract double calcularPrecioFinal();
    
    public abstract String obtenerTipo();
    
    @Override
    public String toString() {
        return obtenerTipo() + "{codigo='" + codigo + "', nombre='" + nombre + "', nivel='" + nivel + "', precio=$" + calcularPrecioFinal() + "}";
    }
}

