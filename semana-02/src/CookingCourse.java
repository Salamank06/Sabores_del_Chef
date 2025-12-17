public class CookingCourse {
    private String courseCode;
    private String name;
    private String level;
    private Chef chefInstructor;
    private int duracionHoras;
    private double precio;
    
    public CookingCourse(String courseCode, String name, String level, Chef chefInstructor, int duracionHoras, double precio) {
        this.courseCode = courseCode;
        this.name = name;
        this.level = level;
        this.chefInstructor = chefInstructor;
        this.duracionHoras = duracionHoras;
        this.precio = precio;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLevel() {
        return level;
    }
    
    public void setLevel(String level) {
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
        this.duracionHoras = duracionHoras;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
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
        return precio * (porcentaje / 100);
    }
}

