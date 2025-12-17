# Análisis de Diseño - Semana 06: Escuela de Cocina

## 1. Identificación de Abstracciones

### Clase Abstracta: Content

**¿Por qué es abstracta?**
- `Content` representa el concepto general de "contenido educativo" en la escuela de cocina
- Todos los contenidos educativos (cursos online, cursos presenciales, talleres) comparten atributos comunes (código, nombre, nivel, duración, precio)
- El comportamiento común incluye mostrar información básica y gestionar atributos
- El comportamiento que varía entre subclases incluye:
  - Cálculo del precio final (cada tipo tiene su propia fórmula)
  - Tiempo de preparación del contenido
  - Tipo específico de contenido

**Jerarquía:**
```
Content (abstracta)
├── CursoOnline
├── CursoPresencial
└── Taller
```

**Métodos Abstractos:**
- `calcularPrecioFinal()`: Cada tipo de contenido calcula su precio de forma diferente
- `obtenerTipo()`: Cada subclase retorna su tipo específico
- `calcularTiempoPreparacion()`: El tiempo de preparación varía según el tipo

**Métodos Concretos:**
- `mostrarInfo()`: Implementación común que todas las subclases pueden reutilizar
- Getters y Setters: Acceso común a todos los atributos protegidos

---

## 2. Interfaces Implementadas

### Interface 1: Reservable
**Capacidad que define:** Capacidad de gestionar reservas de cupos/participantes

**Métodos:**
- `boolean verificarDisponibilidad(String fecha)`
- `void realizarReserva(String nombreEstudiante, String fecha)`
- `void cancelarReserva(String codigoReserva)`
- `String obtenerCodigoReserva()`

**Clases que la implementan:**
- **CursoPresencial**: Tiene sentido porque los cursos presenciales tienen cupos limitados y requieren reservas anticipadas para gestionar la sala y el chef
- **Taller**: Tiene sentido porque los talleres son eventos con número máximo de participantes y requieren coordinación de materiales

**Por qué NO la implementa CursoOnline:**
Los cursos online no necesitan reservas porque típicamente son de acceso inmediato y sin límite de participantes simultáneos.

---

### Interface 2: Calificable
**Capacidad que define:** Capacidad de recibir y gestionar calificaciones de estudiantes

**Métodos:**
- `void agregarCalificacion(int estrellas, String comentario)`
- `double obtenerPromedioCalificaciones()`
- `int obtenerNumeroCalificaciones()`
- `void mostrarCalificaciones()`

**Clases que la implementan:**
- **CursoPresencial**: Tiene sentido porque los estudiantes pueden calificar la calidad del curso, el instructor y las instalaciones
- **CursoOnline**: Tiene sentido porque las plataformas online dependen de calificaciones para mejorar contenido y atraer nuevos estudiantes

**Por qué NO la implementa Taller:**
Los talleres son eventos únicos y cortos, no requieren sistema de calificaciones formal (aunque podría agregarse en el futuro).

---

### Interface 3: Certificable
**Capacidad que define:** Capacidad de emitir certificados de finalización a los estudiantes

**Métodos:**
- `boolean cumpleRequisitosCertificacion()`
- `void emitirCertificado(String nombreEstudiante)`
- `String obtenerNumeroCertificado()`

**Clases que la implementan:**
- **CursoPresencial**: Tiene sentido porque los cursos largos (30+ horas) con instructor presencial emiten certificados oficiales
- **CursoOnline**: Tiene sentido porque los cursos online de duración considerable (20+ horas) pueden emitir certificados digitales

**Por qué NO la implementa Taller:**
Los talleres son demasiado cortos (típicamente 4-8 horas) y no cumplen requisitos para certificación formal.

---

## 3. Decisiones de Diseño

### ¿Por qué Clase Abstracta vs Interface?

**Elegí clase abstracta para Content porque:**
1. **Relación "es-un" clara**: Un CursoOnline ES-UN Content, un Taller ES-UN Content
2. **Necesidad de compartir estado (atributos)**: Todos los contenidos tienen código, nombre, nivel, duración y precio
3. **Comportamiento común implementable**: El método `mostrarInfo()` es igual para todos, no tiene sentido duplicarlo
4. **Constructor compartido**: Todos los contenidos se inicializan de la misma forma
5. **Jerarquía natural**: Existe una relación jerárquica clara entre el concepto general (Content) y los específicos

