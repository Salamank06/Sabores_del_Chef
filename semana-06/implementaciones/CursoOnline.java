package implementaciones;

import abstractas.Content;
import interfaces.Calificable;
import interfaces.Certificable;
import java.util.ArrayList;
import java.util.List;

public class CursoOnline extends Content implements Calificable, Certificable {
    private String plataforma;
    private boolean accesoVitalicio;
    private int videosIncluidos;
    private List<Integer> calificaciones;
    private List<String> comentarios;
    private int contadorCertificados;
    
    public CursoOnline(String codigo, String nombre, String nivel, int duracionHoras, 
                      double precio, String plataforma, boolean accesoVitalicio, int videosIncluidos) {
        super(codigo, nombre, nivel, duracionHoras, precio);
        this.plataforma = plataforma;
        this.accesoVitalicio = accesoVitalicio;
        this.videosIncluidos = videosIncluidos;
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.contadorCertificados = 0;
    }
    
    public String getPlataforma() {
        return plataforma;
    }
    
    public void setPlataforma(String plataforma) {
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
        this.videosIncluidos = videosIncluidos;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Acceso Vitalicio: " + (accesoVitalicio ? "Sí" : "No"));
        System.out.println("Videos Incluidos: " + videosIncluidos);
        System.out.println("Tipo: Curso Online");
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
        return "Curso Online";
    }
    
    @Override
    public int calcularTiempoPreparacion() {
        return videosIncluidos * 2;
    }
    
    @Override
    public void agregarCalificacion(int estrellas, String comentario) {
        if (estrellas >= 1 && estrellas <= 5) {
            calificaciones.add(estrellas);
            comentarios.add(comentario);
        }
    }
    
    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        int suma = 0;
        for (int cal : calificaciones) {
            suma += cal;
        }
        return (double) suma / calificaciones.size();
    }
    
    @Override
    public int obtenerNumeroCalificaciones() {
        return calificaciones.size();
    }
    
    @Override
    public void mostrarCalificaciones() {
        System.out.println("Calificaciones de " + nombre + ":");
        if (calificaciones.isEmpty()) {
            System.out.println("  Sin calificaciones aún");
        } else {
            System.out.println("  Promedio: " + obtenerPromedioCalificaciones() + " estrellas");
            System.out.println("  Total de calificaciones: " + obtenerNumeroCalificaciones());
        }
    }
    
    @Override
    public boolean cumpleRequisitosCertificacion() {
        return duracionHoras >= 20;
    }
    
    @Override
    public void emitirCertificado(String nombreEstudiante) {
        if (cumpleRequisitosCertificacion()) {
            contadorCertificados++;
            System.out.println("Certificado emitido para: " + nombreEstudiante);
            System.out.println("Curso: " + nombre);
            System.out.println("Número: CERT-ONLINE-" + codigo + "-" + contadorCertificados);
        } else {
            System.out.println("El curso no cumple requisitos mínimos para certificación");
        }
    }
    
    @Override
    public String obtenerNumeroCertificado() {
        return "CERT-ONLINE-" + codigo + "-" + contadorCertificados;
    }
    
    public String obtenerInformacionAcceso() {
        return accesoVitalicio ? "Acceso de por vida" : "Acceso limitado a 6 meses";
    }
}

