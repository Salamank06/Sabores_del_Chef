package implementaciones;

import abstractas.Content;
import interfaces.Reservable;
import java.util.ArrayList;
import java.util.List;

public class Taller extends Content implements Reservable {
    private Chef chefInstructor;
    private String temaEspecifico;
    private boolean incluyeMateriales;
    private int maxParticipantes;
    private List<String> reservas;
    private int contadorReservas;
    
    public Taller(String codigo, String nombre, String nivel, int duracionHoras, 
                 double precio, Chef chefInstructor, String temaEspecifico, 
                 boolean incluyeMateriales, int maxParticipantes) {
        super(codigo, nombre, nivel, duracionHoras, precio);
        this.chefInstructor = chefInstructor;
        this.temaEspecifico = temaEspecifico;
        this.incluyeMateriales = incluyeMateriales;
        this.maxParticipantes = maxParticipantes;
        this.reservas = new ArrayList<>();
        this.contadorReservas = 0;
    }
    
    public Chef getChefInstructor() {
        return chefInstructor;
    }
    
    public void setChefInstructor(Chef chefInstructor) {
        this.chefInstructor = chefInstructor;
    }
    
    public String getTemaEspecifico() {
        return temaEspecifico;
    }
    
    public void setTemaEspecifico(String temaEspecifico) {
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
        this.maxParticipantes = maxParticipantes;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        if (chefInstructor != null) {
            System.out.println("Chef Instructor: " + chefInstructor.getNombre());
        }
        System.out.println("Tema Específico: " + temaEspecifico);
        System.out.println("Incluye Materiales: " + (incluyeMateriales ? "Sí" : "No"));
        System.out.println("Máx. Participantes: " + maxParticipantes);
        System.out.println("Tipo: Taller");
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
    
    @Override
    public int calcularTiempoPreparacion() {
        return duracionHoras * 4;
    }
    
    @Override
    public boolean verificarDisponibilidad(String fecha) {
        return reservas.size() < maxParticipantes;
    }
    
    @Override
    public void realizarReserva(String nombreEstudiante, String fecha) {
        if (verificarDisponibilidad(fecha)) {
            contadorReservas++;
            String codigoReserva = "TAL-" + codigo + "-" + contadorReservas;
            reservas.add(codigoReserva + ":" + nombreEstudiante + ":" + fecha);
            System.out.println("Reserva realizada exitosamente para el taller");
            System.out.println("Estudiante: " + nombreEstudiante);
            System.out.println("Código de reserva: " + codigoReserva);
        } else {
            System.out.println("Taller lleno, no hay cupos disponibles");
        }
    }
    
    @Override
    public void cancelarReserva(String codigoReserva) {
        boolean encontrada = false;
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).startsWith(codigoReserva)) {
                reservas.remove(i);
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
            return "TAL-" + codigo + "-" + contadorReservas;
        }
        return "SIN-RESERVA";
    }
    
    public double calcularPrecioPorPersona(int participantes) {
        if (participantes >= maxParticipantes) {
            return calcularPrecioFinal() * 0.9;
        }
        return calcularPrecioFinal();
    }
    
    public int getCuposDisponibles() {
        return maxParticipantes - reservas.size();
    }
}


