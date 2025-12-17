import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ESCUELA DE COCINA: SABORES DEL CHEF ===");
        System.out.println("=== SEMANA 05: POLIMORFISMO ===\n");
        
        EscuelaCocina escuela = new EscuelaCocina("Sabores del Chef");
        
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
        
        CursoPresencial curso3 = new CursoPresencial(
            "COOK-002", 
            "Cocina Italiana Avanzada", 
            "Avanzado", 
            80, 
            1000000, 
            chef3, 
            15, 
            "Sala B"
        );
        
        Taller taller2 = new Taller(
            "TALLER-002", 
            "Decoración de Pasteles", 
            "Intermedio", 
            6, 
            200000, 
            chef2, 
            "Técnicas de decoración profesional", 
            true, 
            10
        );
        
        CursoOnline curso4 = new CursoOnline(
            "ONLINE-002", 
            "Cocina Vegetariana", 
            "Básico", 
            30, 
            300000, 
            "Plataforma Virtual", 
            false, 
            15
        );
        
        System.out.println("=== EJERCICIO 1: SOBRECARGA DE MÉTODOS ===\n");
        
        escuela.agregarContenido(curso1);
        escuela.agregarContenido(curso2);
        escuela.agregarContenido(taller1);
        escuela.agregarContenido(curso3);
        escuela.agregarContenido(taller2);
        escuela.agregarContenido(curso4);
        
        System.out.println("\n--- Demostración de Sobrecarga: buscarContenido() ---\n");
        
        System.out.println("1. Buscar por código (String):");
        Content encontrado = escuela.buscarContenido("COOK-001");
        if (encontrado != null) {
            System.out.println("   Encontrado: " + encontrado.getNombre() + " - " + encontrado.obtenerTipo());
        }
        
        System.out.println("\n2. Buscar por campo y valor (String, String):");
        ArrayList<Content> porNivel = escuela.buscarContenido("nivel", "Básico");
        System.out.println("   Cursos nivel Básico encontrados: " + porNivel.size());
        for (Content c : porNivel) {
            System.out.println("   - " + c.getNombre());
        }
        
        System.out.println("\n3. Buscar por rango de precio (double, double):");
        ArrayList<Content> porPrecio = escuela.buscarContenido(100000, 500000);
        System.out.println("   Cursos entre $100,000 y $500,000: " + porPrecio.size());
        for (Content c : porPrecio) {
            System.out.println("   - " + c.getNombre() + ": $" + c.calcularPrecioFinal());
        }
        
        System.out.println("\n\n=== EJERCICIO 2: SOBRESCRITURA CON @Override ===\n");
        
        ArrayList<Content> contenidos = new ArrayList<>();
        contenidos.add(curso1);
        contenidos.add(curso2);
        contenidos.add(taller1);
        
        System.out.println("--- Método calcularPrecioFinal() sobrescrito ---\n");
        for (Content c : contenidos) {
            System.out.println(c.obtenerTipo() + ": " + c.getNombre());
            System.out.println("Precio Base: $" + c.getPrecio());
            System.out.println("Precio Final: $" + c.calcularPrecioFinal());
            System.out.println("Diferencia: $" + (c.calcularPrecioFinal() - c.getPrecio()));
            System.out.println("---");
        }
        
        System.out.println("\n--- Método calcularTiempoPreparacion() sobrescrito ---\n");
        for (Content c : contenidos) {
            System.out.println(c.obtenerTipo() + ": " + c.getNombre());
            System.out.println("Duración del curso: " + c.getDuracionHoras() + " horas");
            System.out.println("Tiempo de preparación: " + c.calcularTiempoPreparacion() + " horas");
            System.out.println("---");
        }
        
        System.out.println("\n--- Método obtenerTipo() sobrescrito ---\n");
        for (Content c : contenidos) {
            System.out.println("Clase real: " + c.getClass().getSimpleName());
            System.out.println("obtenerTipo(): " + c.obtenerTipo());
            System.out.println("---");
        }
        
        System.out.println("\n\n=== EJERCICIO 3: MÉTODOS POLIMÓRFICOS ===\n");
        
        System.out.println("--- Método prepararContenido(Content) ---\n");
        escuela.prepararContenido(curso1);
        System.out.println();
        escuela.prepararContenido(taller1);
        System.out.println();
        escuela.prepararContenido(curso2);
        
        escuela.procesarTodosLosContenidos();
        
        System.out.println("\n\n=== EJERCICIO 4: DEMOSTRACIÓN COMPLETA ===\n");
        
        System.out.println("--- ArrayList Polimórfico: ArrayList<Content> ---\n");
        ArrayList<Content> catalogoCompleto = escuela.getCatalogo();
        System.out.println("Total de elementos en catálogo polimórfico: " + catalogoCompleto.size());
        
        System.out.println("\n--- Dynamic Binding en acción ---\n");
        for (Content c : catalogoCompleto) {
            System.out.println("Tipo declarado: Content");
            System.out.println("Tipo real: " + c.getClass().getSimpleName());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("obtenerTipo() devuelve: " + c.obtenerTipo());
            System.out.println("calcularPrecioFinal() devuelve: $" + c.calcularPrecioFinal());
            System.out.println("calcularTiempoPreparacion() devuelve: " + c.calcularTiempoPreparacion() + " horas");
            System.out.println("---");
        }
        
        System.out.println("\n--- Análisis por Tipo de Contenido ---\n");
        int cursosOnline = 0, cursosPresenciales = 0, talleres = 0;
        double totalOnline = 0, totalPresencial = 0, totalTalleres = 0;
        
        for (Content c : catalogoCompleto) {
            if (c instanceof CursoOnline) {
                cursosOnline++;
                totalOnline += c.calcularPrecioFinal();
            } else if (c instanceof CursoPresencial) {
                cursosPresenciales++;
                totalPresencial += c.calcularPrecioFinal();
            } else if (c instanceof Taller) {
                talleres++;
                totalTalleres += c.calcularPrecioFinal();
            }
        }
        
        System.out.println("Cursos Online: " + cursosOnline + " (Total: $" + totalOnline + ")");
        System.out.println("Cursos Presenciales: " + cursosPresenciales + " (Total: $" + totalPresencial + ")");
        System.out.println("Talleres: " + talleres + " (Total: $" + totalTalleres + ")");
        
        System.out.println("\n--- Demostración de Polimorfismo con Método Genérico ---\n");
        mostrarDetallesContenido(curso1);
        mostrarDetallesContenido(curso2);
        mostrarDetallesContenido(taller1);
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
    
    public static void mostrarDetallesContenido(Content contenido) {
        System.out.println("\n>>> Contenido: " + contenido.getNombre());
        System.out.println("    Tipo: " + contenido.obtenerTipo());
        System.out.println("    Precio Final: $" + contenido.calcularPrecioFinal());
        System.out.println("    Tiempo de Preparación: " + contenido.calcularTiempoPreparacion() + " horas");
    }
}
