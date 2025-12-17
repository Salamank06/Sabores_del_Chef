public abstract class Content {
    protected String codigo;
    protected String nombre;
    protected String nivel;
    protected int duracionHoras;
    protected double precio;
    
    public Content(String codigo, String nombre, String nivel, int duracionHoras, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.duracionHoras = duracionHoras;
        this.precio = precio;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNivel() {
        return nivel;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public int getDuracionHoras() {
        return duracionHoras;
    }
    
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void mostrarInfo() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Duración: " + duracionHoras + " horas");
        System.out.println("Precio Base: $" + precio);
    }
    
    public abstract double calcularPrecioFinal();
    
    public abstract String obtenerTipo();
    
    public abstract int calcularTiempoPreparacion();
}
