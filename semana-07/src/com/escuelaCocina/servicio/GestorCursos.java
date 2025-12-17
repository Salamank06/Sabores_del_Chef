package com.escuelaCocina.servicio;

import com.escuelaCocina.modelo.*;
import com.escuelaCocina.excepciones.*;
import java.util.ArrayList;
import java.util.List;

public class GestorCursos {
    private List<Content> cursos;
    
    public GestorCursos() {
        this.cursos = new ArrayList<>();
    }
    
    public void agregarCurso(Content curso) throws CursoInvalidoException {
        if (curso == null) {
            throw new CursoInvalidoException("El curso no puede ser nulo");
        }
        
        if (curso.getDuracionHoras() < 2) {
            throw new CursoInvalidoException("La duración mínima de un curso es 2 horas");
        }
        
        if (existeCurso(curso.getCodigo())) {
            throw new CursoInvalidoException("Ya existe un curso con el código: " + curso.getCodigo());
        }
        
        cursos.add(curso);
        System.out.println("✅ Curso agregado exitosamente: " + curso.getNombre());
    }
    
    public void reservarCupo(String codigoCurso, String nombreEstudiante) 
            throws CursoInvalidoException, CupoLlenoException, ReservaInvalidaException {
        
        if (nombreEstudiante == null || nombreEstudiante.trim().isEmpty()) {
            throw new ReservaInvalidaException("El nombre del estudiante no puede estar vacío");
        }
        
        Content curso = buscarCurso(codigoCurso);
        if (curso == null) {
            throw new CursoInvalidoException("No existe curso con código: " + codigoCurso);
        }
        
        if (curso instanceof CursoPresencial) {
            CursoPresencial cursoPresencial = (CursoPresencial) curso;
            if (!cursoPresencial.hayCupos()) {
                throw new CupoLlenoException(
                    "El curso '" + cursoPresencial.getNombre() + "' no tiene cupos disponibles"
                );
            }
            cursoPresencial.reservarCupo();
            System.out.println("✅ Reserva exitosa para " + nombreEstudiante + " en " + cursoPresencial.getNombre());
            System.out.println("   Cupos restantes: " + cursoPresencial.getCuposDisponibles());
        } else if (curso instanceof Taller) {
            Taller taller = (Taller) curso;
            if (!taller.hayDisponibilidad()) {
                throw new CupoLlenoException(
                    "El taller '" + taller.getNombre() + "' está lleno"
                );
            }
            taller.inscribirParticipante();
            System.out.println("✅ Inscripción exitosa para " + nombreEstudiante + " en " + taller.getNombre());
            System.out.println("   Participantes: " + taller.getParticipantesActuales() + "/" + taller.getMaxParticipantes());
        } else {
            System.out.println("✅ Acceso otorgado a " + nombreEstudiante + " para el curso online: " + curso.getNombre());
        }
    }
    
    public Content buscarCurso(String codigo) {
        for (Content curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }
    
    public boolean existeCurso(String codigo) {
        return buscarCurso(codigo) != null;
    }
    
    public List<Content> obtenerCursosPorNivel(String nivel) {
        List<Content> resultado = new ArrayList<>();
        for (Content curso : cursos) {
            if (curso.getNivel().equals(nivel)) {
                resultado.add(curso);
            }
        }
        return resultado;
    }
    
    public void mostrarCatalogo() {
        System.out.println("\n=== CATÁLOGO DE CURSOS ===");
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles");
            return;
        }
        
        for (Content curso : cursos) {
            System.out.println("\n" + curso);
            if (curso instanceof CursoPresencial) {
                CursoPresencial cp = (CursoPresencial) curso;
                System.out.println("  Cupos: " + cp.getCuposDisponibles() + "/" + cp.getCuposMaximos());
            } else if (curso instanceof Taller) {
                Taller t = (Taller) curso;
                System.out.println("  Participantes: " + t.getParticipantesActuales() + "/" + t.getMaxParticipantes());
            }
        }
    }
    
    public int getTotalCursos() {
        return cursos.size();
    }
}


