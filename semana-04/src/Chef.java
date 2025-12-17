public class Chef {
    private String id;
    private String nombre;
    private String especialidad;
    private int añosExperiencia;
    
    public Chef(String id, String nombre, String especialidad, int añosExperiencia) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
    }
    
    public Chef(String id, String nombre, String especialidad) {
        this(id, nombre, especialidad, 0);
    }
    
    public Chef(String nombre) {
        this("CHEF-000", nombre, "General", 0);
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public int getAñosExperiencia() {
        return añosExperiencia;
    }
    
    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
    
    public String obtenerInformacion() {
        return "Chef: " + nombre + " | Especialidad: " + especialidad + " | Experiencia: " + añosExperiencia + " años";
    }
    
    public boolean esExperto() {
        return añosExperiencia >= 10;
    }
}

