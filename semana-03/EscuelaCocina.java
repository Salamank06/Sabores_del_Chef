import java.util.ArrayList;

public class EscuelaCocina {
    private String nombre;
    private String ubicacion;
    private ArrayList<CookingCourse> cursos;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Chef> chefs;
    private ArrayList<Inscripcion> inscripciones;
    
    public EscuelaCocina(String nombre, String ubicacion) {
        setNombre(nombre);
        setUbicacion(ubicacion);
        this.cursos = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.chefs = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }
    
    public EscuelaCocina(String nombre) {
        this(nombre, "Sin ubicación");
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (!validarNombre(nombre)) {
            throw new IllegalArgumentException("Nombre inválido: no puede ser nulo ni vacío");
        }
        this.nombre = nombre;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        if (ubicacion == null) {
            throw new IllegalArgumentException("Ubicación no puede ser nula");
        }
        this.ubicacion = ubicacion;
    }
    
    public void agregarCurso(CookingCourse curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso no puede ser nulo");
        }
        cursos.add(curso);
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException("Estudiante no puede ser nulo");
        }
        estudiantes.add(estudiante);
    }
    
    public void agregarChef(Chef chef) {
        if (chef == null) {
            throw new IllegalArgumentException("Chef no puede ser nulo");
        }
        chefs.add(chef);
    }
    
    public void agregarInscripcion(Inscripcion inscripcion) {
        if (inscripcion == null) {
            throw new IllegalArgumentException("Inscripción no puede ser nula");
        }
        inscripciones.add(inscripcion);
    }
    
    public void mostrarTodosCursos() {
        System.out.println("\n=== Cursos Disponibles ===");
        for (CookingCourse curso : cursos) {
            curso.showInfo();
            System.out.println("---");
        }
    }
    
    public void mostrarTodosEstudiantes() {
        System.out.println("\n=== Estudiantes Registrados ===");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.obtenerInformacion());
        }
    }
    
    public void mostrarTodosChefs() {
        System.out.println("\n=== Chefs Instructores ===");
        for (Chef chef : chefs) {
            System.out.println(chef.obtenerInformacion());
        }
    }
    
    public void mostrarTodasInscripciones() {
        System.out.println("\n=== Inscripciones ===");
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println(inscripcion.obtenerResumen());
        }
    }
    
    public int contarCursos() {
        return cursos.size();
    }
    
    public int contarEstudiantes() {
        return estudiantes.size();
    }
    
    public int contarChefs() {
        return chefs.size();
    }
    
    public int contarInscripciones() {
        return inscripciones.size();
    }
    
    public double calcularIngresosTotales() {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            if ("Activa".equals(inscripcion.getEstado())) {
                total += inscripcion.calcularTotal();
            }
        }
        return total;
    }
    
    private boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
}