**Elegí interfaces para Reservable, Calificable y Certificable porque:**
1. **Capacidades independientes**: Son habilidades que pueden o no tener los contenidos, no definen su esencia
2. **No hay relación jerárquica**: Reservable no es padre de CursoPresencial, es una capacidad que posee
3. **Múltiple implementación necesaria**: CursoPresencial necesita ser Reservable + Calificable + Certificable simultáneamente
4. **Sin estado compartido**: Las interfaces solo definen comportamiento, cada clase maneja su propio estado interno
5. **Ortogonales a la jerarquía**: Un Taller puede ser Reservable sin estar relacionado con un CursoOnline que es Calificable

**Comparación:**
| Criterio | Content (Abstracta) | Reservable, Calificable, Certificable (Interfaces) |
|----------|---------------------|---------------------------------------------------|
| Relación | "es-un" | "puede-hacer" / "tiene-capacidad-de" |
| Atributos | Sí (protected) | No |
| Implementación | Métodos concretos | Solo contratos |
| Herencia | Simple (extends) | Múltiple (implements) |
| Propósito | Definir esencia | Definir capacidades |

---

## 4. Principios SOLID Aplicados

### Single Responsibility Principle (SRP) ✅
**Aplicación:**
- **Content**: Responsabilidad única de representar contenido educativo genérico
- **Reservable**: Responsabilidad única de gestionar reservas
- **Calificable**: Responsabilidad única de gestionar calificaciones
- **Certificable**: Responsabilidad única de gestionar certificaciones
- **CursoPresencial**: Responsabilidad única de representar un curso presencial (delega reservas, calificaciones y certificados a las interfaces)

**Beneficio:** Cada clase/interface tiene un solo motivo para cambiar. Si cambian las reglas de reservas, solo modifico la interface Reservable y sus implementaciones.

---

### Open/Closed Principle (OCP) ✅
**Aplicación:**
- Puedo agregar nuevos tipos de contenido (ej: `Masterclass`, `CursoHibrido`) sin modificar `Content` ni las interfaces existentes
- Puedo agregar nuevas capacidades (ej: `Evaluable`, `Compartible`) sin modificar las clases existentes

**Ejemplo:**
```java
public class Masterclass extends Content implements Reservable, Calificable, Certificable {
    // Nueva clase sin modificar código existente
}
```

**Beneficio:** El sistema está **abierto a extensión** (agregar) pero **cerrado a modificación** (no cambiar lo existente).

---

### Liskov Substitution Principle (LSP) ✅
**Aplicación:**
- Cualquier lugar que espere un `Content` puede recibir un `CursoOnline`, `CursoPresencial` o `Taller` sin problemas
- El método `procesarContenido(Content c)` funciona con cualquier subclase

**Demostración en Main.java:**
```java
Content[] contenidos = new Content[3];
contenidos[0] = curso1;  // CursoPresencial
contenidos[1] = curso2;  // CursoOnline
contenidos[2] = taller1; // Taller

for (Content c : contenidos) {
    c.calcularPrecioFinal();  // Funciona correctamente para todos
}
```

**Beneficio:** Las subclases son sustituibles por la clase padre sin romper el programa.

---

### Interface Segregation Principle (ISP) ✅
**Aplicación:**
- **CursoPresencial** implementa 3 interfaces porque necesita las 3 capacidades
- **CursoOnline** implementa solo 2 interfaces (Calificable y Certificable) porque no necesita reservas
- **Taller** implementa solo 1 interface (Reservable) porque no necesita calificaciones ni certificados

**Contrario (lo que se evita):**
```java
// ❌ INCORRECTO: Interface gigante que obliga a implementar todo
interface ContenidoCompleto {
    void realizarReserva(...);
    void agregarCalificacion(...);
    void emitirCertificado(...);
    // Taller tendría que implementar todos aunque no los use
}
```

**Beneficio:** Ninguna clase se ve obligada a implementar métodos que no necesita.

---

### Dependency Inversion Principle (DIP) ✅
**Aplicación:**
- El código de alto nivel (Main) depende de abstracciones (Content, Reservable, Calificable) no de implementaciones concretas
- Puedo cambiar las implementaciones sin afectar el código que las usa

**Demostración:**
```java
// Dependo de la interface, no de la implementación
Reservable reservable = curso1;  // Podría ser cualquier Reservable
reservable.realizarReserva(...);

Calificable calificable = curso2;  // Podría ser cualquier Calificable
calificable.agregarCalificacion(...);
```

**Beneficio:** Bajo acoplamiento, fácil de mantener y probar.

---

## 5. Mejoras Logradas

### Antes (Semana 05):
- Clases concretas con toda la funcionalidad mezclada
- Difícil agregar nuevas capacidades sin modificar clases existentes
- Código duplicado en múltiples clases
- Sin separación clara entre "qué es" (herencia) y "qué puede hacer" (interfaces)

