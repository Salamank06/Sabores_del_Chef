# Análisis de Polimorfismo - Sabores del Chef

## 1. Sobrecarga (Overloading)

### Métodos Sobrecargados

En la clase `EscuelaCocina` implementé **sobrecarga** del método `buscarContenido()`:

1. **`buscarContenido(String codigo)`**
   - Parámetro: código del contenido
   - Retorna: un único objeto `Content`
   - Uso: búsqueda exacta por código

2. **`buscarContenido(String campo, String valor)`**
   - Parámetros: campo de búsqueda (nivel/tipo/nombre) y valor a buscar
   - Retorna: `ArrayList<Content>` con resultados
   - Uso: búsqueda filtrada por criterio específico

3. **`buscarContenido(double precioMin, double precioMax)`**
   - Parámetros: rango de precios
   - Retorna: `ArrayList<Content>` con contenidos en ese rango
   - Uso: búsqueda por rango de precio

### Justificación

La sobrecarga tiene sentido en el dominio de una escuela de cocina porque:

- Los usuarios pueden buscar cursos de diferentes formas (código exacto, por nivel, por precio)
- Cada método tiene una firma diferente pero una intención similar: encontrar contenido
- Mejora la usabilidad: el mismo nombre de método con diferentes parámetros es más intuitivo
- Es flexible: permite agregar más variantes sin afectar las existentes

---

## 2. Sobrescritura (Overriding)

### Métodos Sobrescritos con @Override

Los siguientes métodos fueron sobrescritos en las subclases:

1. **`calcularPrecioFinal()`** - Método abstracto implementado
2. **`obtenerTipo()`** - Método abstracto implementado
3. **`calcularTiempoPreparacion()`** - Método abstracto implementado
4. **`mostrarInfo()`** - Método concreto sobrescrito

### Tabla Comparativa

| Método | Clase Padre (Content) | CursoOnline | CursoPresencial | Taller |
|--------|----------------------|-------------|-----------------|--------|
| `calcularPrecioFinal()` | abstract | precio * 1.2 si acceso vitalicio | precio * 1.25 si chef experto | precio * 1.15 si incluye materiales * 1.10 si chef experto |
| `obtenerTipo()` | abstract | "Curso Online" | "Curso Presencial" | "Taller" |
| `calcularTiempoPreparacion()` | abstract | videosIncluidos * 2 | duracionHoras * 3 | duracionHoras * 4 |
| `mostrarInfo()` | muestra info básica | llama super + info online | llama super + info presencial | llama super + info taller |

### Código Ejemplo

```java
// En CursoOnline
@Override
public double calcularPrecioFinal() {
    if (accesoVitalicio) {
        return this.precio * 1.2;  // 20% adicional
    }
    return this.precio;
}

// En CursoPresencial
@Override
public double calcularPrecioFinal() {
    if (chefInstructor != null && chefInstructor.esExperto()) {
        return this.precio * 1.25;  // 25% adicional
    }
    return this.precio;
}

// En Taller
@Override
public double calcularPrecioFinal() {
    double precioFinal = this.precio;
    if (incluyeMateriales) {
        precioFinal *= 1.15;  // 15% por materiales
    }
    if (chefInstructor != null && chefInstructor.esExperto()) {
        precioFinal *= 1.10;  // 10% por chef experto
    }
    return precioFinal;
}
```

---

## 3. Polimorfismo Dinámico

### Ejemplo de Dynamic Binding

```java
ArrayList<Content> catalogo = new ArrayList<>();
catalogo.add(new CursoOnline(...));
catalogo.add(new CursoPresencial(...));
catalogo.add(new Taller(...));

for (Content c : catalogo) {
    // Dynamic binding: el método llamado depende del tipo REAL del objeto,
    // no del tipo declarado (Content)
    
    System.out.println(c.obtenerTipo());           // Llama al método de la subclase
    System.out.println(c.calcularPrecioFinal());   // Llama al método de la subclase
    System.out.println(c.calcularTiempoPreparacion()); // Llama al método de la subclase
}
```

### Explicación

En el sistema de Sabores del Chef, el **polimorfismo dinámico** funciona así:

1. **ArrayList Polimórfico**: `ArrayList<Content>` puede almacenar cualquier subclase (CursoOnline, CursoPresencial, Taller)

2. **Enlace Dinámico (Dynamic Binding)**: 
   - Cuando se llama `c.calcularPrecioFinal()` en el bucle
   - Java determina en **tiempo de ejecución** qué implementación usar
   - Si `c` es realmente un `CursoOnline`, usa la implementación de `CursoOnline`
   - Si `c` es un `Taller`, usa la implementación de `Taller`

3. **Métodos Polimórficos**:
   ```java
   public void prepararContenido(Content contenido) {
       // Acepta CUALQUIER subclase de Content
       int tiempo = contenido.calcularTiempoPreparacion(); // Dynamic binding
       System.out.println("Tiempo: " + tiempo);
   }
   ```

4. **Beneficio Clave**: Puedo escribir código genérico que funciona con todas las subclases presentes y **futuras**, sin modificarlo.

---

## 4. Beneficios

### Flexibilidad
- **Ejemplo específico**: Puedo agregar un nuevo tipo de contenido (ej: `CursoHibrido`) sin modificar la clase `EscuelaCocina` ni el método `procesarTodosLosContenidos()`. El ArrayList polimórfico y los métodos genéricos funcionarán automáticamente.

### Extensibilidad
- **Ejemplo específico**: Si mañana necesito un `Workshop` o `Masterclass`, solo creo la nueva clase que extienda `Content` e implemente los métodos abstractos. Todo el código existente seguirá funcionando sin cambios.

### Mantenibilidad
- **Ejemplo específico**: Si necesito cambiar cómo se calcula el precio de un taller (ej: agregar descuento por grupo), solo modifico el método `calcularPrecioFinal()` en la clase `Taller`. No toco `EscuelaCocina`, `Main`, ni ningún otro código que use talleres.

### ¿Qué sería difícil sin polimorfismo?

Sin polimorfismo tendría que:

1. **Usar múltiples ArrayLists**:
   ```java
   ArrayList<CursoOnline> cursosOnline = new ArrayList<>();
   ArrayList<CursoPresencial> cursosPresenciales = new ArrayList<>();
   ArrayList<Taller> talleres = new ArrayList<>();
   ```

2. **Duplicar código para cada tipo**:
   ```java
   public void procesarCursosOnline() { ... }
   public void procesarCursosPresenciales() { ... }
   public void procesarTalleres() { ... }
   ```

3. **Usar condicionales en lugar de dynamic binding**:
   ```java
   if (tipo == "online") {
       // código específico
   } else if (tipo == "presencial") {
       // código específico
   } else if (tipo == "taller") {
       // código específico
   }
   ```

4. **Modificar múltiples lugares** al agregar un nuevo tipo de contenido.

Con polimorfismo, todo esto se simplifica a un único ArrayList y métodos genéricos que funcionan con cualquier tipo de `Content`. 🚀
