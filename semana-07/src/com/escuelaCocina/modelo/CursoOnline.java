package com.escuelaCocina.modelo;

public class CursoOnline extends Content {
    private String plataforma;
    private boolean accesoVitalicio;
    private int videosIncluidos;
    
    public CursoOnline(String codigo, String nombre, String nivel, int duracionHoras, 
                      double precio, String plataforma, boolean accesoVitalicio, int videosIncluidos) {
        super(codigo, nombre, nivel, duracionHoras, precio);
        setPlataforma(plataforma);
        setVideosIncluidos(videosIncluidos);
        this.accesoVitalicio = accesoVitalicio;
    }
    
    public String getPlataforma() {
        return plataforma;
    }
    
    public void setPlataforma(String plataforma) {
        if (plataforma == null || plataforma.trim().isEmpty()) {
            throw new IllegalArgumentException("Plataforma no puede ser nula o vacía");
        }
        this.plataforma = plataforma;
    }
    
    public boolean isAccesoVitalicio() {
        return accesoVitalicio;
    }
    
    public void setAccesoVitalicio(boolean accesoVitalicio) {
        this.accesoVitalicio = accesoVitalicio;
    }
    
    public int getVideosIncluidos() {
        return videosIncluidos;
    }
    
    public void setVideosIncluidos(int videosIncluidos) {
        if (videosIncluidos <= 0) {
            throw new IllegalArgumentException("Número de videos debe ser mayor a 0");
        }
        this.videosIncluidos = videosIncluidos;
    }
    
    @Override
    public double calcularPrecioFinal() {
        if (accesoVitalicio) {
            return this.precio * 1.2;
        }
        return this.precio;
    }
    
    @Override
    public String obtenerTipo() {
        return "CursoOnline";
    }
}


