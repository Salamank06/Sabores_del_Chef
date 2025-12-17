package interfaces;

public interface Calificable {
    void agregarCalificacion(int estrellas, String comentario);
    double obtenerPromedioCalificaciones();
    int obtenerNumeroCalificaciones();
    void mostrarCalificaciones();
}


