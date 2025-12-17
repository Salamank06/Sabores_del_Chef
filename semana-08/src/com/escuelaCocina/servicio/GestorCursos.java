package com.escuelaCocina.servicio;

import com.escuelaCocina.modelo.*;
import com.escuelaCocina.excepciones.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorCursos {
    private Map<String, Content> cursosPorCodigo;
    private List<Content> historial;
    private Map<String, List<Content>> cursosPorNivel;
    
    public GestorCursos() {
        this.cursosPorCodigo = new HashMap<>();
        this.historial = new ArrayList<>();
        this.cursosPorNivel = new HashMap<>();
    }
    
    public void agregarCurso(Content curso) throws CursoInvalidoException {
        if (curso == null) {
            throw new CursoInvalidoException("El curso no puede ser nulo");
        }
        
        if (curso.getDuracionHoras() < 2) {
            throw new CursoInvalidoException("La duración mínima de un curso es 2 horas");
        }
        
        if (cursosPorCodigo.containsKey(curso.getCodigo())) {
            throw new CursoInvalidoException("Ya existe un curso con el código: " + curso.getCodigo());
        }
        
        cursosPorCodigo.put(curso.getCodigo(), curso);
        historial.add(curso);
        
        String nivel = curso.getNivel();
        if (!cursosPorNivel.containsKey(nivel)) {
            cursosPorNivel.put(nivel, new ArrayList<>());
        }
        cursosPorNivel.get(nivel).add(curso);
        
        System.out.println("✅ Curso agregado exitosamente: " + curso.getNombre());
    }
    
    public Content buscarPorCodigo(String codigo) {
        return cursosPorCodigo.get(codigo);
    }
    
    public boolean existeCurso(String codigo) {
        return cursosPorCodigo.containsKey(codigo);
    }
    
    public Content eliminarCurso(String codigo) throws CursoInvalidoException {
        if (!existeCurso(codigo)) {
            throw new CursoInvalidoException("No existe curso con código: " + codigo);
        }
        
        Content curso = cursosPorCodigo.remove(codigo);
        historial.remove(curso);
        
        List<Content> cursosNivel = cursosPorNivel.get(curso.getNivel());
        if (cursosNivel != null) {
            cursosNivel.remove(curso);
        }
        
        System.out.println("✅ Curso eliminado: " + curso.getNombre());
        return curso;
    }
    
    public void reservarCupo(String codigoCurso, String nombreEstudiante) 
            throws CursoInvalidoException, CupoLlenoException, ReservaInvalidaException {
        
        if (nombreEstudiante == null || nombreEstudiante.trim().isEmpty()) {
            throw new ReservaInvalidaException("El nombre del estudiante no puede estar vacío");
        }
        
        Content curso = buscarPorCodigo(codigoCurso);
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
    
    public List<Content> filtrarPorPrecio(double min, double max) {
        List<Content> resultado = new ArrayList<>();
        for (Content curso : historial) {
            double precio = curso.calcularPrecioFinal();
            if (precio >= min && precio <= max) {
                resultado.add(curso);
            }
        }
        return resultado;
    }
    
    public List<Content> filtrarPorNivel(String nivel) {
        return cursosPorNivel.getOrDefault(nivel, new ArrayList<>());
    }
    
    public List<Content> filtrarPorTipo(String tipo) {
        List<Content> resultado = new ArrayList<>();
        for (Content curso : historial) {
            if (curso.obtenerTipo().equalsIgnoreCase(tipo)) {
                resultado.add(curso);
            }
        }
        return resultado;
    }
    
    public List<Content> filtrarPorDuracion(int minHoras, int maxHoras) {
        List<Content> resultado = new ArrayList<>();
        for (Content curso : historial) {
            int duracion = curso.getDuracionHoras();
            if (duracion >= minHoras && duracion <= maxHoras) {
                resultado.add(curso);
            }
        }
        return resultado;
    }
    
    public double calcularTotalIngresos() {
        double total = 0;
        for (Content curso : historial) {
            total += curso.calcularPrecioFinal();
        }
        return total;
    }
    
    public double calcularPromedioPrecio() {
        if (historial.isEmpty()) return 0;
        return calcularTotalIngresos() / historial.size();
    }
    
    public Content obtenerCursoMasCaro() {
        if (historial.isEmpty()) return null;
        Content masCaro = historial.get(0);
        for (Content curso : historial) {
            if (curso.calcularPrecioFinal() > masCaro.calcularPrecioFinal()) {
                masCaro = curso;
            }
        }
        return masCaro;
    }
    
    public Content obtenerCursoMasBarato() {
        if (historial.isEmpty()) return null;
        Content masBarato = historial.get(0);
        for (Content curso : historial) {
            if (curso.calcularPrecioFinal() < masBarato.calcularPrecioFinal()) {
                masBarato = curso;
            }
        }
        return masBarato;
    }
    
    public Map<String, Integer> contarPorTipo() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Content curso : historial) {
            String tipo = curso.obtenerTipo();
            conteo.put(tipo, conteo.getOrDefault(tipo, 0) + 1);
        }
        return conteo;
    }
    
    public Map<String, Integer> contarPorNivel() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Content curso : historial) {
            String nivel = curso.getNivel();
            conteo.put(nivel, conteo.getOrDefault(nivel, 0) + 1);
        }
        return conteo;
    }
    
    public int contarCursosDisponibles() {
        int disponibles = 0;
        for (Content curso : historial) {
            if (curso instanceof CursoPresencial) {
                if (((CursoPresencial) curso).hayCupos()) {
                    disponibles++;
                }
            } else if (curso instanceof Taller) {
                if (((Taller) curso).hayDisponibilidad()) {
                    disponibles++;
                }
            } else {
                disponibles++;
            }
        }
        return disponibles;
    }
    
    public List<Content> listarTodos() {
        return new ArrayList<>(historial);
    }
    
    public void mostrarCatalogo() {
        System.out.println("\n=== CATÁLOGO DE CURSOS ===");
        if (historial.isEmpty()) {
            System.out.println("No hay cursos disponibles");
            return;
        }
        
        for (Content curso : historial) {
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
        return historial.size();
    }
    
    public boolean estaVacio() {
        return historial.isEmpty();
    }
}

