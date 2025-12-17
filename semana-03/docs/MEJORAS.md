# Mejoras - Semana 03

## Encapsulación Aplicada

### Clase: Chef
- **Atributos encapsulados:** `id`, `nombre`, `especialidad`, `añosExperiencia` (todos private)
- **Validaciones agregadas:**
  - `setId()`: Valida formato CHEF-XXX
  - `setNombre()`: Valida que no sea nulo ni vacío
  - `setEspecialidad()`: Valida que no sea nula ni vacía
  - `setAñosExperiencia()`: Valida rango entre 0 y 50 años
- **Métodos auxiliares privados:**
  - `validarId()`: Verifica formato del ID
  - `validarNombre()`: Verifica que el nombre no sea nulo ni vacío

### Clase: Estudiante
- **Atributos encapsulados:** `documento`, `nombre`, `email`, `telefono` (todos private)
- **Validaciones agregadas:**
  - `setDocumento()`: Valida longitud entre 7 y 15 caracteres
  - `setNombre()`: Valida que no sea nulo ni vacío
  - `setEmail()`: Valida formato de email (debe contener @)
  - `setTelefono()`: Valida formato de 10 dígitos numéricos
- **Métodos auxiliares privados:**
  - `validarDocumento()`: Verifica longitud del documento
  - `validarNombre()`: Verifica que el nombre no sea nulo ni vacío
  - `validarEmail()`: Verifica formato de email
  - `validarTelefono()`: Verifica formato de teléfono con regex

### Clase: CookingCourse
- **Atributos encapsulados:** `courseCode`, `name`, `level`, `chefInstructor`, `duracionHoras`, `precio` (todos private)
- **Validaciones agregadas:**
  - `setCourseCode()`: Valida formato COOK-XXX
  - `setName()`: Valida que no sea nulo ni vacío
  - `setLevel()`: Valida que sea Básico, Intermedio o Avanzado
  - `setDuracionHoras()`: Valida rango entre 1 y 200 horas
  - `setPrecio()`: Valida que sea positivo
  - `calcularDescuento()`: Valida porcentaje entre 0 y 100
- **Métodos auxiliares privados:**
  - `validarCodigo()`: Verifica formato del código
  - `validarNombre()`: Verifica que el nombre no sea nulo ni vacío
  - `validarNivel()`: Verifica que el nivel sea válido

### Clase: Inscripcion
- **Atributos encapsulados:** `estudiante`, `curso`, `fechaInscripcion`, `estado` (todos private)
- **Validaciones agregadas:**
  - `setEstudiante()`: Valida que no sea nulo
  - `setCurso()`: Valida que no sea nulo
  - `setFechaInscripcion()`: Valida que no sea nula ni futura
  - `setEstado()`: Valida que sea Activa, Cancelada o Completada
- **Métodos auxiliares privados:**
  - `validarEstado()`: Verifica que el estado sea válido

### Clase: EscuelaCocina
- **Atributos encapsulados:** `nombre`, `ubicacion`, `cursos`, `estudiantes`, `chefs`, `inscripciones` (todos private)
- **Validaciones agregadas:**
  - `setNombre()`: Valida que no sea nulo ni vacío
  - `setUbicacion()`: Valida que no sea nula
  - `agregarCurso()`: Valida que el curso no sea nulo
  - `agregarEstudiante()`: Valida que el estudiante no sea nulo
  - `agregarChef()`: Valida que el chef no sea nulo
  - `agregarInscripcion()`: Valida que la inscripción no sea nula
- **Métodos auxiliares privados:**
  - `validarNombre()`: Verifica que el nombre no sea nulo ni vacío

## Constructores Sobrecargados

### Clase: Chef
- **Constructor 1 (completo):** Recibe id, nombre, especialidad y años de experiencia
- **Constructor 2:** Recibe id, nombre y especialidad (años de experiencia = 0)
- **Constructor 3 (mínimo):** Recibe solo nombre (id = "CHEF-000", especialidad = "General", años = 0)

### Clase: Estudiante
- **Constructor 1 (completo):** Recibe documento, nombre, email y teléfono
- **Constructor 2:** Recibe documento, nombre y email (teléfono = "Sin teléfono")
- **Constructor 3 (mínimo):** Recibe documento y nombre (email generado automáticamente)

### Clase: CookingCourse
- **Constructor 1 (completo):** Recibe código, nombre, nivel, chef, duración y precio
- **Constructor 2:** Recibe código, nombre, nivel, duración y precio (sin chef)
- **Constructor 3 (mínimo):** Recibe código y nombre (nivel = "Básico", duración = 20, precio = 300000)

### Clase: Inscripcion
- **Constructor 1 (completo):** Recibe estudiante, curso y fecha de inscripción
- **Constructor 2:** Recibe estudiante y curso (fecha = LocalDate.now())

### Clase: EscuelaCocina
- **Constructor 1 (completo):** Recibe nombre y ubicación
- **Constructor 2:** Recibe solo nombre (ubicación = "Sin ubicación")

## Beneficios Logrados

1. **Seguridad de Datos:** Los atributos privados previenen acceso directo no autorizado
2. **Validación Centralizada:** Todas las validaciones se realizan en los setters, garantizando datos consistentes
3. **Flexibilidad:** Los constructores sobrecargados permiten crear objetos con diferentes niveles de información
4. **Mantenibilidad:** Código más organizado y fácil de mantener con métodos auxiliares privados
5. **Robustez:** Las validaciones previenen estados inválidos del objeto
6. **Reutilización:** Los constructores con menos parámetros facilitan la creación de objetos con valores por defecto
7. **Claridad:** El código es más legible y autodocumentado con validaciones explícitas

## Ejemplos de Validaciones Implementadas

- **Validación de formato:** IDs y códigos deben seguir patrones específicos (CHEF-XXX, COOK-XXX)
- **Validación de rangos:** Años de experiencia (0-50), duración de cursos (1-200 horas)
- **Validación de valores positivos:** Precios no pueden ser negativos
- **Validación de formato de datos:** Emails deben contener @, teléfonos deben tener 10 dígitos
- **Validación de valores nulos:** Objetos relacionados no pueden ser nulos
- **Validación de fechas:** Fechas de inscripción no pueden ser futuras
- **Validación de valores permitidos:** Niveles de curso y estados de inscripción deben ser valores específicos
