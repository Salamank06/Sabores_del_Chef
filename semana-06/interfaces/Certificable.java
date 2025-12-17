package interfaces;

public interface Certificable {
    boolean cumpleRequisitosCertificacion();
    void emitirCertificado(String nombreEstudiante);
    String obtenerNumeroCertificado();
}

