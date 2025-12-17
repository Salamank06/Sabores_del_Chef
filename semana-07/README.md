# Semana 07: Paquetes y Excepciones

## 📝 Descripción del Proyecto

Sistema de gestión para una escuela de cocina que permite administrar cursos (presenciales, online y talleres), chefs instructores y reservas de estudiantes. El sistema implementa validaciones robustas mediante excepciones estándar y personalizadas, garantizando la integridad de los datos y una gestión confiable de las operaciones.

**Características principales:**
- Gestión de cursos presenciales, online y talleres
- Control de cupos y disponibilidad
- Validaciones exhaustivas de datos
- Manejo robusto de excepciones
- Organización profesional en paquetes

## 📦 Estructura de Paquetes

```
com.escuelaCocina/
├── modelo/              - Entidades del dominio (Chef, Content, CursoOnline, CursoPresencial, Taller)
├── servicio/            - Lógica de negocio (GestorCursos)
├── excepciones/         - Excepciones personalizadas del dominio
└── Main.java            - Punto de entrada y demostración
```

### Descripción de Paquetes

**`modelo/`**: Contiene todas las clases de entidades que representan los conceptos del dominio:
- `Chef`: Instructores de la escuela
- `Content`: Clase abstracta base para contenido educativo
- `CursoOnline`: Cursos virtuales con plataforma digital
- `CursoPresencial`: Cursos físicos con instructor y sala
- `Taller`: Sesiones cortas e intensivas

**`servicio/`**: Contiene la lógica de negocio y gestión:
- `GestorCursos`: Administra el catálogo de cursos, reservas y validaciones

**`excepciones/`**: Excepciones específicas del dominio:
- `CupoLlenoException`: Cuando no hay cupos disponibles
- `CursoInvalidoException`: Cuando un curso no cumple requisitos
- `ReservaInvalidaException`: Cuando una reserva tiene datos inválidos

## ⚠️ Excepciones Personalizadas

### 1. CupoLlenoException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: Cuando se intenta reservar un cupo en un curso/taller que ya está lleno
- **Ejemplo**: "El curso 'Cocina Colombiana Tradicional' no tiene cupos disponibles"
- **Uso**: Permite al sistema informar claramente cuando no hay disponibilidad

### 2. CursoInvalidoException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: 
  - Curso con duración menor a 2 horas
  - Código de curso duplicado
  - Curso no encontrado en el sistema
- **Ejemplo**: "La duración mínima de un curso es 2 horas"
- **Uso**: Valida que todos los cursos cumplan con los estándares de la escuela

### 3. ReservaInvalidaException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: Cuando los datos de una reserva son inválidos (nombre vacío, datos nulos)
- **Ejemplo**: "El nombre del estudiante no puede estar vacío"
- **Uso**: Garantiza que todas las reservas tengan información completa

## 🚀 Cómo Ejecutar

### Desde terminal (Windows PowerShell):

```powershell
# Navegar a la carpeta semana-07
cd semana-07

# Compilar con encoding UTF-8
javac -encoding UTF-8 -d bin src/com/escuelaCocina/*/*.java src/com/escuelaCocina/*.java

# Ejecutar
java -cp bin com.escuelaCocina.Main
```

### Desde terminal (Linux/Mac):

```bash
# Navegar a la carpeta semana-07
cd semana-07

# Compilar
javac -d bin src/com/escuelaCocina/*/*.java src/com/escuelaCocina/*.java

# Ejecutar
java -cp bin com.escuelaCocina.Main
```

### Desde IntelliJ IDEA:
1. Abrir el proyecto en IntelliJ
2. Marcar la carpeta `src/` como "Sources Root"
3. Clic derecho en `Main.java` → Run 'Main.main()'

## ✅ Funcionalidades Implementadas

- [x] Organización en paquetes (com.escuelaCocina.*)
- [x] 3 excepciones personalizadas (checked)
- [x] Validaciones con IllegalArgumentException
- [x] Try-catch en Main para manejar excepciones
- [x] Finally para limpieza de recursos
- [x] 8 casos de prueba en Main
- [x] Constructores con validaciones
- [x] Setters con validaciones

## 📊 Salida Esperada

```
=== ESCUELA DE COCINA: SABORES DEL CHEF ===
=== SEMANA 07: PAQUETES Y EXCEPCIONES ===

--- Caso 1: Crear cursos válidos ---

✅ Curso agregado exitosamente: Cocina Colombiana Tradicional
✅ Curso agregado exitosamente: Repostería Francesa
✅ Curso agregado exitosamente: Pasta Artesanal

--- Caso 2: Intentar crear curso con duración inválida ---

❌ Curso rechazado: La duración mínima de un curso es 2 horas

--- Caso 3: Intentar crear Chef con ID inválido ---

❌ Error al crear Chef: ID debe tener formato CHEF-### (ejemplo: CHEF-001)

--- Caso 4: Reservas exitosas ---

✅ Reserva exitosa para Juan Pérez en Cocina Colombiana Tradicional
   Cupos restantes: 2
✅ Reserva exitosa para María López en Cocina Colombiana Tradicional
   Cupos restantes: 1
✅ Inscripción exitosa para Carlos García en Pasta Artesanal
   Participantes: 1/2

--- Caso 5: Intentar reservar cuando no hay cupos ---

✅ Reserva exitosa para Ana Martínez en Cocina Colombiana Tradicional
   Cupos restantes: 0
❌ Cupo lleno: El curso 'Cocina Colombiana Tradicional' no tiene cupos disponibles
ℹ️  Proceso de reserva finalizado

--- Caso 6: Intentar reservar en curso inexistente ---

❌ Error: No existe curso con código: XXX-999

--- Caso 7: Reserva con nombre vacío ---

❌ Datos incompletos: El nombre del estudiante no puede estar vacío

--- Caso 8: Manejo de recursos con finally ---

✅ Curso agregado exitosamente: Cocina Japonesa
✅ Gestor temporal creado y curso agregado
ℹ️  Limpieza: Gestor temporal procesado correctamente
ℹ️  Total de cursos en gestor temporal: 1

=== CATÁLOGO DE CURSOS ===

CursoPresencial{codigo='PRES-001', nombre='Cocina Colombiana Tradicional', nivel='Básico', precio=$625000.0}
  Cupos: 0/3

CursoOnline{codigo='ONLI-001', nombre='Repostería Francesa', nivel='Intermedio', precio=$480000.0}

Taller{codigo='TALL-001', nombre='Pasta Artesanal', nivel='Básico', precio=$189750.0}
  Participantes: 1/2

=== RESUMEN FINAL ===
Total de cursos en el sistema: 3
✅ Semana 07 completada: Paquetes y Excepciones
```

