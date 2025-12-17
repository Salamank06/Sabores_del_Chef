public class CookingCourse {
    String courseCode;
    String name;
    String level;
    
    public CookingCourse(String courseCode, String name, String level) {
        this.courseCode = courseCode;
        this.name = name;
        this.level = level;
    }
    
    public void showInfo() {
        System.out.println("Código: " + courseCode);
        System.out.println("Nombre: " + name);
        System.out.println("Nivel: " + level);
    }
}

