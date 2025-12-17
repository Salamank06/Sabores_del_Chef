# Semana 08: Colecciones y Programación Genérica

## 📝 Descripción del Proyecto

Sistema de gestión mejorado para una escuela de cocina que utiliza las colecciones de Java (`ArrayList`, `HashMap`) con programación genérica para ofrecer operaciones eficientes de búsqueda, filtrado y estadísticas. El sistema reemplaza arrays tradicionales por colecciones modernas, implementa índices con HashMap para búsquedas O(1), y proporciona un menú interactivo completo.

**Mejoras principales:**
- Migración de arrays a `ArrayList<E>` con Generics
- Implementación de `HashMap<K, V>` para búsquedas eficientes
- Métodos de filtrado avanzados
- Cálculo de estadísticas en tiempo real
- Menú interactivo con Scanner

## 📦 Estructura de Paquetes

```
com.escuelaCocina/
├── modelo/              - Entidades del dominio (Chef, Content, CursoOnline, CursoPresencial, Taller)
├── servicio/            - GestorCursos con ArrayList y HashMap
├── excepciones/         - Excepciones personalizadas
└── Main.java            - Menú interactivo con Scanner
```

## 🚀 Colecciones Implementadas

### 1. ArrayList<E> - Gestión Dinámica

**Antes (Semana 07):**
```java
private List<Content> cursos;
```

**Después (Semana 08):**
```java
private List<Content> historial = new ArrayList<>();
```

**Ventajas:**
- ✅ No necesita tamaño fijo
- ✅ Crece dinámicamente
- ✅ Métodos convenientes (add, remove, get, size)
- ✅ Iteración con for-each

### 2. HashMap<String, Content> - Búsqueda O(1)

```java
private Map<String, Content> cursosPorCodigo = new HashMap<>();
```

**Operaciones:**
- `put(codigo, curso)` - Agregar/actualizar
- `get(codigo)` - Buscar en O(1)
- `containsKey(codigo)` - Verificar existencia
- `remove(codigo)` - Eliminar

### 3. HashMap<String, List<Content>> - Agrupación

```java
private Map<String, List<Content>> cursosPorNivel = new HashMap<>();
```

**Uso:** Agrupar cursos por nivel (Básico, Intermedio, Avanzado) para filtrado rápido.

## ⚡ Operaciones Implementadas

### CRUD Completo
| Operación | Método | Complejidad | Colección |
|-----------|--------|-------------|-----------|
| **Agregar** | `agregarCurso(Content)` | O(1) | HashMap + ArrayList |
| **Buscar** | `buscarPorCodigo(String)` | O(1) | HashMap |
| **Eliminar** | `eliminarCurso(String)` | O(1) + O(n) | HashMap + ArrayList |
| **Listar** | `listarTodos()` | O(n) | ArrayList |

### Métodos de Filtrado
1. **`filtrarPorPrecio(double min, double max)`** - Cursos en rango de precio
2. **`filtrarPorNivel(String nivel)`** - Cursos por nivel (usa HashMap)
3. **`filtrarPorTipo(String tipo)`** - Cursos por tipo (Presencial/Online/Taller)
4. **`filtrarPorDuracion(int minHoras, int maxHoras)`** - Cursos por duración

### Métodos de Estadísticas
1. **`calcularTotalIngresos()`** - Suma de todos los precios
2. **`calcularPromedioPrecio()`** - Promedio de precios
3. **`obtenerCursoMasCaro()`** - Curso con mayor precio
4. **`obtenerCursoMasBarato()`** - Curso con menor precio
5. **`contarPorTipo()`** - Conteo agrupado por tipo
6. **`contarPorNivel()`** - Conteo agrupado por nivel
7. **`contarCursosDisponibles()`** - Cursos con cupos disponibles

## 🎮 Menú Interactivo

El sistema incluye un menú completo con 10 opciones:

