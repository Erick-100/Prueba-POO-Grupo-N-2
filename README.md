<div align="center">

# 🔎 Búsqueda Inteligente de Estudiantes

### Prueba Práctica Integradora: POO en Java

![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk&logoColor=white)
![POO](https://img.shields.io/badge/Paradigma-POO-blue)
![Tipo](https://img.shields.io/badge/Aplicaci%C3%B3n-Consola-lightgrey)
![Estado](https://img.shields.io/badge/Estado-En%20desarrollo-yellow)

</div>

---

## 🏛️ Información académica

| | |
|---|---|
| **Universidad** | Universidad Técnica de Ambato |
| **Materia** | Algoritmos y Lógica de Programación |
| **Curso** | Primero "B" |
| **Grupo** | N.º 02 |

## 👥 Integrantes

- Kevin Garces
- Esteban Zambrano
- Erick Cordonez
- Cristian Gomez

---

## 🎯 Objetivo

Construir una **aplicación de consola funcional en Java** que resuelva un problema real mediante el uso de:

- Clases y objetos
- Atributos y constructores
- Encapsulamiento
- Métodos
- Validación de datos
- Integración entre clases

## 📌 Situación problemática

La universidad necesita **localizar estudiantes** de forma rápida y confiable a partir de su **código**, su **nombre** o un **prefijo** del nombre.

---

## ✨ Funcionalidades

| # | Funcionalidad | Descripción |
|---|---------------|-------------|
| 1 | **Registro de estudiantes** | Cada estudiante tiene un código único y un nombre que no puede estar vacío. |
| 2 | **Búsqueda por código** | Coincidencia exacta del código. |
| 3 | **Búsqueda por prefijo de nombre** | Devuelve todos los estudiantes cuyo nombre empieza con el texto ingresado. |
| 4 | **Orden alfabético** | Las coincidencias se muestran ordenadas de la A a la Z. |
| 5 | **Normalización** | Ignora diferencias de mayúsculas/minúsculas y espacios sobrantes. |
| 6 | **Control de duplicados** | No permite registrar dos estudiantes con el mismo código. |
| 7 | **Búsquedas sin resultados** | Informa claramente al usuario cuando no hay coincidencias. |

---

## 🧱 Estructura de clases

```
┌──────────────┐      ┌──────────────┐      ┌──────────────┐
│     Main     │ ───► │   Buscador   │ ───► │   Registro   │
│ (menú/consola)│      │  (búsquedas) │      │ (almacén de  │
└──────────────┘      └──────────────┘      │ estudiantes) │
                                            └──────┬───────┘
                                                   │ contiene
                                                   ▼
                                            ┌──────────────┐
                                            │  Estudiante  │
                                            │(código,nombre)│
                                            └──────────────┘
```

| Clase | Responsabilidad |
|-------|-----------------|
| `Estudiante` | Modela a un estudiante con sus atributos privados (código y nombre), constructor con validación y *getters*. |
| `Registro` | Guarda la colección de estudiantes, registra nuevos y evita códigos duplicados. |
| `Buscador` | Realiza la búsqueda por código exacto y por prefijo de nombre, normaliza el texto y ordena los resultados. |
| `Main` | Punto de entrada: muestra el menú y conecta al usuario con el resto de las clases. |

---

## 📁 Estructura del proyecto

```
📦 busqueda-estudiantes
 ┣ 📂 src
 ┃ ┣ 📄 Estudiante.java
 ┃ ┣ 📄 Registro.java
 ┃ ┣ 📄 Buscador.java
 ┃ ┗ 📄 Main.java
 ┗ 📄 README.md
```

---

## ⚙️ Requisitos

- **JDK 17** o superior (funciona también con versiones anteriores recientes)
- Una terminal o un IDE como IntelliJ IDEA, NetBeans o VS Code

## ▶️ Cómo ejecutar

```bash
# 1. Clonar el repositorio
git clone <URL-DEL-REPOSITORIO>
cd busqueda-estudiantes

# 2. Compilar
javac src/*.java -d out

# 3. Ejecutar
java -cp out Main
```

---

## 🖥️ Ejemplo de uso

```
===== BÚSQUEDA INTELIGENTE DE ESTUDIANTES =====
1. Registrar estudiante
2. Buscar por código
3. Buscar por prefijo de nombre
4. Salir

Opción: 1
Código: 1001
Nombre:   kevin garces
✔ Estudiante registrado correctamente.

Opción: 1
Código: 1001
Nombre: Otro Nombre
✘ Error: el código 1001 ya está registrado.

Opción: 3
Prefijo: ke
Resultados (ordenados alfabéticamente):
  - [1001] Kevin Garces

Opción: 3
Prefijo: zz
⚠ No se encontraron estudiantes con ese prefijo.
```

---

## 🛡️ Reglas de validación

- El **código** no puede repetirse.
- El **nombre** no puede estar vacío ni contener solo espacios.
- Las búsquedas **no distinguen** mayúsculas de minúsculas.
- Los espacios al inicio, al final o repetidos se **limpian** antes de comparar.

## 🧠 Conceptos de POO aplicados

- ✅ **Clases y objetos**
- ✅ **Atributos privados** (encapsulamiento)
- ✅ **Constructores** con validación
- ✅ **Métodos** con responsabilidades claras
- ✅ **Integración entre clases** (`Main` → `Buscador` → `Registro` → `Estudiante`)

---

<div align="center">

Hecho con ☕ y mucho código por el **Grupo 02** · Primero "B"
**Universidad Técnica de Ambato** · 2026

</div>

