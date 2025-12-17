# Semana 06: Abstracción e Interfaces

## Dominio
**Escuela de Cocina - Sabores del Chef**

## Descripción
Sistema de gestión de contenidos educativos para una escuela de cocina que implementa abstracción mediante clases abstractas e interfaces para representar diferentes tipos de cursos y sus capacidades específicas. El sistema aplica principios SOLID para lograr un diseño flexible, extensible y mantenible.

---

## Clases Abstractas Implementadas

### Content
- **Propósito:** Representar el concepto general de contenido educativo en la escuela de cocina
- **Ubicación:** `abstractas/Content.java`
- **Atributos protegidos:**
  - `codigo`: Identificador único del contenido
  - `nombre`: Nombre del curso/taller
  - `nivel`: Nivel de dificultad (Básico, Intermedio, Avanzado)
  - `duracionHoras`: Duración en horas
  - `precio`: Precio base

- **Métodos abstractos:**
  - `calcularPrecioFinal()`: Calcula el precio final considerando factores específicos de cada tipo
  - `obtenerTipo()`: Retorna el tipo específico de contenido
  - `calcularTiempoPreparacion()`: Calcula las horas de preparación requeridas

- **Métodos concretos:**
  - `mostrarInfo()`: Muestra la información básica común a todos los contenidos
  - Getters y Setters para todos los atributos

- **Subclases:**
  - `CursoOnline`: Cursos virtuales con acceso a plataforma
  - `CursoPresencial`: Cursos con instructor físico en instalaciones
  - `Taller`: Sesiones cortas e intensivas sobre temas específicos

---

## Interfaces Implementadas

### Reservable
- **Capacidad:** Gestión de reservas y cupos
- **Ubicación:** `interfaces/Reservable.java`
- **Métodos:**
  - `verificarDisponibilidad(String fecha)`: Verifica si hay cupos disponibles
  - `realizarReserva(String nombreEstudiante, String fecha)`: Crea una reserva
  - `cancelarReserva(String codigoReserva)`: Cancela una reserva existente
  - `obtenerCodigoReserva()`: Obtiene el último código de reserva generado

- **Implementada por:**
  - `CursoPresencial`: Gestiona cupos limitados por sala y chef
  - `Taller`: Gestiona participantes limitados por materiales y espacio

### Calificable
- **Capacidad:** Sistema de calificaciones y retroalimentación
- **Ubicación:** `interfaces/Calificable.java`
- **Métodos:**
  - `agregarCalificacion(int estrellas, String comentario)`: Agrega una calificación (1-5 estrellas)
  - `obtenerPromedioCalificaciones()`: Calcula el promedio de calificaciones
  - `obtenerNumeroCalificaciones()`: Retorna el total de calificaciones recibidas
  - `mostrarCalificaciones()`: Muestra un resumen de las calificaciones

- **Implementada por:**
  - `CursoPresencial`: Para evaluar calidad del curso e instructor
  - `CursoOnline`: Para mejorar contenido digital y atraer estudiantes

### Certificable
- **Capacidad:** Emisión de certificados de finalización
- **Ubicación:** `interfaces/Certificable.java`
- **Métodos:**
  - `cumpleRequisitosCertificacion()`: Verifica si el curso cumple requisitos mínimos
  - `emitirCertificado(String nombreEstudiante)`: Emite un certificado oficial
  - `obtenerNumeroCertificado()`: Genera número único de certificado

- **Implementada por:**
  - `CursoPresencial`: Certificados para cursos de 30+ horas con instructor
  - `CursoOnline`: Certificados digitales para cursos de 20+ horas

---

## Jerarquía de Clases

```
            <<abstract>>
              Content
                |
                | (extends)
                |
        +-------+-------+
        |       |       |
   CursoOnline  |    Taller
        |  CursoPres   |
        |       |       |
        |       +-------+
        |       |       
        |       +-- implements Reservable
        |       +-- implements Calificable
        |       +-- implements Certificable
        |
        +-- implements Calificable
        +-- implements Certificable
```

### Tabla de Implementaciones

| Clase | Extends | Implements |
|-------|---------|------------|
| CursoPresencial | Content | Reservable, Calificable, Certificable |
| CursoOnline | Content | Calificable, Certificable |
| Taller | Content | Reservable |

---

## Principios SOLID Aplicados

### 1. Single Responsibility Principle (SRP) ✅
- Cada clase tiene una única responsabilidad claramente definida
- Content: representar contenido educativo
- Reservable: gestionar reservas
- Calificable: gestionar calificaciones
- Certificable: gestionar certificados

