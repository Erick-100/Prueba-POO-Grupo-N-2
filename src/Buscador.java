import java.util.ArrayList;

/**
 * Clase de Control: Buscador
 * Basado en: Estructuras algorítmicas de cpbook-code (array_algorithms.java)
 * Propósito: Implementación de algoritmos de búsqueda secuencial y filtrado.
 */
public class Buscador {

    /**
     * Algoritmo 1: Búsqueda Lineal Exacta por llave (Key Match)
     * Busca la coincidencia exacta de una cadena de caracteres única (ID).
     */
    public Estudiante buscarPorId(ArrayList<Estudiante> estudiantes, String idBuscado) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equalsIgnoreCase(idBuscado.trim())) {
                return e; // Retorna la dirección del objeto en memoria
            }
        }
        return null; // Retorno nulo si el criterio no genera coincidencias
    }

    /**
     * Algoritmo 2: Búsqueda Inteligente Inclusiva (Sub-string Fuzzy Search)
     * Encuentra coincidencias parciales sin distinguir entre mayúsculas y minúsculas.
     */
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

    /**
     * Algoritmo 3: Filtrado Lineal Multifactorial (Multi-criteria Query)
     * Evalúa la coincidencia de un área de estudio y filtra por un límite inferior analítico.
     */
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
}
