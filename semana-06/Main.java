import abstractas.Content;
import interfaces.Reservable;
import interfaces.Calificable;
import interfaces.Certificable;
import implementaciones.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ESCUELA DE COCINA: SABORES DEL CHEF ===");
        System.out.println("=== SEMANA 06: ABSTRACCIÓN E INTERFACES ===\n");
        
        Chef chef1 = new Chef("CHEF-001", "María González", "Cocina Colombiana", 15);
        Chef chef2 = new Chef("CHEF-002", "Carlos Ramírez", "Repostería", 8);
        Chef chef3 = new Chef("CHEF-003", "Ana Martínez", "Cocina Internacional", 12);
        
        CursoPresencial curso1 = new CursoPresencial(
            "COOK-001", 
            "Cocina Colombiana Tradicional", 
            "Básico", 
            40, 
            500000, 
            chef1, 
            20, 
            "Sala A"
        );
        
        CursoOnline curso2 = new CursoOnline(
            "ONLINE-001", 
            "Repostería Francesa", 
            "Intermedio", 
            60, 
            400000, 
            "Plataforma Virtual", 
            true, 
            25
        );
        
        Taller taller1 = new Taller(
            "TALLER-001", 
            "Pasta Artesanal", 
            "Básico", 
            4, 
            150000, 
            chef3, 
            "Elaboración de pasta fresca", 
            true, 
            12
        );
        
        System.out.println("--- Sección 1: Polimorfismo con Clase Abstracta ---\n");
        
        Content[] contenidos = new Content[3];
        contenidos[0] = curso1;
        contenidos[1] = curso2;
        contenidos[2] = taller1;
        
        System.out.println("Recorriendo array polimórfico de tipo Content:");
        for (Content contenido : contenidos) {
            System.out.println("\n>>> " + contenido.obtenerTipo() + ": " + contenido.getNombre());
            System.out.println("    Precio Final: $" + contenido.calcularPrecioFinal());
            System.out.println("    Tiempo de Preparación: " + contenido.calcularTiempoPreparacion() + " horas");
            System.out.println("    Nivel: " + contenido.getNivel());
        }
        
        System.out.println("\n\n--- Sección 2: Interfaces - Demostración Individual ---\n");
        
        System.out.println("=== Interface Reservable ===\n");
        
        Reservable cursoReservable = curso1;
        
        System.out.println("Curso: " + curso1.getNombre());
        System.out.println("¿Disponible? " + cursoReservable.verificarDisponibilidad("2025-01-15"));
        
        cursoReservable.realizarReserva("Juan Pérez", "2025-01-15");
        cursoReservable.realizarReserva("María López", "2025-01-15");
        
        System.out.println("\nÚltimo código de reserva: " + cursoReservable.obtenerCodigoReserva());
        
        Reservable tallerReservable = taller1;
        System.out.println("\n\nTaller: " + taller1.getNombre());
        tallerReservable.realizarReserva("Carlos García", "2025-01-20");
        
        System.out.println("\n\n=== Interface Calificable ===\n");
        
        Calificable cursoCalificable = curso2;
        
        System.out.println("Curso: " + curso2.getNombre());
        cursoCalificable.agregarCalificacion(5, "Excelente curso");
        cursoCalificable.agregarCalificacion(4, "Muy bueno");
        cursoCalificable.agregarCalificacion(5, "Lo mejor");
        
        cursoCalificable.mostrarCalificaciones();
        
        Calificable cursoPresencialCalificable = curso1;
        System.out.println("\n\nCurso: " + curso1.getNombre());
        cursoPresencialCalificable.agregarCalificacion(5, "Excelente instructor");
        cursoPresencialCalificable.agregarCalificacion(4, "Muy práctico");
        cursoPresencialCalificable.mostrarCalificaciones();
        
        System.out.println("\n\n=== Interface Certificable ===\n");
        
        Certificable cursoCertificable = curso2;
        
        System.out.println("Curso: " + curso2.getNombre());
        System.out.println("¿Cumple requisitos? " + cursoCertificable.cumpleRequisitosCertificacion());
        cursoCertificable.emitirCertificado("Juan Pérez");
        cursoCertificable.emitirCertificado("María López");
        
        System.out.println("\n\nCurso: " + curso1.getNombre());
        Certificable cursoPresencialCertificable = curso1;
        System.out.println("¿Cumple requisitos? " + cursoPresencialCertificable.cumpleRequisitosCertificacion());
        cursoPresencialCertificable.emitirCertificado("Carlos García");
        
        System.out.println("\n\n--- Sección 3: Múltiple Implementación ---\n");
        
        System.out.println("=== Curso Presencial (implementa 3 interfaces) ===\n");
        System.out.println("Curso: " + curso1.getNombre());
        System.out.println("Tipo real: " + curso1.getClass().getSimpleName());
        System.out.println("\nInterfaces implementadas:");
        System.out.println("  1. Reservable");
        System.out.println("  2. Calificable");
        System.out.println("  3. Certificable");
        
        System.out.println("\nDemostración de capacidades:");
        
        System.out.println("\n> Como Reservable:");
        Reservable r = curso1;
        System.out.println("  - Verificar disponibilidad: " + r.verificarDisponibilidad("2025-02-01"));
        r.realizarReserva("Ana Martínez", "2025-02-01");
        
        System.out.println("\n> Como Calificable:");
        Calificable cal = curso1;
        System.out.println("  - Número de calificaciones: " + cal.obtenerNumeroCalificaciones());
        System.out.println("  - Promedio: " + cal.obtenerPromedioCalificaciones());
        
        System.out.println("\n> Como Certificable:");
        Certificable cert = curso1;
        System.out.println("  - Cumple requisitos: " + cert.cumpleRequisitosCertificacion());
        System.out.println("  - Número de certificado: " + cert.obtenerNumeroCertificado());
        
        System.out.println("\n\n=== Curso Online (implementa 2 interfaces) ===\n");
        System.out.println("Curso: " + curso2.getNombre());
        System.out.println("Tipo real: " + curso2.getClass().getSimpleName());
        System.out.println("\nInterfaces implementadas:");
        System.out.println("  1. Calificable");
        System.out.println("  2. Certificable");
        
        System.out.println("\n\n--- Sección 4: Demostración de Diseño SOLID ---\n");
        
        System.out.println("=== Principio de Sustitución de Liskov (LSP) ===");
        System.out.println("Todas las subclases pueden sustituir a Content:\n");
        
        procesarContenido(curso1);
        procesarContenido(curso2);
        procesarContenido(taller1);
        
        System.out.println("\n=== Principio de Segregación de Interfaces (ISP) ===");
        System.out.println("Cada clase implementa solo las interfaces que necesita:\n");
        
        System.out.println("CursoPresencial -> Reservable + Calificable + Certificable");
        System.out.println("CursoOnline -> Calificable + Certificable");
        System.out.println("Taller -> Reservable");
        
        System.out.println("\nNo todas las clases implementan todas las interfaces,");
        System.out.println("solo las que tienen sentido para su propósito.");
        
        System.out.println("\n\n--- Sección 5: Estadísticas Finales ---\n");
        
        System.out.println("Total de contenidos creados: 3");
        System.out.println("  - Cursos Presenciales: 1");
        System.out.println("  - Cursos Online: 1");
        System.out.println("  - Talleres: 1");
        
        System.out.println("\nContenidos Reservables: 2 (Curso Presencial + Taller)");
        System.out.println("Contenidos Calificables: 2 (Cursos Presencial + Online)");
        System.out.println("Contenidos Certificables: 2 (Cursos Presencial + Online)");
        
        int totalReservas = 0;
        if (curso1 instanceof Reservable) totalReservas++;
        if (taller1 instanceof Reservable) totalReservas++;
        
        System.out.println("\nTotal de contenidos con capacidad de reserva: " + totalReservas);
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
    
    public static void procesarContenido(Content contenido) {
        System.out.println("  Procesando: " + contenido.getNombre());
        System.out.println("  Tipo: " + contenido.obtenerTipo());
        System.out.println("  Precio: $" + contenido.calcularPrecioFinal());
    }
}
