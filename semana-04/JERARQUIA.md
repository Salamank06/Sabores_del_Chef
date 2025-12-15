# Jerarquía de Clases - Semana 04

## Diagrama

```
        Content (clase abstracta)
              |
      +-------+-------+-------+
      |               |       |
CursoPresencial  CursoOnline  Taller
```

## Justificación

Se eligió esta jerarquía porque en una escuela de cocina existen diferentes tipos de contenido educativo, cada uno con características específicas pero compartiendo atributos comunes:

- **Content (clase padre)**: Representa cualquier contenido educativo ofrecido por la escuela. Es abstracta porque no tiene sentido instanciar un "contenido genérico", siempre será un tipo específico.

- **CursoPresencial**: Cursos que se imparten físicamente en la escuela, requieren sala, chef instructor y tienen cupos limitados.

- **CursoOnline**: Cursos que se imparten de forma virtual, tienen plataforma específica, pueden tener acceso vitalicio y número de videos incluidos.

- **Taller**: Talleres prácticos de corta duración, con tema específico, pueden incluir materiales y tienen límite de participantes.

## Atributos Heredados (protected)

- `codigo` (String): Código único del contenido
- `nombre` (String): Nombre del contenido
- `nivel` (String): Nivel de dificultad (Básico, Intermedio, Avanzado)
- `duracionHoras` (int): Duración en horas
- `precio` (double): Precio base del contenido

## Métodos Heredados

### Métodos de la clase padre (Content)

1. **`mostrarInfo()`**: Muestra información básica del contenido
   - Heredado y sobrescrito en todas las subclases para agregar información específica

2. **`calcularPrecioFinal()`**: Método abstracto que calcula el precio final
   - **CursoPresencial**: Retorna el precio base sin modificaciones
   - **CursoOnline**: Si tiene acceso vitalicio, aumenta el precio en 20%
   - **Taller**: Si incluye materiales, aumenta el precio en 15%

3. **`obtenerTipo()`**: Retorna el tipo de contenido
   - Sobrescrito en cada subclase para retornar su tipo específico

## Métodos Sobrescritos (@Override)

### CursoPresencial
- `mostrarInfo()`: Agrega información de chef instructor, cupos y sala
- `calcularPrecioFinal()`: Retorna precio base
- `obtenerTipo()`: Retorna "Curso Presencial"

### CursoOnline
- `mostrarInfo()`: Agrega información de plataforma, acceso vitalicio y videos
- `calcularPrecioFinal()`: Calcula precio con incremento del 20% si es vitalicio
- `obtenerTipo()`: Retorna "Curso Online"

### Taller
- `mostrarInfo()`: Agrega información de chef, tema, materiales y participantes
- `calcularPrecioFinal()`: Calcula precio con incremento del 15% si incluye materiales
- `obtenerTipo()`: Retorna "Taller"

## Métodos Específicos de Subclases

### CursoPresencial
- `hayCupos()`: Verifica si hay cupos disponibles

### CursoOnline
- `obtenerInformacionAcceso()`: Retorna información sobre el tipo de acceso

### Taller
- `calcularPrecioPorPersona(int participantes)`: Calcula precio con descuento si se alcanza el máximo de participantes

## Beneficios de la Herencia

1. **Reutilización de código**: Los atributos y métodos comunes se definen una sola vez en la clase padre
2. **Mantenibilidad**: Cambios en atributos comunes solo requieren modificar la clase padre
3. **Polimorfismo**: Permite tratar diferentes tipos de contenido de manera uniforme
4. **Extensibilidad**: Fácil agregar nuevos tipos de contenido sin modificar código existente
5. **Organización**: Estructura clara y lógica del código
