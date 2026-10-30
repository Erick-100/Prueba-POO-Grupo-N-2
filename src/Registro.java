import java.util.ArrayList;

/**
 * Clase de Control: Registro
 * Basado en: Conceptos lineales de cpbook-code (resizeable_array.java)
 * Propósito: Gestión de memoria dinámica y validación interna de unicidad.
 */
public class Registro {
    // Colección lineal dinámica que simula un arreglo de tamaño variable
    private ArrayList<Estudiante> listaEstudiantes;

    // Constructor que inicializa el espacio de almacenamiento
    public Registro() {
        this.listaEstudiantes = new ArrayList<>();
    }

    /**
     * Método de Negocio: Registro de estudiantes con control de colisiones
     * @param nuevo Objeto Estudiante a validar e insertar
     * @return boolean True si se registró con éxito, False si el ID está duplicado
     */
    public boolean registrarEstudiante(Estudiante nuevo) {
        // Validación obligatoria: Evitar claves duplicadas en la colección
        for (Estudiante e : listaEstudiantes) {
            if (e.getId().equalsIgnoreCase(nuevo.getId())) {
                System.out.println("❌ ERROR DE INTEGRIDAD: El ID '" + nuevo.getId() + "' ya existe en el sistema.");
                return false;
            }
        }
        listaEstudiantes.add(nuevo);
        System.out.println("✅ ÉXITO: Estudiante indexado correctamente en el arreglo dinámico.");
        return true;
    }

    // Retorna la colección completa para su posterior procesamiento algorítmico
    public ArrayList<Estudiante> obtenerColeccion() {
        return this.listaEstudiantes;
    }

    // Despliega el catálogo completo estructurado en consola
    public void mostrarCatalogo() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("⚠️ Mensaje: No existen registros estudiantiles en este momento.");
            return;
        }
        for (Estudiante e : listaEstudiantes) {
            System.out.println(e);
        }
    }
}