### 2. Open/Closed Principle (OCP) ✅
- Sistema abierto a extensión (nuevos tipos de contenido)
- Cerrado a modificación (no se modifica código existente)
- Ejemplo: Puedo agregar `Masterclass` sin tocar Content ni las interfaces

### 3. Liskov Substitution Principle (LSP) ✅
- Cualquier `Content` puede ser sustituido por sus subclases
- Método `procesarContenido(Content c)` funciona con todas las subclases

### 4. Interface Segregation Principle (ISP) ✅
- Interfaces específicas y enfocadas
- Cada clase implementa solo las interfaces que necesita
- No hay métodos obligatorios que no se usen

### 5. Dependency Inversion Principle (DIP) ✅
- Código de alto nivel depende de abstracciones
- Referencias de tipo `Content`, `Reservable`, `Calificable` en lugar de clases concretas

---

## Compilación y Ejecución

### Compilar

```bash
# Opción 1: Compilar todo desde la raíz del proyecto
javac -encoding UTF-8 semana-06/abstractas/*.java semana-06/interfaces/*.java semana-06/implementaciones/*.java semana-06/Main.java

# Opción 2: Desde dentro de semana-06
cd semana-06
javac -encoding UTF-8 abstractas/*.java interfaces/*.java implementaciones/*.java Main.java
```

### Ejecutar

```bash
# Desde la raíz del proyecto
java semana-06.Main

# Desde dentro de semana-06
java Main
```

**Nota:** El flag `-encoding UTF-8` es necesario para compilar correctamente en Windows debido a caracteres especiales (ñ, á, etc.).

---

## Salida Esperada

```
=== ESCUELA DE COCINA: SABORES DEL CHEF ===
=== SEMANA 06: ABSTRACCIÓN E INTERFACES ===

--- Sección 1: Polimorfismo con Clase Abstracta ---

Recorriendo array polimórfico de tipo Content:

>>> Curso Presencial: Cocina Colombiana Tradicional
    Precio Final: $625000.0
    Tiempo de Preparación: 120 horas
    Nivel: Básico

>>> Curso Online: Repostería Francesa
    Precio Final: $480000.0
    Tiempo de Preparación: 50 horas
    Nivel: Intermedio

>>> Taller: Pasta Artesanal
    Precio Final: $189750.0
    Tiempo de Preparación: 16 horas
    Nivel: Básico


--- Sección 2: Interfaces - Demostración Individual ---

=== Interface Reservable ===

Curso: Cocina Colombiana Tradicional
¿Disponible? true
Reserva realizada exitosamente
Estudiante: Juan Pérez
Código de reserva: RES-COOK-001-1
Reserva realizada exitosamente
Estudiante: María López
Código de reserva: RES-COOK-001-2

Último código de reserva: RES-COOK-001-2


Taller: Pasta Artesanal
Reserva realizada exitosamente para el taller
Estudiante: Carlos García
Código de reserva: TAL-TALLER-001-1


=== Interface Calificable ===

Curso: Repostería Francesa
Calificaciones de Repostería Francesa:
  Promedio: 4.666666666666667 estrellas
  Total de calificaciones: 3


Curso: Cocina Colombiana Tradicional
Calificaciones de Cocina Colombiana Tradicional:
  Promedio: 4.5 estrellas
  Total de calificaciones: 2


=== Interface Certificable ===

Curso: Repostería Francesa
¿Cumple requisitos? true
Certificado emitido para: Juan Pérez
Curso: Repostería Francesa
Número: CERT-ONLINE-ONLINE-001-1
Certificado emitido para: María López
Curso: Repostería Francesa
Número: CERT-ONLINE-ONLINE-001-2


Curso: Cocina Colombiana Tradicional
¿Cumple requisitos? true
Certificado emitido para: Carlos García
Curso: Cocina Colombiana Tradicional
Instructor: María González
Número: CERT-PRES-COOK-001-1


--- Sección 3: Múltiple Implementación ---

=== Curso Presencial (implementa 3 interfaces) ===

Curso: Cocina Colombiana Tradicional
Tipo real: CursoPresencial

Interfaces implementadas:
  1. Reservable
  2. Calificable
  3. Certificable

Demostración de capacidades:

> Como Reservable:
  - Verificar disponibilidad: true
Reserva realizada exitosamente
Estudiante: Ana Martínez
Código de reserva: RES-COOK-001-3

> Como Calificable:
  - Número de calificaciones: 2
  - Promedio: 4.5

> Como Certificable:
  - Cumple requisitos: true
  - Número de certificado: CERT-PRES-COOK-001-1


=== Curso Online (implementa 2 interfaces) ===

Curso: Repostería Francesa
Tipo real: CursoOnline

Interfaces implementadas:
  1. Calificable
  2. Certificable


--- Sección 4: Demostración de Diseño SOLID ---

=== Principio de Sustitución de Liskov (LSP) ===
Todas las subclases pueden sustituir a Content:

  Procesando: Cocina Colombiana Tradicional
  Tipo: Curso Presencial
  Precio: $625000.0
  Procesando: Repostería Francesa
  Tipo: Curso Online
  Precio: $480000.0
  Procesando: Pasta Artesanal
  Tipo: Taller
  Precio: $189750.0

=== Principio de Segregación de Interfaces (ISP) ===
Cada clase implementa solo las interfaces que necesita:

CursoPresencial -> Reservable + Calificable + Certificable
CursoOnline -> Calificable + Certificable
Taller -> Reservable

No todas las clases implementan todas las interfaces,
solo las que tienen sentido para su propósito.


--- Sección 5: Estadísticas Finales ---

Total de contenidos creados: 3
  - Cursos Presenciales: 1
  - Cursos Online: 1
  - Talleres: 1

Contenidos Reservables: 2 (Curso Presencial + Taller)
Contenidos Calificables: 2 (Cursos Presencial + Online)
Contenidos Certificables: 2 (Cursos Presencial + Online)

Total de contenidos con capacidad de reserva: 2

=== FIN DEL PROGRAMA ===
```

