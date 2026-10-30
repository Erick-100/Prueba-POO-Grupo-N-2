import java.util.ArrayList;

/**
 * Universidad Tecnica de Ambato
 * Facultad de Ingenieria en Sistemas, Electronica e Industrial
 * 
 * Clase de Control: Registro
 * Basado en: Conceptos lineales de cpbook-code (resizeable_array.java)
 * Proposito: Gestion de memoria dinamica y validacion interna de unicidad.
 */
public class Registro {
    // Coleccion lineal dinamica que simula un arreglo de tamano variable
    private ArrayList<Estudiante> listaEstudiantes;

    // Constructor que inicializa el espacio de almacenamiento
    public Registro() {
        this.listaEstudiantes = new ArrayList<>();
    }

    /**
     * Metodo de Negocio: Registro de estudiantes con control de colisiones
     * @param nuevo Objeto Estudiante a validar e insertar
     * @return boolean True si se registro con exito, False si el ID esta duplicado
     */
    public boolean registrarEstudiante(Estudiante nuevo) {
        // Validacion obligatoria: Evitar claves duplicadas en la coleccion
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

    // Retorna la coleccion completa para su posterior procesamiento algoritmico
    public ArrayList<Estudiante> obtenerColeccion() {
        return this.listaEstudiantes;
    }

    // Despliega el catalogo completo estructurado en consola
    public void mostrarCatalogo() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("Aviso: No existen registros estudiantiles en este momento.");
            return;
        }
        for (Estudiante e : listaEstudiantes) {
            System.out.println(e);
        }
    }
}

