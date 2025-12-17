public class Main {
    public static void main(String[] args) {
        CookingCourse curso1 = new CookingCourse("COOK-001", "Cocina Colombiana", "Básico");
        CookingCourse curso2 = new CookingCourse("COOK-002", "Repostería Francesa", "Intermedio");
        CookingCourse curso3 = new CookingCourse("COOK-003", "Cocina Italiana", "Avanzado");
        
        System.out.println("=== Actividad 3: Primera Clase Simple ===");
        System.out.println("\nCurso 1:");
        curso1.showInfo();
        
        System.out.println("\nCurso 2:");
        curso2.showInfo();
        
        System.out.println("\nCurso 3:");
        curso3.showInfo();
        
        System.out.println("\n=== Actividad 4: Múltiples Objetos ===");
        CookingCourse curso4 = new CookingCourse("COOK-004", "Panadería Artesanal", "Básico");
        CookingCourse curso5 = new CookingCourse("COOK-005", "Coctelería Profesional", "Intermedio");
        
        System.out.println("\nTodos los cursos disponibles:");
        System.out.println("\n--- Curso 1 ---");
        curso1.showInfo();
        System.out.println("\n--- Curso 2 ---");
        curso2.showInfo();
        System.out.println("\n--- Curso 3 ---");
        curso3.showInfo();
        System.out.println("\n--- Curso 4 ---");
        curso4.showInfo();
        System.out.println("\n--- Curso 5 ---");
        curso5.showInfo();
    }
}

