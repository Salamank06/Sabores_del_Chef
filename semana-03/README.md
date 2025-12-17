# Semana 03 - Encapsulación y Constructores

## Descripción

Refactorización completa del código aplicando encapsulación, sobrecarga de constructores y validaciones en todas las clases del dominio de la Escuela de Cocina "Sabores del Chef".

## Estructura de Archivos

- `Chef.java` - Clase con encapsulación completa y constructores sobrecargados
- `Estudiante.java` - Clase con encapsulación completa y constructores sobrecargados
- `CookingCourse.java` - Clase con encapsulación completa y constructores sobrecargados
- `Inscripcion.java` - Clase con encapsulación completa y constructores sobrecargados
- `EscuelaCocina.java` - Clase gestora con encapsulación completa
- `Main.java` - Demostración de todas las funcionalidades
- `MEJORAS.md` - Documentación de mejoras implementadas

## Características Implementadas

### Ejercicio 1: Encapsulación Completa (30 puntos)
- ✅ Todos los atributos son `private`
- ✅ Getters para todos los atributos
- ✅ Setters con validaciones exhaustivas
- ✅ Métodos auxiliares privados para validaciones

### Ejercicio 2: Sobrecarga de Constructores (25 puntos)
- ✅ **Chef**: 3 constructores (completo, 3 parámetros, mínimo)
- ✅ **Estudiante**: 3 constructores (completo, 3 parámetros, mínimo)
- ✅ **CookingCourse**: 3 constructores (completo, 5 parámetros, mínimo)
- ✅ **Inscripcion**: 2 constructores (completo, 2 parámetros)
- ✅ **EscuelaCocina**: 2 constructores (completo, 1 parámetro)

### Ejercicio 3: Validaciones (25 puntos)
- ✅ Validación de formatos (IDs, códigos, emails, teléfonos)
- ✅ Validación de rangos (años de experiencia, duración, precios)
- ✅ Validación de valores nulos
- ✅ Validación de valores permitidos (niveles, estados)
- ✅ Validación de fechas (no futuras)

### Ejercicio 4: Documento MEJORAS.md (20 puntos)
- ✅ Documentación completa de encapsulación aplicada
- ✅ Documentación de constructores sobrecargados
- ✅ Lista de validaciones implementadas
- ✅ Beneficios logrados

## Instrucciones de Compilación y Ejecución

### Compilación

```bash
javac src/*.java
```

### Ejecución

```bash
java -cp src Main
```

## Salida Esperada

El programa mostrará:
- Demostración de constructores sobrecargados para cada clase
- Información completa de todos los objetos creados
- Estadísticas de la escuela
- Demostración de validaciones funcionando correctamente

## Validaciones Implementadas

- **Chef**: ID con formato CHEF-XXX, nombre no vacío, años de experiencia entre 0-50
- **Estudiante**: Documento de 7-15 caracteres, email válido, teléfono de 10 dígitos
- **CookingCourse**: Código con formato COOK-XXX, nivel válido, duración 1-200 horas, precio positivo
- **Inscripcion**: Estudiante y curso no nulos, fecha no futura, estado válido
- **EscuelaCocina**: Nombre no vacío, objetos agregados no nulos

