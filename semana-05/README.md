# Semana 05: Polimorfismo

## 📋 Descripción

Esta semana aplicamos los conceptos de **polimorfismo** al sistema de Escuela de Cocina "Sabores del Chef", implementando:
- Sobrecarga de métodos (overloading)
- Sobrescritura de métodos con @Override (overriding)
- Métodos polimórficos que aceptan la clase padre
- ArrayList polimórfico con dynamic binding

## 📁 Estructura de Archivos

```
semana-05/
├── README.md
├── src/
│   ├── Content.java              # Clase abstracta padre (mejorada)
│   ├── CursoOnline.java          # Subclase con @Override
│   ├── CursoPresencial.java      # Subclase con @Override
│   ├── Taller.java               # Subclase con @Override
│   ├── Chef.java                 # Clase auxiliar
│   ├── EscuelaCocina.java        # Clase gestora con sobrecarga y métodos polimórficos
│   └── Main.java                 # Demostración completa de polimorfismo
└── docs/
    └── POLIMORFISMO.md           # Documento de análisis
```

## 🎯 Conceptos Implementados

### 1. Sobrecarga (Overloading)
- `buscarContenido(String codigo)` - Búsqueda por código
- `buscarContenido(String campo, String valor)` - Búsqueda por criterio
- `buscarContenido(double min, double max)` - Búsqueda por rango de precio

### 2. Sobrescritura (Overriding)
- `calcularPrecioFinal()` - Implementación específica por tipo
- `obtenerTipo()` - Retorna el tipo específico de contenido
- `calcularTiempoPreparacion()` - Cálculo según características
- `mostrarInfo()` - Información detallada por tipo

### 3. Polimorfismo Dinámico
- Métodos que aceptan `Content` y funcionan con cualquier subclase
- ArrayList polimórfico: `ArrayList<Content>`
- Dynamic binding en tiempo de ejecución

## 🔧 Compilación y Ejecución

### Compilar todos los archivos
```bash
javac src/*.java
```

### Ejecutar el programa
```bash
java -cp src Main
```

## 📊 Salida Esperada

El programa demuestra:
1. **Ejercicio 1**: Sobrecarga con 3 versiones del método `buscarContenido()`
2. **Ejercicio 2**: Sobrescritura con métodos que se comportan diferente según la subclase
3. **Ejercicio 3**: Métodos polimórficos que procesan cualquier tipo de contenido
4. **Ejercicio 4**: ArrayList polimórfico con dynamic binding

## 📄 Documentación

Consulta el archivo `POLIMORFISMO.md` para un análisis detallado de:
- Justificación de la sobrecarga
- Tabla comparativa de sobrescritura
- Explicación del polimorfismo dinámico
- Beneficios obtenidos

## ✅ Checklist Completado

- [x] Sobrecarga: Mínimo 2 métodos con mismo nombre, diferentes parámetros
- [x] @Override: Correctamente usado en métodos sobrescritos
- [x] Métodos polimórficos: Que acepten clase padre
- [x] ArrayList polimórfico: `ArrayList<Content>`
- [x] Main completo: Demuestra sobrecarga y polimorfismo
- [x] POLIMORFISMO.md: Documento con análisis completo
- [x] Compila: Sin errores
- [x] Ejecuta: Salida clara y coherente

---

**¡El polimorfismo hace tu código flexible y reutilizable!** 🚀
