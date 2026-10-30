<div align="center">

# PRUEBA INTEGRADORA: POO JAVA
### Búsqueda Inteligente de Estudiantes — Grupo 2

[![Java](https://img.shields.io/badge/JAVA-POO-00E676?style=for-the-badge&logo=openjdk&logoColor=black)](#)
[![Curso](https://img.shields.io/badge/UNIVERSIDAD_TÉCNICA_DE_AMBATO-SOFTWARE_B-00E676?style=for-the-badge)](#)
[![Asignatura](https://img.shields.io/badge/ALGORITMOS_Y_LÓGICA_DE_PROGRAMACIÓN-PRIMERO-00E676?style=for-the-badge)](#)

---

> *"Divide tu código, domina la lógica. Cada método recibe, ejecuta y devuelve resultados."*

</div>

<br/>

##Badges del Proyecto

<div align="center">

![Java](https://img.shields.io/badge/JAVA-8+-00E676?style=flat-square&logo=java&logoColor=black)
![POO](https://img.shields.io/badge/PARADIGMA-POO-00E676?style=flat-square)
![REGISTRO](https://img.shields.io/badge/MÓDULO-REGISTRO_ESTUDIANTES-00E676?style=flat-square)
![VALIDACIÓN](https://img.shields.io/badge/MÓDULO-VALIDACIÓN_DE_DATOS-00E676?style=flat-square)
![BÚSQUEDA](https://img.shields.io/badge/ALGORITMO-BÚSQUEDA_POR_PREFIJO-00E676?style=flat-square)

![MENÚ](https://img.shields.io/badge/INTERFACE-MENÚ_CONSOLA-00E676?style=flat-square)
![ESTRUCTURA](https://img.shields.io/badge/COLECCIONES-ARRAYLIST-00E676?style=flat-square)
![NORMALIZACIÓN](https://img.shields.io/badge/TEXTO-NORMALIZACIÓN_MAYÚS/MINÚS-00E676?style=flat-square)
![GIT](https://img.shields.io/badge/CONTROL-GIT%2FGITHUB-00E676?style=flat-square&logo=github&logoColor=black)

</div>

<br/>

## Equipo de Trabajo

| N.° | Integrante | Rol en el Proyecto | Responsabilidad |
| :---: | :--- | :--- | :--- |
| **1** | **Kevin Garcés** | Investigar · Analista | Elaboración de la clase `Estudiante`, modelo de dominio y estructuración del `README.md`. |
| **2** | **Esteban Zambrano** | Preparar · Diseñar | Desarrollo de la clase `Registro`, control de duplicados y coordinación del `Main.java`. |
| **3** | **Erick Ordóñez** | Construir · Programar | Lógica de la clase `Buscador`, filtrado por prefijos, ordenamiento y diagrama de clases. |
| **4** | **Cristian Gómez** | Documentar · Archivar | Implementación de la clase `Validador`, sanitización de datos y documentación de casos de prueba. |

<br/>

## 🛠️ Arquitectura de Clases

El sistema consta de **4 clases de dominio + Main**, estructuradas bajo el paradigma de Programación Orientada a Objetos:

```
src/
├── Main.java         <-- Coordinación del menú de consola
├── Estudiante.java   <-- Entidad de dominio (atributos privados, getters/setters)
├── Registro.java     <-- Gestión de la colección de estudiantes (ArrayList)
├── Buscador.java     <-- Algoritmos de búsqueda exacta y por prefijos
└── Validador.java    <-- Reglas de negocio y sanitización de entradas
```

| Clase | Descripción / Responsabilidad |
| :--- | :--- |
| **`Estudiante`** | Representa al estudiante universitario con código único y nombre. Implementa encapsulamiento estricto. |
| **`Registro`** | Administra el listado de alumnos. Garantiza que no existan códigos duplicados ni nombres vacíos. |
| **`Buscador`** | Ejecuta búsquedas por prefijo de nombre y código exacto. Normaliza textos y ordena resultados alfabéticamente. |
| **`Validador`** | Limpia espacios innecesarios, estandariza cadenas a formato legible y valida formatos de entrada. |
| **`Main`** | Despliega el menú interactivo (`Scanner`, `switch`, `do-while`) invocando los métodos de cada clase. |

<br/>

## ⚙️ Métodos Clave

1. `agregarEstudiante(Estudiante e)`: Registra un estudiante previa verificación de duplicados.
2. `buscarPorCodigo(String codigo)`: Búsqueda directa por la identificación del estudiante.
3. `buscarPorPrefijo(String prefijo)`: Filtra aquellos nombres que comiencen con el prefijo indicado (ej. `"AN"` $\rightarrow$ `ANA`, `ANDRES`).
4. `normalizarTexto(String texto)`: Elimina espacios iniciales/finales y estandariza mayúsculas/minúsculas.
5. `ordenarAlfabeticamente(List<Estudiante> lista)`: Retorna la lista resultante ordenada de forma ascendente.

<br/>

## Compilación y Ejecución

```bash
# 1. Clonar el repositorio
git clone https://github.com/EstebanZambrano2005/Prueba-POO-Grupo-2.git

# 2. Entrar al directorio
cd Prueba-POO-Grupo-2

# 3. Compilar el código fuente
javac src/*.java -d bin

# 4. Ejecutar la aplicación
java -cp bin Main
```

<br/>

## 📄 Documentación Adjunta

**Análisis del problema:** [`docs/analisis.md`](docs/analisis.md)
**Casos de prueba:** [`docs/casos_prueba.md`](docs/casos_prueba.md)
**Diagrama de clases:** [`docs/diagrama_clases.png`](docs/diagrama_clases.png)

---
<div align="center">
<sub>Universidad Técnica de Ambato • Facultad de Ingeniería en Sistemas, Electrónica e Industrial</sub>
</div>