## 🔧 Cambios Aplicados desde Semana 06

### 1. Reorganización en Paquetes
**Antes (Semana 06)**:
```
semana-06/
├── abstractas/Content.java
├── interfaces/Reservable.java
└── implementaciones/CursoOnline.java
```

**Después (Semana 07)**:
```
semana-07/src/com/escuelaCocina/
├── modelo/Chef.java, Content.java, etc.
├── servicio/GestorCursos.java
└── excepciones/CupoLlenoException.java, etc.
```

### 2. Excepciones Personalizadas
- Creadas 3 excepciones checked específicas del dominio
- Constructores con mensaje y mensaje+causa
- Documentación clara de cuándo se lanzan

### 3. Validaciones Exhaustivas
- Validaciones en constructores y setters
- IllegalArgumentException para validaciones de datos
- Excepciones personalizadas para reglas de negocio

### 4. Manejo Robusto de Errores
- Try-catch específicos para cada tipo de excepción
- Finally para limpieza de recursos
- Mensajes descriptivos y útiles

## 💡 Decisiones de Diseño

### Checked vs Unchecked
**Se usaron excepciones checked (extends Exception) porque:**
- Representan condiciones de negocio recuperables
- El código que llama debe manejarlas explícitamente
- Mejora la robustez del sistema
- Documenta claramente las condiciones de error

**Se usaron excepciones unchecked (IllegalArgumentException) para:**
- Validaciones de datos básicas (null, vacío, negativo)
- Errores de programación que deberían evitarse
- Validaciones que no son específicas del dominio

### Paquete excepciones/
- Separado para facilitar mantenimiento
- Todas las excepciones del dominio en un solo lugar
- Fácil de localizar y documentar
- Reutilizables en futuros desarrollos

### Validaciones en Modelo
- Implementadas en setters y constructores
- Garantizan que los objetos siempre están en estado válido
- Principio "fail fast": detectar errores lo antes posible

## 📚 Validaciones Implementadas

### En Modelo (IllegalArgumentException)
1. **Chef**:
   - ID con formato CHEF-### 
   - Nombre no vacío
   - Especialidad no vacía
   - Años de experiencia no negativos

2. **Content**:
   - Código no vacío
   - Nombre no vacío
   - Nivel debe ser: Básico, Intermedio o Avanzado
   - Duración mayor a 0
   - Precio mayor a 0

3. **CursoOnline**:
   - Plataforma no vacía
   - Videos incluidos mayor a 0

4. **CursoPresencial**:
   - Chef instructor no nulo
   - Cupos máximos mayor a 0
   - Sala no vacía

5. **Taller**:
   - Chef instructor no nulo
   - Tema específico no vacío
   - Máximo de participantes mayor a 0

### En Servicio (Excepciones Personalizadas)
1. **CursoInvalidoException**:
   - Duración mínima 2 horas
   - Código no duplicado
   - Curso existe en el sistema

2. **CupoLlenoException**:
   - Curso presencial con cupos disponibles
   - Taller con espacio disponible

3. **ReservaInvalidaException**:
   - Nombre de estudiante no vacío
   - Datos completos de reserva

## 🎯 Casos de Prueba Implementados

| # | Tipo | Descripción | Resultado Esperado |
|---|------|-------------|-------------------|
| 1 | ✅ Éxito | Crear 3 cursos válidos | Cursos agregados correctamente |
| 2 | ❌ CursoInvalidoException | Curso con duración < 2 horas | Excepción capturada |
| 3 | ❌ IllegalArgumentException | Chef con ID inválido | Excepción capturada |
| 4 | ✅ Éxito | Reservar 3 cupos en diferentes cursos | Reservas exitosas |
| 5 | ❌ CupoLlenoException | Reservar cuando no hay cupos + finally | Excepción capturada, limpieza ejecutada |
| 6 | ❌ CursoInvalidoException | Reservar en curso inexistente | Excepción capturada |
| 7 | ❌ ReservaInvalidaException | Reserva con nombre vacío | Excepción capturada |
| 8 | ✅ Finally | Creación de gestor temporal con limpieza | Finally ejecutado correctamente |

## 📈 Estadísticas del Proyecto

- **Total de clases**: 11
- **Paquetes**: 3 (modelo, servicio, excepciones)
- **Excepciones personalizadas**: 3
- **Validaciones**: 15+
- **Casos de prueba**: 8
- **Líneas de código**: ~850

---

**Versión**: 1.0  
**Semana**: 07  
**Estado**: ✅ Completo

**¡El manejo robusto de excepciones garantiza un sistema confiable!** 🚀
