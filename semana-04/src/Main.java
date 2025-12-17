public class Main {
    public static void main(String[] args) {
        System.out.println("=== ESCUELA DE COCINA: SABORES DEL CHEF ===\n");
        System.out.println("=== SEMANA 04: HERENCIA Y POLIMORFISMO ===\n");
        
        Chef chef1 = new Chef("CHEF-001", "María González", "Cocina Colombiana", 15);
        Chef chef2 = new Chef("CHEF-002", "Carlos Ramírez", "Repostería", 8);
        Chef chef3 = new Chef("CHEF-003", "Ana Martínez", "Cocina Internacional", 12);
        
        CursoPresencial curso1 = new CursoPresencial(
            "COOK-001", 
            "Cocina Colombiana", 
            "Básico", 
            40, 
            500000, 
            chef1, 
            20, 
            "Sala A"
        );
        
        CursoOnline curso2 = new CursoOnline(
            "ONLINE-001", 
            "Repostería Francesa", 
            "Intermedio", 
            60, 
            400000, 
            "Plataforma Virtual", 
            true, 
            25
        );
        
        Taller taller1 = new Taller(
            "TALLER-001", 
            "Pasta Artesanal", 
            "Básico", 
            4, 
            150000, 
            chef3, 
            "Elaboración de pasta fresca", 
            true, 
            12
        );
        
        CursoPresencial curso3 = new CursoPresencial(
            "COOK-002", 
            "Cocina Italiana", 
            "Avanzado", 
            80, 
            1000000, 
            chef3, 
            15, 
            "Sala B"
        );
        
        Taller taller2 = new Taller(
            "TALLER-002", 
            "Decoración de Pasteles", 
            "Intermedio", 
            6, 
            200000, 
            chef2, 
            "Técnicas de decoración", 
            true, 
            10
        );
        
        System.out.println("=== DEMOSTRACIÓN DE POLIMORFISMO ===\n");
        
        Content[] contenidos = new Content[5];
        contenidos[0] = curso1;
        contenidos[1] = curso2;
        contenidos[2] = taller1;
        contenidos[3] = curso3;
        contenidos[4] = taller2;
        
        System.out.println("--- Recorriendo array polimórfico ---\n");
        for (Content contenido : contenidos) {
            System.out.println("Tipo: " + contenido.obtenerTipo());
            contenido.mostrarInfo();
            System.out.println("Precio Final: $" + contenido.calcularPrecioFinal());
            System.out.println("---\n");
        }
        
        System.out.println("\n=== INFORMACIÓN ESPECÍFICA POR TIPO ===\n");
        
        for (Content contenido : contenidos) {
            if (contenido instanceof CursoPresencial) {
                CursoPresencial cursoPresencial = (CursoPresencial) contenido;
                System.out.println("Curso Presencial: " + cursoPresencial.getNombre());
                System.out.println("¿Hay cupos? " + cursoPresencial.hayCupos());
                System.out.println("Sala: " + cursoPresencial.getSala());
            } else if (contenido instanceof CursoOnline) {
                CursoOnline cursoOnline = (CursoOnline) contenido;
                System.out.println("Curso Online: " + cursoOnline.getNombre());
                System.out.println("Plataforma: " + cursoOnline.getPlataforma());
                System.out.println("Acceso: " + cursoOnline.obtenerInformacionAcceso());
            } else if (contenido instanceof Taller) {
                Taller taller = (Taller) contenido;
                System.out.println("Taller: " + taller.getNombre());
                System.out.println("Tema: " + taller.getTemaEspecifico());
                System.out.println("Máx. Participantes: " + taller.getMaxParticipantes());
            }
            System.out.println("---\n");
        }
        
        System.out.println("\n=== RESUMEN DE PRECIOS ===\n");
        double totalPrecios = 0;
        for (Content contenido : contenidos) {
            totalPrecios += contenido.calcularPrecioFinal();
        }
        System.out.println("Total de precios: $" + totalPrecios);
        System.out.println("Promedio de precios: $" + (totalPrecios / contenidos.length));
    }
}
