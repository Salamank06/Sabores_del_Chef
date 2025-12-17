package com.escuelaCocina;

import com.escuelaCocina.modelo.*;
import com.escuelaCocina.servicio.GestorCursos;
import com.escuelaCocina.excepciones.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GestorCursos gestor = new GestorCursos();
    
    public static void main(String[] args) {
        System.out.println("=== ESCUELA DE COCINA: SABORES DEL CHEF ===");
        System.out.println("=== SEMANA 08: COLECCIONES Y GENERICS ===\n");
        
        cargarDatosIniciales();
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    agregarCurso();
                    break;
                case 2:
                    buscarPorCodigo();
                    break;
                case 3:
                    listarTodos();
                    break;
                case 4:
                    filtrarPorPrecio();
                    break;
                case 5:
                    filtrarPorNivel();
                    break;
                case 6:
                    filtrarPorTipo();
                    break;
                case 7:
                    mostrarEstadisticas();
                    break;
                case 8:
                    reservarCupo();
                    break;
                case 9:
                    eliminarCurso();
                    break;
                case 0:
                    System.out.println("\n¡Gracias por usar el sistema!");
                    System.out.println("✅ Semana 08 completada: Colecciones y Generics");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }
            
            if (opcion != 0) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      MENÚ PRINCIPAL                    ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Agregar curso                       ║");
        System.out.println("║ 2. Buscar curso por código (HashMap)   ║");
        System.out.println("║ 3. Listar todos los cursos             ║");
        System.out.println("║ 4. Filtrar por rango de precio         ║");
        System.out.println("║ 5. Filtrar por nivel                   ║");
        System.out.println("║ 6. Filtrar por tipo                    ║");
        System.out.println("║ 7. Ver estadísticas                    ║");
        System.out.println("║ 8. Reservar cupo                       ║");
        System.out.println("║ 9. Eliminar curso                      ║");
        System.out.println("║ 0. Salir                               ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
    }
    
    private static int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
    
    private static void cargarDatosIniciales() {
        try {
            Chef chef1 = new Chef("CHEF-001", "María González", "Cocina Colombiana", 15);
            Chef chef2 = new Chef("CHEF-002", "Carlos Ramírez", "Repostería", 8);
            Chef chef3 = new Chef("CHEF-003", "Ana Martínez", "Cocina Internacional", 12);
            
            CursoPresencial curso1 = new CursoPresencial(
                "PRES-001",
                "Cocina Colombiana Tradicional",
                "Básico",
                40,
                500000,
                chef1,
                20,
                "Sala A"
            );
            
            CursoOnline curso2 = new CursoOnline(
                "ONLI-001",
                "Repostería Francesa",
                "Intermedio",
                60,
                400000,
                "Plataforma Virtual",
                true,
                25
            );
            
            Taller taller1 = new Taller(
                "TALL-001",
                "Pasta Artesanal",
                "Básico",
                4,
                150000,
                chef2,
                "Elaboración de pasta fresca",
                true,
                15
            );
            
            CursoPresencial curso3 = new CursoPresencial(
                "PRES-002",
                "Cocina Italiana Avanzada",
                "Avanzado",
                80,
                1000000,
                chef3,
                10,
                "Sala B"
            );
            
            Taller taller2 = new Taller(
                "TALL-002",
                "Decoración de Pasteles",
                "Intermedio",
                6,
                200000,
                chef2,
                "Técnicas de decoración profesional",
                true,
                12
            );
            
            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);
            gestor.agregarCurso(taller1);
            gestor.agregarCurso(curso3);
            gestor.agregarCurso(taller2);
            
            System.out.println("\n✅ Datos iniciales cargados correctamente");
            
        } catch (Exception e) {
            System.err.println("Error cargando datos iniciales: " + e.getMessage());
        }
    }
    
    private static void agregarCurso() {
        System.out.println("\n=== AGREGAR CURSO ===");
        System.out.println("Tipo de curso: 1=Presencial, 2=Online, 3=Taller");
        System.out.print("Seleccione tipo: ");
        int tipo = leerOpcion();
        
        try {
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nivel (Básico/Intermedio/Avanzado): ");
            String nivel = scanner.nextLine();
            System.out.print("Duración (horas): ");
            int duracion = scanner.nextInt();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            
            switch (tipo) {
                case 1:
                    Chef chef = new Chef("CHEF-999", "Chef Temporal", "General", 5);
                    System.out.print("Cupos máximos: ");
                    int cupos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Sala: ");
                    String sala = scanner.nextLine();
                    
                    CursoPresencial cursoP = new CursoPresencial(codigo, nombre, nivel, duracion, precio, chef, cupos, sala);
                    gestor.agregarCurso(cursoP);
                    break;
                    
                case 2:
                    System.out.print("Plataforma: ");
                    String plataforma = scanner.nextLine();
                    System.out.print("¿Acceso vitalicio? (true/false): ");
                    boolean vitalicio = scanner.nextBoolean();
                    System.out.print("Videos incluidos: ");
                    int videos = scanner.nextInt();
                    scanner.nextLine();
                    
                    CursoOnline cursoO = new CursoOnline(codigo, nombre, nivel, duracion, precio, plataforma, vitalicio, videos);
                    gestor.agregarCurso(cursoO);
                    break;
                    
                case 3:
                    Chef chefT = new Chef("CHEF-998", "Chef Taller", "Especializado", 8);
                    System.out.print("Tema específico: ");
                    String tema = scanner.nextLine();
                    System.out.print("¿Incluye materiales? (true/false): ");
                    boolean materiales = scanner.nextBoolean();
                    System.out.print("Máximo participantes: ");
                    int max = scanner.nextInt();
                    scanner.nextLine();
                    
                    Taller taller = new Taller(codigo, nombre, nivel, duracion, precio, chefT, tema, materiales, max);
                    gestor.agregarCurso(taller);
                    break;
                    
                default:
                    System.out.println("Tipo inválido");
            }
        } catch (CursoInvalidoException e) {
            System.err.println("❌ Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
        }
    }
    
    private static void buscarPorCodigo() {
        System.out.println("\n=== BUSCAR POR CÓDIGO (HashMap O(1)) ===");
        System.out.print("Ingrese el código del curso: ");
        String codigo = scanner.nextLine();
        
        Content curso = gestor.buscarPorCodigo(codigo);
        
        if (curso != null) {
            System.out.println("\n✅ Curso encontrado:");
            System.out.println(curso);
            System.out.println("Precio: $" + curso.calcularPrecioFinal());
        } else {
            System.out.println("❌ No existe curso con código: " + codigo);
        }
    }
    
    private static void listarTodos() {
        System.out.println("\n=== LISTADO COMPLETO (ArrayList) ===");
        List<Content> cursos = gestor.listarTodos();
        
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados");
            return;
        }
        
        System.out.println("Total de cursos: " + cursos.size());
        for (int i = 0; i < cursos.size(); i++) {
            Content curso = cursos.get(i);
            System.out.println("\n" + (i + 1) + ". " + curso.getNombre());
            System.out.println("   Código: " + curso.getCodigo());
            System.out.println("   Nivel: " + curso.getNivel());
            System.out.println("   Duración: " + curso.getDuracionHoras() + " horas");
            System.out.println("   Precio: $" + curso.calcularPrecioFinal());
        }
    }
    
    private static void filtrarPorPrecio() {
        System.out.println("\n=== FILTRAR POR RANGO DE PRECIO ===");
        System.out.print("Precio mínimo: ");
        double min = scanner.nextDouble();
        System.out.print("Precio máximo: ");
        double max = scanner.nextDouble();
        scanner.nextLine();
        
        List<Content> resultados = gestor.filtrarPorPrecio(min, max);
        
        if (resultados.isEmpty()) {
            System.out.println("No hay cursos en ese rango de precio");
        } else {
            System.out.println("\n✅ Encontrados " + resultados.size() + " cursos:");
            for (Content curso : resultados) {
                System.out.println("  - " + curso.getNombre() + ": $" + curso.calcularPrecioFinal());
            }
        }
    }
    
    private static void filtrarPorNivel() {
        System.out.println("\n=== FILTRAR POR NIVEL ===");
        System.out.println("Niveles disponibles: Básico, Intermedio, Avanzado");
        System.out.print("Ingrese el nivel: ");
        String nivel = scanner.nextLine();
        
        List<Content> resultados = gestor.filtrarPorNivel(nivel);
        
        if (resultados.isEmpty()) {
            System.out.println("No hay cursos de nivel: " + nivel);
        } else {
            System.out.println("\n✅ Encontrados " + resultados.size() + " cursos de nivel " + nivel + ":");
            for (Content curso : resultados) {
                System.out.println("  - " + curso.getNombre() + " ($" + curso.calcularPrecioFinal() + ")");
            }
        }
    }
    
    private static void filtrarPorTipo() {
        System.out.println("\n=== FILTRAR POR TIPO ===");
        System.out.println("Tipos: CursoPresencial, CursoOnline, Taller");
        System.out.print("Ingrese el tipo: ");
        String tipo = scanner.nextLine();
        
        List<Content> resultados = gestor.filtrarPorTipo(tipo);
        
        if (resultados.isEmpty()) {
            System.out.println("No hay cursos de tipo: " + tipo);
        } else {
            System.out.println("\n✅ Encontrados " + resultados.size() + " cursos de tipo " + tipo + ":");
            for (Content curso : resultados) {
                System.out.println("  - " + curso.getNombre());
            }
        }
    }
    
    private static void mostrarEstadisticas() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          ESTADÍSTICAS                  ║");
        System.out.println("╠════════════════════════════════════════╣");
        
        System.out.println("║ Total cursos: " + String.format("%-24s", gestor.getTotalCursos()) + "║");
        System.out.println("║ Cursos disponibles: " + String.format("%-18s", gestor.contarCursosDisponibles()) + "║");
        System.out.println("║ Total ingresos: $" + String.format("%-21.2f", gestor.calcularTotalIngresos()) + "║");
        System.out.println("║ Precio promedio: $" + String.format("%-20.2f", gestor.calcularPromedioPrecio()) + "║");
        
        Content masCaro = gestor.obtenerCursoMasCaro();
        if (masCaro != null) {
            System.out.println("║                                        ║");
            System.out.println("║ Curso más caro:                        ║");
            System.out.println("║   " + String.format("%-36s", masCaro.getNombre()) + "║");
            System.out.println("║   $" + String.format("%-35.2f", masCaro.calcularPrecioFinal()) + "║");
        }
        
        Content masBarato = gestor.obtenerCursoMasBarato();
        if (masBarato != null) {
            System.out.println("║                                        ║");
            System.out.println("║ Curso más barato:                      ║");
            System.out.println("║   " + String.format("%-36s", masBarato.getNombre()) + "║");
            System.out.println("║   $" + String.format("%-35.2f", masBarato.calcularPrecioFinal()) + "║");
        }
        
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ CONTEO POR TIPO:                       ║");
        Map<String, Integer> conteoPorTipo = gestor.contarPorTipo();
        for (Map.Entry<String, Integer> entry : conteoPorTipo.entrySet()) {
            System.out.println("║   " + String.format("%-25s", entry.getKey()) + ": " + String.format("%-6d", entry.getValue()) + "║");
        }
        
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ CONTEO POR NIVEL:                      ║");
        Map<String, Integer> conteoPorNivel = gestor.contarPorNivel();
        for (Map.Entry<String, Integer> entry : conteoPorNivel.entrySet()) {
            System.out.println("║   " + String.format("%-25s", entry.getKey()) + ": " + String.format("%-6d", entry.getValue()) + "║");
        }
        
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    private static void reservarCupo() {
        System.out.println("\n=== RESERVAR CUPO ===");
        System.out.print("Código del curso: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre del estudiante: ");
        String nombre = scanner.nextLine();
        
        try {
            gestor.reservarCupo(codigo, nombre);
        } catch (CursoInvalidoException | CupoLlenoException | ReservaInvalidaException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
    
    private static void eliminarCurso() {
        System.out.println("\n=== ELIMINAR CURSO ===");
        System.out.print("Código del curso a eliminar: ");
        String codigo = scanner.nextLine();
        
        try {
            Content curso = gestor.eliminarCurso(codigo);
            System.out.println("✅ Curso eliminado exitosamente: " + curso.getNombre());
        } catch (CursoInvalidoException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}


