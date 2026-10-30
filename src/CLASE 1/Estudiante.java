
public class Estudiante {
    // Atributos privados para garantizar el ocultamiento de datos
    private String id;
    private String nombre;
    private int edad;
    private String carrera;
    private double promedio;

    // Constructor explícito para la instanciación de objetos de tipo Estudiante
    public Estudiante(String id, String nombre, int edad, String carrera, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    // Métodos Getters y Setters (Estructura de encapsulamiento obligatoria)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    // Sobrescritura del método toString para presentación limpia de datos en consola
    @Override
    public String toString() {
        return String.format("ID: %-6s | Alumno: %-20s | Edad: %-2d años | Carrera: %-12s | Promedio: %5.2f", 
                id, nombre, edad, carrera, promedio);
    }
}
