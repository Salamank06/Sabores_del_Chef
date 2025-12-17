public class Estudiante {
    private String documento;
    private String nombre;
    private String email;
    private String telefono;
    
    public Estudiante(String documento, String nombre, String email, String telefono) {
        setDocumento(documento);
        setNombre(nombre);
        setEmail(email);
        setTelefono(telefono);
    }
    
    public Estudiante(String documento, String nombre, String email) {
        this(documento, nombre, email, "Sin teléfono");
    }
    
    public Estudiante(String documento, String nombre) {
        this(documento, nombre, nombre.toLowerCase().replace(" ", ".") + "@email.com");
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public void setDocumento(String documento) {
        if (!validarDocumento(documento)) {
            throw new IllegalArgumentException("Documento inválido: debe tener entre 7 y 15 caracteres");
        }
        this.documento = documento;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido: debe contener @ y tener formato válido");
        }
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.equals("Sin teléfono") && !validarTelefono(telefono)) {
            throw new IllegalArgumentException("Teléfono inválido: debe tener 10 dígitos");
        }
        this.telefono = telefono;
    }
    
    public String obtenerInformacion() {
        return "Estudiante: " + nombre + " | Documento: " + documento + " | Email: " + email;
    }
    
    public boolean tieneEmailValido() {
        return email != null && email.contains("@");
    }
    
    private boolean validarDocumento(String documento) {
        return documento != null && documento.length() >= 7 && documento.length() <= 15;
    }
    
    private boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
    
    private boolean validarEmail(String email) {
        return email != null && email.contains("@") && email.length() >= 5;
    }
    
    private boolean validarTelefono(String telefono) {
        return telefono != null && telefono.matches("\\d{10}");
    }
}