---

## Cambios Respecto a Semana 05

### Arquitectura
- ✅ Introducción de paquetes (abstractas, interfaces, implementaciones)
- ✅ Separación clara entre abstracción y capacidades
- ✅ Aplicación explícita de principios SOLID

### Clases
- ✅ Content movida a paquete `abstractas`
- ✅ Agregadas 3 interfaces: Reservable, Calificable, Certificable
- ✅ CursoPresencial ahora implementa 3 interfaces
- ✅ CursoOnline ahora implementa 2 interfaces
- ✅ Taller ahora implementa 1 interface

### Funcionalidad
- ✅ Sistema de reservas con códigos únicos
- ✅ Sistema de calificaciones con promedios
- ✅ Sistema de certificación con requisitos
- ✅ Demostración de múltiple implementación

### Documentación
- ✅ ANALISIS.md con justificación de diseño
- ✅ README.md completo con ejemplos
- ✅ Explicación de principios SOLID aplicados

---

## Mejoras Futuras

### Funcionalidades
- [ ] Interface `Evaluable` para exámenes y evaluaciones
- [ ] Interface `Descuentable` para promociones
- [ ] Sistema de persistencia de datos
- [ ] Notificaciones de reservas por email

### Diseño
- [ ] Patrón Factory para crear contenidos
- [ ] Patrón Observer para notificaciones
- [ ] Patrón Strategy para cálculos de precio
- [ ] Clase abstracta intermedia `CursoConInstructor`

### Técnico
- [ ] Validaciones más robustas
- [ ] Manejo de excepciones personalizadas
- [ ] Tests unitarios para cada interface
- [ ] Documentación JavaDoc

---

## Estructura de Archivos

```
semana-06/
├── README.md                              (Este archivo)
├── ANALISIS.md                            (Análisis de diseño)
├── Main.java                              (Programa de demostración)
├── abstractas/
│   └── Content.java                       (Clase abstracta padre)
├── interfaces/
│   ├── Calificable.java                   (Interface de calificaciones)
│   ├── Certificable.java                  (Interface de certificados)
│   └── Reservable.java                    (Interface de reservas)
└── implementaciones/
    ├── Chef.java                          (Clase auxiliar)
    ├── CursoOnline.java                   (Curso virtual)
    ├── CursoPresencial.java               (Curso físico)
    └── Taller.java                        (Taller corto)
```

---

## Estadísticas del Proyecto

- **Total de archivos Java:** 8
- **Clases abstractas:** 1
- **Interfaces:** 3
- **Clases concretas:** 4
- **Líneas de código:** ~900
- **Principios SOLID aplicados:** 5/5

---

## Autor
Estudiante de Bootcamp POO - Semana 06

## Fecha
Diciembre 2025

---

**¡El poder de la abstracción y las interfaces permite un diseño flexible y mantenible!** 🚀
