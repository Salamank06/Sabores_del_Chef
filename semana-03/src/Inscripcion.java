import java.time.LocalDate;

public class Inscripcion {
    private Estudiante estudiante;
    private CookingCourse curso;
    private LocalDate fechaInscripcion;
    private String estado;
    
    public Inscripcion(Estudiante estudiante, CookingCourse curso, LocalDate fechaInscripcion) {
        setEstudiante(estudiante);
        setCurso(curso);
        setFechaInscripcion(fechaInscripcion);
        this.estado = "Activa";
    }
    
    public Inscripcion(Estudiante estudiante, CookingCourse curso) {
        this(estudiante, curso, LocalDate.now());
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException("Estudiante no puede ser nulo");
        }
        this.estudiante = estudiante;
    }
    
    public CookingCourse getCurso() {
        return curso;
    }
    
    public void setCurso(CookingCourse curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso no puede ser nulo");
        }
        this.curso = curso;
    }
    
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        if (fechaInscripcion == null) {
            throw new IllegalArgumentException("Fecha de inscripción no puede ser nula");
        }
        if (fechaInscripcion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de inscripción no puede ser futura");
        }
        this.fechaInscripcion = fechaInscripcion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        if (!validarEstado(estado)) {
            throw new IllegalArgumentException("Estado inválido: debe ser Activa, Cancelada o Completada");
        }
        this.estado = estado;
    }
    
    public String obtenerResumen() {
        return "Inscripción: " + estudiante.getNombre() + " en " + curso.getName() + 
               " | Fecha: " + fechaInscripcion + " | Estado: " + estado;
    }
    
    public double calcularTotal() {
        return curso.getPrecio();
    }
    
    private boolean validarEstado(String estado) {
        return estado != null && (estado.equals("Activa") || estado.equals("Cancelada") || estado.equals("Completada"));
    }
}

