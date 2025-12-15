import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ESCUELA DE COCINA: SABORES DEL CHEF ===\n");
        
        EscuelaCocina escuela = new EscuelaCocina("Sabores del Chef", "Bogotá, Zona T");
        
        Chef chef1 = new Chef("CHEF-001", "María González", "Cocina Colombiana", 15);
        Chef chef2 = new Chef("CHEF-002", "Carlos Ramírez", "Repostería", 8);
        Chef chef3 = new Chef("CHEF-003", "Ana Martínez", "Cocina Internacional", 12);
        
        escuela.agregarChef(chef1);
        escuela.agregarChef(chef2);
        escuela.agregarChef(chef3);
        
        CookingCourse curso1 = new CookingCourse("COOK-001", "Cocina Colombiana", "Básico", chef1, 40, 500000);
        CookingCourse curso2 = new CookingCourse("COOK-002", "Repostería Francesa", "Intermedio", chef2, 60, 750000);
        CookingCourse curso3 = new CookingCourse("COOK-003", "Cocina Italiana", "Avanzado", chef3, 80, 1000000);
        CookingCourse curso4 = new CookingCourse("COOK-004", "Panadería Artesanal", "Básico", chef2, 30, 400000);
        CookingCourse curso5 = new CookingCourse("COOK-005", "Coctelería Profesional", "Intermedio", chef3, 50, 650000);
        
        escuela.agregarCurso(curso1);
        escuela.agregarCurso(curso2);
        escuela.agregarCurso(curso3);
        escuela.agregarCurso(curso4);
        escuela.agregarCurso(curso5);
        
        Estudiante estudiante1 = new Estudiante("12345678", "Juan Pérez", "juan@email.com", "3001234567");
        Estudiante estudiante2 = new Estudiante("87654321", "Laura Sánchez", "laura@email.com", "3007654321");
        Estudiante estudiante3 = new Estudiante("11223344", "Pedro Gómez", "pedro@email.com", "3001122334");
        
        escuela.agregarEstudiante(estudiante1);
        escuela.agregarEstudiante(estudiante2);
        escuela.agregarEstudiante(estudiante3);
        
        Inscripcion inscripcion1 = new Inscripcion(estudiante1, curso1, LocalDate.now());
        Inscripcion inscripcion2 = new Inscripcion(estudiante2, curso2, LocalDate.now());
        Inscripcion inscripcion3 = new Inscripcion(estudiante3, curso3, LocalDate.now());
        Inscripcion inscripcion4 = new Inscripcion(estudiante1, curso4, LocalDate.now());
        
        escuela.agregarInscripcion(inscripcion1);
        escuela.agregarInscripcion(inscripcion2);
        escuela.agregarInscripcion(inscripcion3);
        escuela.agregarInscripcion(inscripcion4);
        
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
        
        System.out.println("\n=== INFORMACIÓN ADICIONAL ===");
        System.out.println("¿Chef 1 es experto? " + chef1.esExperto());
        System.out.println("¿Estudiante 1 tiene email válido? " + estudiante1.tieneEmailValido());
        System.out.println("Descuento del 10% en curso 1: $" + curso1.calcularDescuento(10));
    }
}
