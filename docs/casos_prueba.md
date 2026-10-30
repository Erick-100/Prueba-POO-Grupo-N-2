# Pruebas de escritorio: Estudiante, Registro y Buscador

**Universidad Técnica de Ambato** · Algoritmos y Lógica de Programación · Primero "B" · Grupo N.º 02

**Integrantes:** Kevin Garces, Esteban Zambrano, Erick Cordonez, Cristian Gomez

---

## Índice

1. [Datos de prueba](#1-datos-de-prueba)
2. [Prueba de escritorio: clase `Estudiante`](#2-prueba-de-escritorio-clase-estudiante)
3. [Prueba de escritorio: clase `Registro`](#3-prueba-de-escritorio-clase-registro)
4. [Prueba de escritorio: clase `Buscador`](#4-prueba-de-escritorio-clase-buscador)
5. [Observaciones y mejoras](#5-observaciones-y-mejoras)

---

## 1. Datos de prueba

Estos son los estudiantes que se usan en las tres pruebas.

| Objeto | `id` | `nombre` | `edad` | `carrera` | `promedio` |
|--------|------|----------|--------|-----------|------------|
| `e1` | E001 | Kevin Garces | 18 | Software | 8.75 |
| `e2` | E002 | Esteban Zambrano | 19 | Sistemas | 9.10 |
| `e3` | E003 | Erick Cordonez | 18 | Software | 7.50 |
| `e4` | E004 | Cristian Gomez | 19 | Sistemas | 8.40 |

---

## 2. Prueba de escritorio: clase `Estudiante`

### 2.1 Qué se prueba

El constructor, los *getters* y *setters* y el método `toString()`.

```java
public Estudiante(String id, String nombre, int edad, String carrera, double promedio) {
    this.id = id;
    this.nombre = nombre;
    this.edad = edad;
    this.carrera = carrera;
    this.promedio = promedio;
}

@Override
public String toString() {
    return String.format("ID: %-6s | Alumno: %-20s | Edad: %-2d años | Carrera: %-12s | Promedio: %5.2f",
            id, nombre, edad, carrera, promedio);
}
```

### 2.2 Traza

| Paso | Instrucción | Resultado |
|------|-------------|-----------|
| 1 | `new Estudiante("E001","Kevin Garces",18,"Software",8.75)` | `e1`: id=E001, nombre=Kevin Garces, edad=18, carrera=Software, promedio=8.75 |
| 2 | `new Estudiante("E002","Esteban Zambrano",19,"Sistemas",9.10)` | `e2`: id=E002, nombre=Esteban Zambrano, edad=19, carrera=Sistemas, promedio=9.1 |
| 3 | `new Estudiante("E003","Erick Cordonez",18,"Software",7.50)` | `e3`: id=E003, nombre=Erick Cordonez, edad=18, carrera=Software, promedio=7.5 |
| 4 | `new Estudiante("E004","Cristian Gomez",19,"Sistemas",8.40)` | `e4`: id=E004, nombre=Cristian Gomez, edad=19, carrera=Sistemas, promedio=8.4 |
| 5 | `e1.getNombre()` | devuelve `"Kevin Garces"` |
| 6 | `e3.setPromedio(8.20)` | `e3.promedio`: 7.5 pasa a **8.2** |
| 7 | `System.out.println(e1)` | llama a `toString()` (ver 2.3) |

### 2.3 Cálculo del formato de `toString()` para `e1`

| Campo | Formato | Valor | Longitud | Relleno |
|-------|---------|-------|----------|---------|
| `id` | `%-6s` | `E001` | 4 | 2 espacios a la derecha |
| `nombre` | `%-20s` | `Kevin Garces` | 12 | 8 espacios a la derecha |
| `edad` | `%-2d` | `18` | 2 | ninguno |
| `carrera` | `%-12s` | `Software` | 8 | 4 espacios a la derecha |
| `promedio` | `%5.2f` | `8.75` | 4 | 1 espacio a la izquierda |

**Salida:**

```
ID: E001   | Alumno: Kevin Garces         | Edad: 18 años | Carrera: Software     | Promedio:  8.75
```

---

## 3. Prueba de escritorio: clase `Registro`

### 3.1 Qué se prueba

El registro de estudiantes, el control de ID duplicado y la impresión del catálogo.

```java
public boolean registrarEstudiante(Estudiante nuevo) {
    for (Estudiante e : listaEstudiantes) {
        if (e.getId().equalsIgnoreCase(nuevo.getId())) {
            System.out.println("Error de integridad: El ID '" + nuevo.getId() + "' ya existe en el sistema.");
            return false;
        }
    }
    listaEstudiantes.add(nuevo);
    System.out.println("Confirmacion: Estudiante indexado correctamente en el arreglo dinamico.");
    return true;
}

public void mostrarCatalogo() {
    if (listaEstudiantes.isEmpty()) {
        System.out.println("Aviso: No existen registros estudiantiles en este momento.");
        return;
    }
    for (Estudiante e : listaEstudiantes) {
        System.out.println(e);
    }
}
```

### 3.2 Programa simulado

```java
Registro r = new Registro();
r.mostrarCatalogo();                       // catálogo vacío
r.registrarEstudiante(e1);
r.registrarEstudiante(e2);
r.registrarEstudiante(e3);
r.registrarEstudiante(new Estudiante("e001", "Otro Nombre", 20, "Software", 6.0)); // ID repetido
r.registrarEstudiante(e4);
r.mostrarCatalogo();
```

### 3.3 Traza

| Paso | Llamada | Comparaciones en el `for` | Decisión | Retorna | `listaEstudiantes` después | Tamaño |
|------|---------|---------------------------|----------|---------|----------------------------|--------|
| 1 | `new Registro()` | no aplica | crea la lista | no aplica | `[]` | 0 |
| 2 | `mostrarCatalogo()` | no aplica | `isEmpty()` es `true` | `void` | `[]` | 0 |
| 3 | `registrar(e1)` | el `for` no se ejecuta (lista vacía) | se agrega | `true` | `[E001]` | 1 |
| 4 | `registrar(e2)` | `"E001"` vs `"E002"`: false | se agrega | `true` | `[E001, E002]` | 2 |
| 5 | `registrar(e3)` | `"E001"` vs `"E003"`: false; `"E002"` vs `"E003"`: false | se agrega | `true` | `[E001, E002, E003]` | 3 |
| 6 | `registrar(` ID `"e001")` | `"E001"` vs `"e001"`: **true** (ignora mayúsculas) | duplicado, no se agrega | `false` | `[E001, E002, E003]` | 3 |
| 7 | `registrar(e4)` | contra E001, E002 y E003: todas false | se agrega | `true` | `[E001, E002, E003, E004]` | 4 |
| 8 | `mostrarCatalogo()` | recorre los 4 elementos | imprime cada uno | `void` | sin cambios | 4 |

### 3.4 Salida en consola

```
Aviso: No existen registros estudiantiles en este momento.
Confirmacion: Estudiante indexado correctamente en el arreglo dinamico.
Confirmacion: Estudiante indexado correctamente en el arreglo dinamico.
Confirmacion: Estudiante indexado correctamente en el arreglo dinamico.
Error de integridad: El ID 'e001' ya existe en el sistema.
Confirmacion: Estudiante indexado correctamente en el arreglo dinamico.
ID: E001   | Alumno: Kevin Garces         | Edad: 18 años | Carrera: Software     | Promedio:  8.75
ID: E002   | Alumno: Esteban Zambrano     | Edad: 19 años | Carrera: Sistemas     | Promedio:  9.10
ID: E003   | Alumno: Erick Cordonez       | Edad: 18 años | Carrera: Software     | Promedio:  7.50
ID: E004   | Alumno: Cristian Gomez       | Edad: 19 años | Carrera: Sistemas     | Promedio:  8.40
```

---

## 4. Prueba de escritorio: clase `Buscador`

### 4.1 Qué se prueba

Los tres métodos de búsqueda, usando la colección `[e1, e2, e3, e4]` del paso anterior (con `e3.promedio = 7.50`).

```java
public Estudiante buscarPorId(ArrayList<Estudiante> estudiantes, String idBuscado) {
    for (Estudiante e : estudiantes) {
        if (e.getId().equalsIgnoreCase(idBuscado.trim())) {
            return e;
        }
    }
    return null;
}

public ArrayList<Estudiante> buscarPorNombreParcial(ArrayList<Estudiante> estudiantes, String patron) {
    ArrayList<Estudiante> coincidencias = new ArrayList<>();
    String patronLimpio = patron.toLowerCase().trim();
    for (Estudiante e : estudiantes) {
        if (e.getNombre().toLowerCase().contains(patronLimpio)) {
            coincidencias.add(e);
        }
    }
    return coincidencias;
}

public ArrayList<Estudiante> filtrarDestacados(ArrayList<Estudiante> estudiantes, String carrera, double umbralMinimo) {
    ArrayList<Estudiante> filtrados = new ArrayList<>();
    String carreraLimpia = carrera.toLowerCase().trim();
    for (Estudiante e : estudiantes) {
        if (e.getCarrera().toLowerCase().contains(carreraLimpia) && e.getPromedio() >= umbralMinimo) {
            filtrados.add(e);
        }
    }
    return filtrados;
}
```

### 4.2 Método 1: `buscarPorId`

**Caso A:** `buscarPorId(lista, " e003 ")`

| Paso | `idBuscado.trim()` | Elemento revisado | `getId()` | ¿`equalsIgnoreCase`? | Acción |
|------|--------------------|-------------------|-----------|----------------------|--------|
| 1 | `"e003"` | e1 | `E001` | false | continúa |
| 2 | `"e003"` | e2 | `E002` | false | continúa |
| 3 | `"e003"` | e3 | `E003` | **true** | `return e3` |

**Resultado:** devuelve `e3` (Erick Cordonez). Funciona aunque el texto tenga espacios y esté en minúsculas.

**Caso B:** `buscarPorId(lista, "E999")`

| Paso | Elemento revisado | `getId()` | ¿Coincide? |
|------|-------------------|-----------|------------|
| 1 | e1 | `E001` | false |
| 2 | e2 | `E002` | false |
| 3 | e3 | `E003` | false |
| 4 | e4 | `E004` | false |

El `for` termina sin coincidencias y devuelve **`null`**. Quien llame al método debe comprobar `null` antes de usar el resultado, o se produce `NullPointerException`.

### 4.3 Método 2: `buscarPorNombreParcial`

**Caso C:** `buscarPorNombreParcial(lista, "  ER ")`, con `patronLimpio = "er"`

| Elemento | Nombre en minúsculas | ¿Contiene `"er"`? | Acción |
|----------|----------------------|-------------------|--------|
| e1 | `kevin garces` | no | ignora |
| e2 | `esteban zambrano` | no | ignora |
| e3 | `erick cordonez` | **sí** | agrega |
| e4 | `cristian gomez` | no | ignora |

**Resultado:** `[Erick Cordonez]`

**Caso D:** `buscarPorNombreParcial(lista, "es")`, con `patronLimpio = "es"`

| Elemento | Nombre en minúsculas | ¿Contiene `"es"`? | Acción |
|----------|----------------------|-------------------|--------|
| e1 | `kevin garces` | **sí** (al final: "garc**es**") | agrega |
| e2 | `esteban zambrano` | **sí** (al inicio: "**es**teban") | agrega |
| e3 | `erick cordonez` | no | ignora |
| e4 | `cristian gomez` | no | ignora |

**Resultado:** `[Kevin Garces, Esteban Zambrano]`, en el orden en que se registraron.

Con `"es"` se ve que el método usa `contains` y no un prefijo: Kevin Garces aparece aunque su nombre no empieza con "es". Tampoco ordena el resultado alfabéticamente (Esteban debería ir antes que Kevin).

**Caso E:** `buscarPorNombreParcial(lista, "zz")`

Ningún nombre contiene `"zz"`, así que devuelve una lista vacía `[]`.

### 4.4 Método 3: `filtrarDestacados`

**Caso F:** `filtrarDestacados(lista, "SOFTWARE", 8.0)`, con `carreraLimpia = "software"`

| Elemento | `carrera` en minúsculas | ¿Contiene `"software"`? | `promedio` | ¿`>= 8.0`? | Acción |
|----------|-------------------------|-------------------------|------------|------------|--------|
| e1 | `software` | sí | 8.75 | sí | **agrega** |
| e2 | `sistemas` | no | 9.10 | no se evalúa | ignora |
| e3 | `software` | sí | 7.50 | no | ignora |
| e4 | `sistemas` | no | 8.40 | no se evalúa | ignora |

**Resultado:** `[Kevin Garces]`

**Caso G:** `filtrarDestacados(lista, "sis", 8.5)`, con `carreraLimpia = "sis"`

| Elemento | `carrera` en minúsculas | ¿Contiene `"sis"`? | `promedio` | ¿`>= 8.5`? | Acción |
|----------|-------------------------|--------------------|------------|------------|--------|
| e1 | `software` | no | 8.75 | no se evalúa | ignora |
| e2 | `sistemas` | sí | 9.10 | sí | **agrega** |
| e3 | `software` | no | 7.50 | no se evalúa | ignora |
| e4 | `sistemas` | sí | 8.40 | no | ignora |

**Resultado:** `[Esteban Zambrano]`

**Caso H (valor límite):** `filtrarDestacados(lista, "software", 8.75)`

Para e1, `8.75 >= 8.75` es verdadero, así que se incluye. Se confirma que el umbral es inclusivo. **Resultado:** `[Kevin Garces]`

### 4.5 Resumen de resultados

| Llamada | Resultado |
|---------|-----------|
| `buscarPorId(lista, " e003 ")` | `e3` (Erick Cordonez) |
| `buscarPorId(lista, "E999")` | `null` |
| `buscarPorNombreParcial(lista, "  ER ")` | `[Erick Cordonez]` |
| `buscarPorNombreParcial(lista, "es")` | `[Kevin Garces, Esteban Zambrano]` |
| `buscarPorNombreParcial(lista, "zz")` | `[]` |
| `filtrarDestacados(lista, "SOFTWARE", 8.0)` | `[Kevin Garces]` |
| `filtrarDestacados(lista, "sis", 8.5)` | `[Esteban Zambrano]` |
| `filtrarDestacados(lista, "software", 8.75)` | `[Kevin Garces]` |

---

## 5. Observaciones y mejoras

La prueba de escritorio dejó ver estos puntos frente a lo que pide la consigna de la prueba integradora:

| # | Observación | Mejora sugerida |
|---|-------------|-----------------|
| 1 | `buscarPorNombreParcial` usa `contains`, pero la consigna pide búsqueda por **prefijo** (el caso D lo demuestra). | Cambiar `contains` por `startsWith`. |
| 2 | Las coincidencias **no se ordenan** alfabéticamente. | Ordenar con `coincidencias.sort(...)` por nombre antes de devolver. |
| 3 | `Registro` compara los IDs sin `trim()`: `"E001"` y `"E001 "` serían distintos. | Usar `nuevo.getId().trim()` al comparar. |
| 4 | El **nombre vacío** se acepta en el constructor y en `setNombre`. | Validar que el nombre no sea nulo ni vacío. |
| 5 | `buscarPorId` devuelve `null` cuando no hay resultado y no avisa nada. | Quien lo use debe comprobar `null` e informar "sin resultados". |
| 6 | `buscarPorNombreParcial` no normaliza **espacios internos repetidos** (por ejemplo `"Kevin   Garces"`). | Reemplazar espacios múltiples con `replaceAll("\\s+", " ")`. |

## 6. Conclusión

Las tres clases funcionan correctamente con los datos de prueba: `Estudiante` encapsula y formatea los datos, `Registro` evita ID duplicados y `Buscador` localiza estudiantes por ID, por texto del nombre y por carrera con promedio mínimo. Para cumplir por completo la consigna falta aplicar las mejoras de la sección 5, sobre todo el prefijo, el orden alfabético y la validación del nombre.