**Problemas identificados:**
- Si quería que un Taller tuviera calificaciones, debía agregar todo el código de calificaciones desde cero
- No había forma de tratar objetos por sus capacidades independientemente de su tipo
- Violación de SRP: clases hacían demasiado

### Después (Semana 06):
- Separación clara entre abstracción (Content) y capacidades (Interfaces)
- Fácil agregar nuevas capacidades: solo implementar la interface
- Código reutilizable y modular
- Cumple con SOLID

**Mejoras específicas:**
1. **Modularidad**: Puedo agregar la capacidad de reserva a cualquier clase simplemente con `implements Reservable`
2. **Flexibilidad**: CursoPresencial puede tener 3 capacidades, mientras Taller solo 1
3. **Mantenibilidad**: Cambiar cómo funcionan las calificaciones solo requiere modificar la interface y sus implementaciones
4. **Testabilidad**: Puedo hacer tests unitarios de cada capacidad independientemente

---

## 6. Diagrama de Clases

```
        <<abstract>>
          Content
            |
            | (extends)
            |
    +-------+-------+
    |       |       |
CursoOline  |    Taller
    |   CursoPres   |
    |       |       |
    |       +-------+
    |       |       
    |       +-- implements Reservable
    |       +-- implements Calificable
    |       +-- implements Certificable
    |
    +-- implements Calificable
    +-- implements Certificable


<<interface>>     <<interface>>     <<interface>>
 Reservable        Calificable      Certificable
     ^                  ^                ^
     |                  |                |
     |                  +-------+--------+
     |                          |
     +---------------+----------+
                     |
                 CursoPresencial


<<interface>>     <<interface>>
 Calificable      Certificable
     ^                 ^
     |                 |
     +--------+--------+
              |
          CursoOnline


<<interface>>
 Reservable
     ^
     |
   Taller
```

---

## 7. Desafíos y Soluciones

### Desafío 1: Decidir qué debe ser clase abstracta vs interface
**Problema:** Al principio no estaba claro si Reservable debía ser una clase abstracta o interface.

**Solución:** Apliqué la regla: "Si define QUÉ ES el objeto → clase abstracta, si define QUÉ PUEDE HACER → interface". Reservable define una capacidad (puede hacer reservas), no la esencia del objeto, por lo tanto es una interface.

---

### Desafío 2: Evitar duplicación de código en las implementaciones
**Problema:** CursoPresencial y CursoOnline ambos implementan Calificable y Certificable, con código muy similar.

**Solución:** Aunque hay similitud, mantuve las implementaciones separadas porque:
1. Los requisitos de certificación son diferentes (30 horas presencial vs 20 horas online)
2. En el futuro podrían divergir más
3. Cumple con SRP: cada clase gestiona su propio estado

**Alternativa considerada:** Podría crear una clase helper `GestorCalificaciones` si la duplicación crece mucho en el futuro.

---

### Desafío 3: Organización de archivos con paquetes
**Problema:** Con paquetes (abstractas, interfaces, implementaciones), los imports y compilación son más complejos.

**Solución:** 
- Usé paquetes apropiados en cada archivo
- Documenté claramente los comandos de compilación en el README
- Compilé con `javac -encoding UTF-8` para soportar caracteres especiales

---

## 8. Próximos Pasos

### Mejoras Potenciales:

1. **Nueva Interface: `Evaluable`**
   - Para contenidos que requieren evaluaciones periódicas
   - Métodos: `realizarEvaluacion()`, `obtenerResultado()`, `aprobo()`
   - Implementada por: CursoPresencial, CursoOnline

2. **Nueva Interface: `Descuentable`**
   - Para aplicar descuentos especiales
   - Métodos: `aplicarDescuento(double porcentaje)`, `esElegibleDescuento()`

3. **Clase Abstracta Intermedia: `CursoConInstructor`**
   - Entre Content y CursoPresencial/Taller
   - Para compartir lógica relacionada con Chef

4. **Persistencia de datos**
   - Interfaces para guardar/cargar reservas, calificaciones y certificados
   - Base de datos o archivos

5. **Patrón Strategy**
   - Para diferentes estrategias de cálculo de precio
   - Para diferentes estrategias de certificación

---

## 9. Conclusión

La aplicación de abstracción e interfaces en el sistema de Sabores del Chef ha mejorado significativamente:
- **Mantenibilidad**: Cambios localizados y menos propensos a errores
- **Extensibilidad**: Fácil agregar nuevos tipos de contenido o capacidades
- **Claridad**: Separación clara entre jerarquía y capacidades
- **Cumplimiento SOLID**: Los 5 principios aplicados correctamente

El diseño está preparado para crecer y adaptarse a nuevos requisitos sin requerir refactorizaciones masivas.
