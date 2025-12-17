package implementaciones;

import abstractas.Content;
import interfaces.Reservable;
import interfaces.Calificable;
import interfaces.Certificable;
import java.util.ArrayList;
import java.util.List;

public class CursoPresencial extends Content implements Reservable, Calificable, Certificable {
    private Chef chefInstructor;
    private int cuposDisponibles;
    private String sala;
    private List<String> reservas;
    private List<Integer> calificaciones;
    private List<String> comentarios;
    private int contadorReservas;
    private int contadorCertificados;
    
    public CursoPresencial(String codigo, String nombre, String nivel, int duracionHoras, 
                          double precio, Chef chefInstructor, int cuposDisponibles, String sala) {
        super(codigo, nombre, nivel, duracionHoras, precio);
        this.chefInstructor = chefInstructor;
        this.cuposDisponibles = cuposDisponibles;
        this.sala = sala;
        this.reservas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.contadorReservas = 0;
        this.contadorCertificados = 0;
    }
    
    public Chef getChefInstructor() {
        return chefInstructor;
    }
    
    public void setChefInstructor(Chef chefInstructor) {
        this.chefInstructor = chefInstructor;
    }
    
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }
    
    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }
    
    public String getSala() {
        return sala;
    }
    
    public void setSala(String sala) {
        this.sala = sala;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        if (chefInstructor != null) {
            System.out.println("Chef Instructor: " + chefInstructor.getNombre());
        }
        System.out.println("Cupos Disponibles: " + cuposDisponibles);
        System.out.println("Sala: " + sala);
        System.out.println("Tipo: Curso Presencial");
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
        return "Curso Presencial";
    }
    
    @Override
    public int calcularTiempoPreparacion() {
        return duracionHoras * 3;
    }
    
    @Override
    public boolean verificarDisponibilidad(String fecha) {
        return cuposDisponibles > 0;
    }
    
    @Override
    public void realizarReserva(String nombreEstudiante, String fecha) {
        if (verificarDisponibilidad(fecha)) {
            contadorReservas++;
            String codigoReserva = "RES-" + codigo + "-" + contadorReservas;
            reservas.add(codigoReserva + ":" + nombreEstudiante + ":" + fecha);
            cuposDisponibles--;
            System.out.println("Reserva realizada exitosamente");
            System.out.println("Estudiante: " + nombreEstudiante);
            System.out.println("Código de reserva: " + codigoReserva);
        } else {
            System.out.println("No hay cupos disponibles");
        }
    }
    
    @Override
    public void cancelarReserva(String codigoReserva) {
        boolean encontrada = false;
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).startsWith(codigoReserva)) {
                reservas.remove(i);
                cuposDisponibles++;
                encontrada = true;
                System.out.println("Reserva " + codigoReserva + " cancelada exitosamente");
                break;
            }
        }
        if (!encontrada) {
            System.out.println("Reserva no encontrada");
        }
    }
    
    @Override
    public String obtenerCodigoReserva() {
        if (contadorReservas > 0) {
            return "RES-" + codigo + "-" + contadorReservas;
        }
        return "SIN-RESERVA";
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
        return duracionHoras >= 30 && chefInstructor != null;
    }
    
    @Override
    public void emitirCertificado(String nombreEstudiante) {
        if (cumpleRequisitosCertificacion()) {
            contadorCertificados++;
            System.out.println("Certificado emitido para: " + nombreEstudiante);
            System.out.println("Curso: " + nombre);
            System.out.println("Instructor: " + chefInstructor.getNombre());
            System.out.println("Número: CERT-PRES-" + codigo + "-" + contadorCertificados);
        } else {
            System.out.println("El curso no cumple requisitos mínimos para certificación");
        }
    }
    
    @Override
    public String obtenerNumeroCertificado() {
        return "CERT-PRES-" + codigo + "-" + contadorCertificados;
    }
    
    public boolean hayCupos() {
        return cuposDisponibles > 0;
    }
}