```
╔════════════════════════════════════════╗
║      MENÚ PRINCIPAL                    ║
╠════════════════════════════════════════╣
║ 1. Agregar curso                       ║
║ 2. Buscar curso por código (HashMap)   ║
║ 3. Listar todos los cursos             ║
║ 4. Filtrar por rango de precio         ║
║ 5. Filtrar por nivel                   ║
║ 6. Filtrar por tipo                    ║
║ 7. Ver estadísticas                    ║
║ 8. Reservar cupo                       ║
║ 9. Eliminar curso                      ║
║ 0. Salir                               ║
╚════════════════════════════════════════╝
```

## 🔧 Cómo Ejecutar

### Compilar

```bash
cd semana-08
javac -encoding UTF-8 -d bin src/com/escuelaCocina/*/*.java src/com/escuelaCocina/*.java
```

### Ejecutar

```bash
java -cp bin com.escuelaCocina.Main
```

### Desde Windows PowerShell:

```powershell
cd semana-08
javac -encoding UTF-8 -d bin src\com\escuelaCocina\excepciones\*.java src\com\escuelaCocina\modelo\*.java src\com\escuelaCocina\servicio\*.java src\com\escuelaCocina\*.java
java -cp bin com.escuelaCocina.Main
```

## 📊 Ejemplo de Uso

### 1. Buscar por Código (HashMap O(1))
```
Seleccione opción: 2
Ingrese el código del curso: PRES-001

✅ Curso encontrado:
CursoPresencial{codigo='PRES-001', nombre='Cocina Colombiana Tradicional'...}
Precio: $625000.0
```

### 2. Filtrar por Precio
```
Seleccione opción: 4
Precio mínimo: 100000
Precio máximo: 500000

✅ Encontrados 2 cursos:
  - Pasta Artesanal: $189750.0
  - Repostería Francesa: $480000.0
```

### 3. Estadísticas Completas
```
╔════════════════════════════════════════╗
║          ESTADÍSTICAS                  ║
╠════════════════════════════════════════╣
║ Total cursos: 5                        ║
║ Cursos disponibles: 5                  ║
║ Total ingresos: $2689750.00            ║
║ Precio promedio: $537950.00            ║
║                                        ║
║ Curso más caro:                        ║
║   Cocina Italiana Avanzada             ║
║   $1250000.00                          ║
║                                        ║
║ Curso más barato:                      ║
║   Pasta Artesanal                      ║
║   $189750.00                           ║
╠════════════════════════════════════════╣
║ CONTEO POR TIPO:                       ║
║   CursoPresencial         : 2      ║
║   CursoOnline             : 1      ║
║   Taller                  : 2      ║
╠════════════════════════════════════════╣
║ CONTEO POR NIVEL:                      ║
║   Básico                  : 2      ║
║   Intermedio              : 2      ║
║   Avanzado                : 1      ║
╚════════════════════════════════════════╝
```

## 🔄 Cambios desde Semana 07

### 1. Migración de Colecciones

**Antes (implícito):**
```java
private List<Content> cursos;
```

**Después:**
```java
private Map<String, Content> cursosPorCodigo = new HashMap<>();
private List<Content> historial = new ArrayList<>();
private Map<String, List<Content>> cursosPorNivel = new HashMap<>();
```

### 2. Búsqueda Mejorada

**Antes:** O(n) - buscar en lista
```java
for (Content c : cursos) {
    if (c.getCodigo().equals(codigo)) return c;
}
```

**Después:** O(1) - buscar en HashMap
```java
return cursosPorCodigo.get(codigo);
```

### 3. Nuevas Funcionalidades
- ✅ 4 métodos de filtrado
- ✅ 7 métodos de estadísticas
- ✅ Agrupación por nivel con HashMap
- ✅ Conteo por categorías con Map
- ✅ Menú interactivo con Scanner

## 💡 Decisiones de Diseño

### ¿Por qué HashMap + ArrayList?

**HashMap (`cursosPorCodigo`):**
- Búsqueda ultra rápida por código único
- Validación de duplicados instantánea
- Acceso directo sin iteraciones

**ArrayList (`historial`):**
- Mantiene orden de inserción
- Permite iteración secuencial
- Facilita operaciones de filtrado

