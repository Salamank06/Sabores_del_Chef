public class CursoOnline extends Content {
    private String plataforma;
    private boolean accesoVitalicio;
    private int videosIncluidos;
    
    public CursoOnline(String codigo, String nombre, String nivel, int duracionHoras, 
                      double precio, String plataforma, boolean accesoVitalicio, int videosIncluidos) {
        super(codigo, nombre, nivel, duracionHoras, precio);
        this.plataforma = plataforma;
        this.accesoVitalicio = accesoVitalicio;
        this.videosIncluidos = videosIncluidos;
    }
    
    public String getPlataforma() {
        return plataforma;
    }
    
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    public boolean isAccesoVitalicio() {
        return accesoVitalicio;
    }
    
    public void setAccesoVitalicio(boolean accesoVitalicio) {
        this.accesoVitalicio = accesoVitalicio;
    }
    
    public int getVideosIncluidos() {
        return videosIncluidos;
    }
    
    public void setVideosIncluidos(int videosIncluidos) {
        this.videosIncluidos = videosIncluidos;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Acceso Vitalicio: " + (accesoVitalicio ? "Sí" : "No"));
        System.out.println("Videos Incluidos: " + videosIncluidos);
        System.out.println("Tipo: Curso Online");
    }
    
    @Override
    public double calcularPrecioFinal() {
        if (accesoVitalicio) {
            return this.precio * 1.2;
        }
        return this.precio;
    }
    
    @Override
    public String obtenerTipo() {
        return "Curso Online";
    }
    
    @Override
    public int calcularTiempoPreparacion() {
        return videosIncluidos * 2;
    }
    
    public String obtenerInformacionAcceso() {
        return accesoVitalicio ? "Acceso de por vida" : "Acceso limitado a 6 meses";
    }
}

