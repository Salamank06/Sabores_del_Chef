public class Chef {
    private String id;
    private String nombre;
    private String especialidad;
    private int añosExperiencia;
    
    public Chef(String id, String nombre, String especialidad, int añosExperiencia) {
        setId(id);
        setNombre(nombre);
        setEspecialidad(especialidad);
        setAñosExperiencia(añosExperiencia);
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
        if (!validarId(id)) {
            throw new IllegalArgumentException("ID inválido: debe tener formato CHEF-XXX");
        }
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (!validarNombre(nombre)) {
            throw new IllegalArgumentException("Nombre inválido: no puede ser nulo ni vacío");
        }
        this.nombre = nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        if (!validarNombre(especialidad)) {
            throw new IllegalArgumentException("Especialidad inválida: no puede ser nula ni vacía");
        }
        this.especialidad = especialidad;
    }
    
    public int getAñosExperiencia() {
        return añosExperiencia;
    }
    
    public void setAñosExperiencia(int añosExperiencia) {
        if (añosExperiencia < 0 || añosExperiencia > 50) {
            throw new IllegalArgumentException("Años de experiencia fuera de rango válido (0-50)");
        }
        this.añosExperiencia = añosExperiencia;
    }
    
    public String obtenerInformacion() {
        return "Chef: " + nombre + " | Especialidad: " + especialidad + " | Experiencia: " + añosExperiencia + " años";
    }
    
    public boolean esExperto() {
        return añosExperiencia >= 10;
    }
    
    private boolean validarId(String id) {
        return id != null && id.length() >= 5 && id.startsWith("CHEF-");
    }
    
    private boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
}

