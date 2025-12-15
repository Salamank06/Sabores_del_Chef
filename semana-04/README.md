# Semana 04 - Herencia

## Descripción

Implementación de jerarquía de clases y herencia para el dominio de la Escuela de Cocina "Sabores del Chef". Se crea una clase padre abstracta `Content` y tres subclases que representan diferentes tipos de contenido educativo.

## Estructura de Archivos

- `Content.java` - Clase padre abstracta con atributos protected
- `CursoPresencial.java` - Subclase para cursos presenciales
- `CursoOnline.java` - Subclase para cursos online
- `Taller.java` - Subclase para talleres prácticos
- `Chef.java` - Clase auxiliar para chefs instructores
- `Main.java` - Demostración de polimorfismo
- `JERARQUIA.md` - Documentación de la jerarquía

## Características Implementadas

### Ejercicio 1: Clase Padre (25 puntos)
- ✅ Clase `Content` abstracta con atributos `protected`
- ✅ Constructor completo
- ✅ Métodos `mostrarInfo()` y `calcularPrecioFinal()` (abstracto)
- ✅ Método `obtenerTipo()` heredable

### Ejercicio 2: Subclases (30 puntos)
- ✅ **CursoPresencial**: Hereda de Content, agrega chef, cupos y sala
- ✅ **CursoOnline**: Hereda de Content, agrega plataforma, acceso vitalicio y videos
- ✅ **Taller**: Hereda de Content, agrega chef, tema, materiales y participantes

### Ejercicio 3: Implementación Correcta (25 puntos)
- ✅ Uso correcto de `extends` en todas las subclases
- ✅ `super()` en todos los constructores de subclases
- ✅ `@Override` en métodos sobrescritos
- ✅ Atributos `protected` en clase padre

### Ejercicio 4: Polimorfismo (20 puntos)
- ✅ Array polimórfico de tipo `Content[]`
- ✅ Recorrido polimórfico mostrando información
- ✅ Uso de `instanceof` para acceder a métodos específicos
- ✅ Demostración de métodos abstractos y sobrescritos

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
- Demostración de polimorfismo con array de contenidos
- Información de cada tipo de contenido
- Precios finales calculados según el tipo
- Información específica usando `instanceof`
- Resumen de precios totales y promedio

## Jerarquía de Clases

```
        Content (abstracta)
              |
      +-------+-------+-------+
      |               |       |
CursoPresencial  CursoOnline  Taller
```

Ver `JERARQUIA.md` para documentación detallada.

