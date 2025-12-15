import java.time.LocalDate;

public class Inscripcion {
    private Estudiante estudiante;
    private CookingCourse curso;
    private LocalDate fechaInscripcion;
    private String estado;
    
    public Inscripcion(Estudiante estudiante, CookingCourse curso, LocalDate fechaInscripcion) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = "Activa";
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    public CookingCourse getCurso() {
        return curso;
    }
    
    public void setCurso(CookingCourse curso) {
        this.curso = curso;
    }
    
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String obtenerResumen() {
        return "Inscripción: " + estudiante.getNombre() + " en " + curso.getName() + 
               " | Fecha: " + fechaInscripcion + " | Estado: " + estado;
    }
    
    public double calcularTotal() {
        return curso.getPrecio();
    }
}

