package interfaces;

public interface Reservable {
    boolean verificarDisponibilidad(String fecha);
    void realizarReserva(String nombreEstudiante, String fecha);
    void cancelarReserva(String codigoReserva);
    String obtenerCodigoReserva();
}


