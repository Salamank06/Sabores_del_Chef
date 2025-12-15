# Semana 02 - Clases y Objetos

## Descripción

Implementación de clases relacionadas con el dominio de la Escuela de Cocina "Sabores del Chef", incluyendo relaciones entre objetos y uso de ArrayList.

## Estructura de Archivos

- `Chef.java` - Clase que representa a un chef instructor
- `Estudiante.java` - Clase que representa a un estudiante
- `CookingCourse.java` - Clase que representa un curso de cocina (actualizada con relaciones)
- `Inscripcion.java` - Clase que relaciona estudiantes con cursos
- `EscuelaCocina.java` - Clase gestora que maneja colecciones con ArrayList
- `Main.java` - Clase principal con demostración completa

## Características Implementadas

### Ejercicio 1: Nuevas Clases (30 puntos)
- ✅ **Chef**: Clase con 4 atributos, constructor, getters/setters y métodos de negocio
- ✅ **Estudiante**: Clase con 4 atributos, constructor, getters/setters y métodos de negocio

### Ejercicio 2: Relaciones entre Objetos (25 puntos)
- ✅ **CookingCourse** tiene relación con **Chef** (composición)
- ✅ **Inscripcion** relaciona **Estudiante** con **CookingCourse** (agregación)

### Ejercicio 3: Uso de ArrayList (20 puntos)
- ✅ **EscuelaCocina** utiliza ArrayList para gestionar:
  - Lista de cursos
  - Lista de estudiantes
  - Lista de chefs
  - Lista de inscripciones
- ✅ Métodos para agregar, mostrar y contar elementos

### Ejercicio 4: Main Completo (25 puntos)
- ✅ Creación de múltiples objetos
- ✅ Establecimiento de relaciones
- ✅ Uso de ArrayList a través de la clase gestora
- ✅ Demostración de todas las funcionalidades

## Instrucciones de Compilación y Ejecución

### Compilación

```bash
javac *.java
```

### Ejecución

```bash
java Main
```

## Salida Esperada

El programa mostrará:
- Lista de chefs instructores
- Lista de cursos disponibles con su información completa
- Lista de estudiantes registrados
- Lista de inscripciones realizadas
- Estadísticas generales de la escuela
- Información adicional sobre validaciones y cálculos

