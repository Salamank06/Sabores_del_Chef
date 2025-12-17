import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ESCUELA DE COCINA: SABORES DEL CHEF ===\n");
        System.out.println("=== SEMANA 03: ENCAPSULACIÓN Y CONSTRUCTORES ===\n");
        
        EscuelaCocina escuela = new EscuelaCocina("Sabores del Chef", "Bogotá, Zona T");
        
        System.out.println("--- Demostración de Constructores Sobrecargados ---\n");
        
        Chef chef1 = new Chef("CHEF-001", "María González", "Cocina Colombiana", 15);
        Chef chef2 = new Chef("CHEF-002", "Carlos Ramírez", "Repostería", 8);
        Chef chef3 = new Chef("CHEF-003", "Ana Martínez", "Cocina Internacional", 12);
        Chef chef4 = new Chef("CHEF-004", "Pedro López", "Panadería");
        Chef chef5 = new Chef("Roberto Silva");
        
        System.out.println("Chef creado con constructor completo:");
        System.out.println(chef1.obtenerInformacion());
        System.out.println("\nChef creado con constructor de 3 parámetros:");
        System.out.println(chef4.obtenerInformacion());
        System.out.println("\nChef creado con constructor mínimo:");
        System.out.println(chef5.obtenerInformacion());
        
        escuela.agregarChef(chef1);
        escuela.agregarChef(chef2);
        escuela.agregarChef(chef3);
        escuela.agregarChef(chef4);
        escuela.agregarChef(chef5);
        
        CookingCourse curso1 = new CookingCourse("COOK-001", "Cocina Colombiana", "Básico", chef1, 40, 500000);
        CookingCourse curso2 = new CookingCourse("COOK-002", "Repostería Francesa", "Intermedio", chef2, 60, 750000);
        CookingCourse curso3 = new CookingCourse("COOK-003", "Cocina Italiana", "Avanzado", chef3, 80, 1000000);
        CookingCourse curso4 = new CookingCourse("COOK-004", "Panadería Artesanal", "Básico", 30, 400000.0);
        CookingCourse curso5 = new CookingCourse("COOK-005", "Coctelería Profesional");
        
        System.out.println("\n--- Curso creado con constructor completo ---");
        curso1.showInfo();
        System.out.println("\n--- Curso creado con constructor de 5 parámetros (sin chef) ---");
        curso4.showInfo();
        System.out.println("\n--- Curso creado con constructor mínimo ---");
        curso5.showInfo();
        
        escuela.agregarCurso(curso1);
        escuela.agregarCurso(curso2);
        escuela.agregarCurso(curso3);
        escuela.agregarCurso(curso4);
        escuela.agregarCurso(curso5);
        
        Estudiante estudiante1 = new Estudiante("12345678", "Juan Pérez", "juan@email.com", "3001234567");
        Estudiante estudiante2 = new Estudiante("87654321", "Laura Sánchez", "laura@email.com");
        Estudiante estudiante3 = new Estudiante("11223344", "Pedro Gómez");
        
        System.out.println("\n--- Estudiante creado con constructor completo ---");
        System.out.println(estudiante1.obtenerInformacion());
        System.out.println("\n--- Estudiante creado con constructor de 3 parámetros ---");
        System.out.println(estudiante2.obtenerInformacion());
        System.out.println("\n--- Estudiante creado con constructor mínimo ---");
        System.out.println(estudiante3.obtenerInformacion());
        
        escuela.agregarEstudiante(estudiante1);
        escuela.agregarEstudiante(estudiante2);
        escuela.agregarEstudiante(estudiante3);
        
        Inscripcion inscripcion1 = new Inscripcion(estudiante1, curso1, LocalDate.now());
        Inscripcion inscripcion2 = new Inscripcion(estudiante2, curso2, LocalDate.now());
        Inscripcion inscripcion3 = new Inscripcion(estudiante3, curso3);
        Inscripcion inscripcion4 = new Inscripcion(estudiante1, curso4);
        
        System.out.println("\n--- Inscripción creada con constructor completo ---");
        System.out.println(inscripcion1.obtenerResumen());
        System.out.println("\n--- Inscripción creada con constructor de 2 parámetros (fecha automática) ---");
        System.out.println(inscripcion3.obtenerResumen());
        
        escuela.agregarInscripcion(inscripcion1);
        escuela.agregarInscripcion(inscripcion2);
        escuela.agregarInscripcion(inscripcion3);
        escuela.agregarInscripcion(inscripcion4);
        
        System.out.println("\n=== RESUMEN COMPLETO ===\n");
        escuela.mostrarTodosChefs();
        escuela.mostrarTodosCursos();
        escuela.mostrarTodosEstudiantes();
        escuela.mostrarTodasInscripciones();
        
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total de cursos: " + escuela.contarCursos());
        System.out.println("Total de estudiantes: " + escuela.contarEstudiantes());
        System.out.println("Total de chefs: " + escuela.contarChefs());
        System.out.println("Total de inscripciones: " + escuela.contarInscripciones());
        System.out.println("Ingresos totales: $" + escuela.calcularIngresosTotales());
        
        System.out.println("\n=== VALIDACIONES Y MÉTODOS ===");
        System.out.println("¿Chef 1 es experto? " + chef1.esExperto());
        System.out.println("¿Estudiante 1 tiene email válido? " + estudiante1.tieneEmailValido());
        System.out.println("Descuento del 10% en curso 1: $" + curso1.calcularDescuento(10));
        
        System.out.println("\n=== DEMOSTRACIÓN DE VALIDACIONES ===");
        try {
            chef1.setAñosExperiencia(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Validación exitosa: " + e.getMessage());
        }
        
        try {
            estudiante1.setEmail("emailinvalido");
        } catch (IllegalArgumentException e) {
            System.out.println("Validación exitosa: " + e.getMessage());
        }
        
        try {
            curso1.setPrecio(-1000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validación exitosa: " + e.getMessage());
        }
    }
}
