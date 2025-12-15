public class CookingCourse {
    private String courseCode;
    private String name;
    private String level;
    private Chef chefInstructor;
    private int duracionHoras;
    private double precio;
    
    public CookingCourse(String courseCode, String name, String level, Chef chefInstructor, int duracionHoras, double precio) {
        setCourseCode(courseCode);
        setName(name);
        setLevel(level);
        setChefInstructor(chefInstructor);
        setDuracionHoras(duracionHoras);
        setPrecio(precio);
    }
    
    public CookingCourse(String courseCode, String name, String level, int duracionHoras, double precio) {
        this(courseCode, name, level, null, duracionHoras, precio);
    }
    
    public CookingCourse(String courseCode, String name) {
        this(courseCode, name, "Básico", null, 20, 300000);
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public void setCourseCode(String courseCode) {
        if (!validarCodigo(courseCode)) {
            throw new IllegalArgumentException("Código de curso inválido: debe tener formato COOK-XXX");
        }
        this.courseCode = courseCode;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (!validarNombre(name)) {
            throw new IllegalArgumentException("Nombre inválido: no puede ser nulo ni vacío");
        }
        this.name = name;
    }
    
    public String getLevel() {
        return level;
    }
    
    public void setLevel(String level) {
        if (!validarNivel(level)) {
            throw new IllegalArgumentException("Nivel inválido: debe ser Básico, Intermedio o Avanzado");
        }
        this.level = level;
    }
    
    public Chef getChefInstructor() {
        return chefInstructor;
    }
    
    public void setChefInstructor(Chef chefInstructor) {
        this.chefInstructor = chefInstructor;
    }
    
    public int getDuracionHoras() {
        return duracionHoras;
    }
    
    public void setDuracionHoras(int duracionHoras) {
        if (duracionHoras <= 0 || duracionHoras > 200) {
            throw new IllegalArgumentException("Duración inválida: debe estar entre 1 y 200 horas");
        }
        this.duracionHoras = duracionHoras;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("Precio inválido: debe ser positivo");
        }
        this.precio = precio;
    }
    
    public void showInfo() {
        System.out.println("Código: " + courseCode);
        System.out.println("Nombre: " + name);
        System.out.println("Nivel: " + level);
        System.out.println("Duración: " + duracionHoras + " horas");
        System.out.println("Precio: $" + precio);
        if (chefInstructor != null) {
            System.out.println("Chef Instructor: " + chefInstructor.getNombre());
        }
    }
    
    public double calcularDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("Porcentaje de descuento inválido: debe estar entre 0 y 100");
        }
        return precio * (porcentaje / 100);
    }
    
    private boolean validarCodigo(String codigo) {
        return codigo != null && codigo.length() >= 8 && codigo.startsWith("COOK-");
    }
    
    private boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
    
    private boolean validarNivel(String nivel) {
        return nivel != null && (nivel.equals("Básico") || nivel.equals("Intermedio") || nivel.equals("Avanzado"));
    }
}

