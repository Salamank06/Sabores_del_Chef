public class Estudiante {
    private String documento;
    private String nombre;
    private String email;
    private String telefono;
    
    public Estudiante(String documento, String nombre, String email, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String obtenerInformacion() {
        return "Estudiante: " + nombre + " | Documento: " + documento + " | Email: " + email;
    }
    
    public boolean tieneEmailValido() {
        return email != null && email.contains("@");
    }
}

