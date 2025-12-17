package com.escuelaCocina;

import com.escuelaCocina.modelo.*;
import com.escuelaCocina.servicio.GestorCursos;
import com.escuelaCocina.excepciones.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ESCUELA DE COCINA: SABORES DEL CHEF ===");
        System.out.println("=== SEMANA 07: PAQUETES Y EXCEPCIONES ===\n");
        
        GestorCursos gestor = new GestorCursos();
        
        System.out.println("--- Caso 1: Crear cursos válidos ---\n");
        try {
            Chef chef1 = new Chef("CHEF-001", "María González", "Cocina Colombiana", 15);
            Chef chef2 = new Chef("CHEF-002", "Carlos Ramírez", "Repostería", 8);
            
            CursoPresencial curso1 = new CursoPresencial(
                "PRES-001",
                "Cocina Colombiana Tradicional",
                "Básico",
                40,
                500000,
                chef1,
                3,
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
                2
            );
            
            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);
            gestor.agregarCurso(taller1);
            
        } catch (CursoInvalidoException e) {
            System.err.println("❌ Error al crear curso: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error de validación: " + e.getMessage());
        }
        
        System.out.println("\n--- Caso 2: Intentar crear curso con duración inválida ---\n");
        try {
            Chef chef3 = new Chef("CHEF-003", "Ana Martínez", "Cocina Internacional", 12);
            CursoPresencial cursoInvalido = new CursoPresencial(
                "PRES-002",
                "Curso Express",
                "Básico",
                1,
                100000,
                chef3,
                10,
                "Sala B"
            );
            
            gestor.agregarCurso(cursoInvalido);
            
        } catch (CursoInvalidoException e) {
            System.err.println("❌ Curso rechazado: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Validación fallida: " + e.getMessage());
        }
        
        System.out.println("\n--- Caso 3: Intentar crear Chef con ID inválido ---\n");
        try {
            Chef chefInvalido = new Chef("ABC", "Pedro López", "Panadería", 5);
            System.out.println("Chef creado: " + chefInvalido);
            
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error al crear Chef: " + e.getMessage());
        }
        
        System.out.println("\n--- Caso 4: Reservas exitosas ---\n");
        try {
            gestor.reservarCupo("PRES-001", "Juan Pérez");
            gestor.reservarCupo("PRES-001", "María López");
            gestor.reservarCupo("TALL-001", "Carlos García");
            
        } catch (CursoInvalidoException e) {
            System.err.println("❌ Curso no encontrado: " + e.getMessage());
        } catch (CupoLlenoException e) {
            System.err.println("❌ Sin cupos: " + e.getMessage());
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Reserva inválida: " + e.getMessage());
        }
        
        System.out.println("\n--- Caso 5: Intentar reservar cuando no hay cupos ---\n");
        try {
            gestor.reservarCupo("PRES-001", "Ana Martínez");
            gestor.reservarCupo("PRES-001", "Luis Rodríguez");
            
        } catch (CursoInvalidoException e) {
            System.err.println("❌ Curso no encontrado: " + e.getMessage());
        } catch (CupoLlenoException e) {
            System.err.println("❌ Cupo lleno: " + e.getMessage());
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Reserva inválida: " + e.getMessage());
        } finally {
            System.out.println("ℹ️  Proceso de reserva finalizado");
        }
        
        System.out.println("\n--- Caso 6: Intentar reservar en curso inexistente ---\n");
        try {
            gestor.reservarCupo("XXX-999", "Estudiante Test");
            
        } catch (CursoInvalidoException e) {
            System.err.println("❌ Error: " + e.getMessage());
        } catch (CupoLlenoException e) {
            System.err.println("❌ Sin cupos: " + e.getMessage());
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Reserva inválida: " + e.getMessage());
        }
        
        System.out.println("\n--- Caso 7: Reserva con nombre vacío ---\n");
        try {
            gestor.reservarCupo("ONLI-001", "");
            
        } catch (CursoInvalidoException e) {
            System.err.println("❌ Curso no válido: " + e.getMessage());
        } catch (CupoLlenoException e) {
            System.err.println("❌ Sin cupos: " + e.getMessage());
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Datos incompletos: " + e.getMessage());
        }
        
        System.out.println("\n--- Caso 8: Manejo de recursos con finally ---\n");
        GestorCursos gestorTemp = null;
        try {
            gestorTemp = new GestorCursos();
            Chef chefTemp = new Chef("CHEF-004", "Roberto Silva", "Cocina Asiática", 20);
            CursoPresencial cursoTemp = new CursoPresencial(
                "PRES-003",
                "Cocina Japonesa",
                "Avanzado",
                50,
                800000,
                chefTemp,
                15,
                "Sala C"
            );
            gestorTemp.agregarCurso(cursoTemp);
            System.out.println("✅ Gestor temporal creado y curso agregado");
            
        } catch (CursoInvalidoException e) {
            System.err.println("❌ Error en gestor temporal: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error de validación: " + e.getMessage());
        } finally {
            if (gestorTemp != null) {
                System.out.println("ℹ️  Limpieza: Gestor temporal procesado correctamente");
                System.out.println("ℹ️  Total de cursos en gestor temporal: " + gestorTemp.getTotalCursos());
            } else {
                System.out.println("ℹ️  Limpieza: Gestor temporal no fue inicializado");
            }
        }
        
        gestor.mostrarCatalogo();
        
        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Total de cursos en el sistema: " + gestor.getTotalCursos());
        System.out.println("✅ Semana 07 completada: Paquetes y Excepciones");
    }
}

