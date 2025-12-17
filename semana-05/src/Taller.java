public class Taller extends Content {
    private Chef chefInstructor;
    private String temaEspecifico;
    private boolean incluyeMateriales;
    private int maxParticipantes;
    
    public Taller(String codigo, String nombre, String nivel, int duracionHoras, 
                 double precio, Chef chefInstructor, String temaEspecifico, 
                 boolean incluyeMateriales, int maxParticipantes) {
        super(codigo, nombre, nivel, duracionHoras, precio);
        this.chefInstructor = chefInstructor;
        this.temaEspecifico = temaEspecifico;
        this.incluyeMateriales = incluyeMateriales;
        this.maxParticipantes = maxParticipantes;
    }
    
    public Chef getChefInstructor() {
        return chefInstructor;
    }
    
    public void setChefInstructor(Chef chefInstructor) {
        this.chefInstructor = chefInstructor;
    }
    
    public String getTemaEspecifico() {
        return temaEspecifico;
    }
    
    public void setTemaEspecifico(String temaEspecifico) {
        this.temaEspecifico = temaEspecifico;
    }
    
    public boolean isIncluyeMateriales() {
        return incluyeMateriales;
    }
    
    public void setIncluyeMateriales(boolean incluyeMateriales) {
        this.incluyeMateriales = incluyeMateriales;
    }
    
    public int getMaxParticipantes() {
        return maxParticipantes;
    }
    
    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        if (chefInstructor != null) {
            System.out.println("Chef Instructor: " + chefInstructor.getNombre());
        }
        System.out.println("Tema Específico: " + temaEspecifico);
        System.out.println("Incluye Materiales: " + (incluyeMateriales ? "Sí" : "No"));
        System.out.println("Máx. Participantes: " + maxParticipantes);
        System.out.println("Tipo: Taller");
    }
    
    @Override
    public double calcularPrecioFinal() {
        double precioFinal = this.precio;
        if (incluyeMateriales) {
            precioFinal *= 1.15;
        }
        if (chefInstructor != null && chefInstructor.esExperto()) {
            precioFinal *= 1.10;
        }
        return precioFinal;
    }
    
    @Override
    public String obtenerTipo() {
        return "Taller";
    }
    
    @Override
    public int calcularTiempoPreparacion() {
        return duracionHoras * 4;
    }
    
    public double calcularPrecioPorPersona(int participantes) {
        if (participantes >= maxParticipantes) {
            return calcularPrecioFinal() * 0.9;
        }
        return calcularPrecioFinal();
    }
}


