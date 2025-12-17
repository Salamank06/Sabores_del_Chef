
public class CursoPresencial extends Content {
    private Chef chefInstructor;
    private int cuposDisponibles;
    private String sala;
    
    public CursoPresencial(String codigo, String nombre, String nivel, int duracionHoras, 
                          double precio, Chef chefInstructor, int cuposDisponibles, String sala) {
        super(codigo, nombre, nivel, duracionHoras, precio);
        this.chefInstructor = chefInstructor;
        this.cuposDisponibles = cuposDisponibles;
        this.sala = sala;
    }
    
    public Chef getChefInstructor() {
        return chefInstructor;
    }
    
    public void setChefInstructor(Chef chefInstructor) {
        this.chefInstructor = chefInstructor;
    }
    
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }
    
    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }
    
    public String getSala() {
        return sala;
    }
    
    public void setSala(String sala) {
        this.sala = sala;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        if (chefInstructor != null) {
            System.out.println("Chef Instructor: " + chefInstructor.getNombre());
        }
        System.out.println("Cupos Disponibles: " + cuposDisponibles);
        System.out.println("Sala: " + sala);
        System.out.println("Tipo: Curso Presencial");
    }
    
    @Override
    public double calcularPrecioFinal() {
        return this.precio;
    }
    
    @Override
    public String obtenerTipo() {
        return "Curso Presencial";
    }
    
    public boolean hayCupos() {
        return cuposDisponibles > 0;
    }
}

