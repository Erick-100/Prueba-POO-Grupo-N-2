# Análisis · Búsqueda inteligente de estudiantes

## Problema

La universidad necesita localizar estudiantes por código, nombre y prefijos. Los datos pueden ingresarse con diferencias de mayúsculas, espacios o tildes, por lo que deben normalizarse, y no deben existir códigos repetidos.

## Entradas

| Operación | Entradas |
| --- | --- |
| Registrar | Código , nombre  |
| Buscar por código | Código  |
| Buscar por prefijo | Prefijo de nombre  |
| Menú | Opción numérica (0 a 5) |

## Procesos

1. **Normalización:** se eliminan espacios en los extremos y repetidos, y el texto pasa a mayúsculas.
2. **Validación al crear `Estudiante`:** código no vacío y alfanumérico sin espacios; nombre no vacío y solo con letras y espacios.
3. **Registro:** `Registro.registrar` rechaza códigos ya existentes.
4. **Búsqueda por código:** comparación exacta del código normalizado.
5. **Búsqueda por prefijo:** el nombre normalizado y sin tildes debe comenzar con el prefijo normalizado y sin tildes.
6. **Ordenamiento:** por nombre sin tildes; si hay empate, por código.
7. **Reporte:** `Buscador.generarReporte` lista coincidencias o informa que no hay resultados.

## Salidas

- Mensaje de registro exitoso o de error (campo vacío, caracteres inválidos, código duplicado).
- Listado de coincidencias ordenado alfabéticamente, con su cantidad.
- Mensaje «Sin resultados para ...» cuando no hay coincidencias.
- Mensaje de opción inválida si el menú recibe un valor no permitido.

## Decisiones de diseño

- **Cuatro clases con responsabilidades separadas:** `Estudiante` (datos y normalización), `Registro` (almacenamiento y unicidad), `Buscador` (consultas y reporte) y `Main` (menú).
- **Encapsulamiento:** atributos `private final`; `Registro.getEstudiantes()` devuelve una copia para no exponer la lista interna.
- **Validación en el constructor:** un objeto `Estudiante` nunca queda en estado inválido; los errores se informan con `IllegalArgumentException` y `Main` los captura para mostrarlos.
- **`ArrayList`** para administrar los registros; la búsqueda recorre la lista, suficiente para el alcance del ejercicio (la referencia original usa un Trie, no exigido).
- **Búsqueda insensible a tildes** para que «Andrés» sea encontrado con el prefijo and.
- **Mensajes sin tildes** en consola para evitar problemas de codificación en terminales de Windows.