**HashMap de Listas (`cursosPorNivel`):**
- Agrupación eficiente por nivel
- Filtrado O(1) por nivel
- Estructura flexible para múltiples criterios

### Generics Everywhere

Todas las colecciones usan Generics:
```java
List<Content>                    // No List sin tipo
Map<String, Content>             // No Map sin tipos
Map<String, List<Content>>       // No Map sin tipos anidados
```

**Beneficios:**
- Type safety en tiempo de compilación
- No necesidad de casteo
- Código más legible
- IDE autocomplete

## ✅ Funcionalidades Implementadas

### Ejercicio 1: ArrayList (25 pts)
- [x] Arrays migrados a ArrayList
- [x] Uso de interfaz List<E>
- [x] Generics correctos (sin raw types)
- [x] CRUD completo funcional
- [x] Sin warnings de compilación

### Ejercicio 2: HashMap (30 pts)
- [x] HashMap<String, Content> para búsqueda por código
- [x] Búsqueda O(1) implementada
- [x] Validación de duplicados con containsKey
- [x] HashMap<String, List<Content>> para agrupación por nivel

### Ejercicio 3: Filtrado y Estadísticas (25 pts)
- [x] 4 métodos de filtrado (precio, nivel, tipo, duración)
- [x] Cálculo de total y promedio
- [x] Encontrar máximo y mínimo
- [x] Conteo por categoría (tipo y nivel)

### Ejercicio 4: Main Interactivo (20 pts)
- [x] Menú con 9 opciones + salir
- [x] Búsqueda con HashMap demostrada
- [x] Iteración con for-each
- [x] Estadísticas completas
- [x] Manejo de entrada con Scanner

## 📈 Complejidad de Operaciones

| Operación | Complejidad | Justificación |
|-----------|-------------|---------------|
| Agregar curso | O(1) | HashMap.put + ArrayList.add |
| Buscar por código | O(1) | HashMap.get |
| Eliminar por código | O(1) + O(n) | HashMap.remove + ArrayList.remove |
| Listar todos | O(n) | Iterar ArrayList |
| Filtrar por precio | O(n) | Iterar y comparar |
| Filtrar por nivel | O(1) | HashMap.get (ya agrupado) |
| Calcular estadísticas | O(n) | Iterar una vez |
| Contar por categoría | O(n) | Iterar y actualizar Map |

## 📚 Conceptos Aplicados

### Generics
```java
public class GestorCursos {
    private Map<String, Content> cursosPorCodigo;        // Generics simples
    private List<Content> historial;                     // Generics con interfaz
    private Map<String, List<Content>> cursosPorNivel;   // Generics anidados
}
```

### Polimorfismo con Colecciones
```java
List<Content> cursos = gestor.listarTodos();
for (Content curso : cursos) {  // for-each con Generics
    System.out.println(curso.calcularPrecioFinal());  // Polimorfismo
}
```

### Map.Entry para Iteración
```java
Map<String, Integer> conteo = gestor.contarPorTipo();
for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

## 🎯 Resultados

### Performance
- **Búsqueda por código**: O(1) vs O(n) anterior
- **Filtrado por nivel**: O(1) vs O(n) anterior
- **Sin límite de capacidad**: ArrayList crece dinámicamente
- **Memoria eficiente**: Solo se almacena lo necesario

### Código Limpio
- Sin arrays de tamaño fijo
- Sin contadores manuales
- Sin warnings de compilación
- Generics en todas las colecciones

### Funcionalidad
- 10 opciones en menú interactivo
- 4 tipos diferentes de filtrado
- 7 cálculos estadísticos
- Manejo completo de excepciones

## 📊 Estadísticas del Proyecto

- **Total de clases**: 11
- **Paquetes**: 3
- **Colecciones usadas**: ArrayList, HashMap
- **Métodos de filtrado**: 4
- **Métodos de estadísticas**: 7
- **Opciones en menú**: 10
- **Líneas de código**: ~1200

---

**Versión**: 1.0  
**Semana**: 08  
**Estado**: ✅ Completo

**¡Las colecciones de Java hacen el código más eficiente y mantenible!** 🚀
