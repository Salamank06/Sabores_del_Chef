import java.util.ArrayList;

public class EscuelaCocina {
    private String nombre;
    private ArrayList<Content> catalogo;
    
    public EscuelaCocina(String nombre) {
        this.nombre = nombre;
        this.catalogo = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarContenido(Content contenido) {
        catalogo.add(contenido);
        System.out.println("Contenido agregado: " + contenido.getNombre() + " (" + contenido.obtenerTipo() + ")");
    }
    
    public Content buscarContenido(String codigo) {
        for (Content c : catalogo) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }
    
    public ArrayList<Content> buscarContenido(String campo, String valor) {
        ArrayList<Content> resultado = new ArrayList<>();
        for (Content c : catalogo) {
            if (campo.equalsIgnoreCase("nivel") && c.getNivel().equalsIgnoreCase(valor)) {
                resultado.add(c);
            } else if (campo.equalsIgnoreCase("tipo") && c.obtenerTipo().equalsIgnoreCase(valor)) {
                resultado.add(c);
            } else if (campo.equalsIgnoreCase("nombre") && c.getNombre().toLowerCase().contains(valor.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }
    
    public ArrayList<Content> buscarContenido(double precioMin, double precioMax) {
        ArrayList<Content> resultado = new ArrayList<>();
        for (Content c : catalogo) {
            double precio = c.calcularPrecioFinal();
            if (precio >= precioMin && precio <= precioMax) {
                resultado.add(c);
            }
        }
        return resultado;
    }
    
    public void prepararContenido(Content contenido) {
        int tiempo = contenido.calcularTiempoPreparacion();
        System.out.println("Preparando contenido: " + contenido.getNombre());
        System.out.println("Tipo: " + contenido.obtenerTipo());
        System.out.println("Tiempo de preparación: " + tiempo + " horas");
        System.out.println("Precio final: $" + contenido.calcularPrecioFinal());
    }
    
    public void generarCatalogo() {
        System.out.println("\n=== CATÁLOGO DE CURSOS: " + nombre + " ===");
        for (Content c : catalogo) {
            System.out.println("\n" + c.obtenerTipo() + ": " + c.getNombre());
            System.out.println("Código: " + c.getCodigo());
            System.out.println("Nivel: " + c.getNivel());
            System.out.println("Duración: " + c.getDuracionHoras() + " horas");
            System.out.println("Precio: $" + c.calcularPrecioFinal());
            System.out.println("---");
        }
    }
    
    public void procesarTodosLosContenidos() {
        System.out.println("\n=== PROCESANDO TODOS LOS CONTENIDOS ===");
        double totalPrecios = 0;
        int totalHoras = 0;
        
        for (Content c : catalogo) {
            prepararContenido(c);
            totalPrecios += c.calcularPrecioFinal();
            totalHoras += c.getDuracionHoras();
            System.out.println("---");
        }
        
        System.out.println("\nTOTAL DE CONTENIDOS: " + catalogo.size());
        System.out.println("TOTAL HORAS: " + totalHoras);
        System.out.println("TOTAL PRECIOS: $" + totalPrecios);
        System.out.println("PRECIO PROMEDIO: $" + (totalPrecios / catalogo.size()));
    }
    
    public ArrayList<Content> getCatalogo() {
        return catalogo;
    }
}

