import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static void ejecutarMarquesina(String mensaje, int ciclos) {
        String espacioVacio = "                                        ";
        String cintaTexto = espacioVacio + mensaje + espacioVacio;
        
        System.out.println("----------------------------------------------------");
        System.out.println(">>> CARGANDO MODULOS DEL SISTEMA DE BUSQUEDA ... <<<");
        System.out.println("----------------------------------------------------");
        try {
            for (int i = 0; i < ciclos * 20; i++) {
                int posicion = i % (mensaje.length() + 15);
                String ventana = cintaTexto.substring(posicion, posicion + 40);
                
                // \r limpia la linea actual y mueve el cursor al inicio
                System.out.print("\r>>> " + ventana + " <<<");
                Thread.sleep(50); // Controla la velocidad del movimiento
            }
            System.out.println("\n\n--- SISTEMA LISTO PARA OPERAR ---\n"); 
        } catch (InterruptedException e) {
            System.out.println("\n*** " + mensaje + " ***\n");
        }
    }

    public static void main(String[] args) {
        // Ejecuta el letrero movible al abrir el programa
        ejecutarMarquesina("SISTEMA AUTONOMO DE BUSQUEDA INTELIGENTE DE ESTUDIANTES - GRUPO 2", 1);

        Scanner teclado = new Scanner(System.in);
        Registro baseDeDatos = new Registro();
        Buscador motorBusqueda = new Buscador();

        // DATOS SEMILLA: Registros precargados con sus nombres para demostrar el funcionamiento
        baseDeDatos.registrarEstudiante(new Estudiante("1801", "Kevin Garces", 21, "Software", 9.25));
        baseDeDatos.registrarEstudiante(new Estudiante("1802", "Esteban Zambrano", 22, "Software", 8.90));
        baseDeDatos.registrarEstudiante(new Estudiante("1803", "Erick Ordonez", 20, "Software", 9.50));
        baseDeDatos.registrarEstudiante(new Estudiante("1804", "Cristian Gomez", 21, "Software", 8.75));
        System.out.println("STATUS: Base de datos inicializada con 4 registros de prueba.\n");

        int opcionSeleccionada = 0;
        do {
            // DISENO DEL MENU: Estructura clara, limpia y muy facil de leer
            System.out.println("====================================================");
            System.out.println("          PANEL DE CONTROL ACADEMICO - G2           ");
            System.out.println("====================================================");
            System.out.println("1. REGISTRAR: Insertar nuevo estudiante");
            System.out.println("2. REPORTES: Mostrar lista completa en memoria");
            System.out.println("3. BUSQUEDA KEY: Localizar por ID exacto");
            System.out.println("4. BUSQUEDA FUZZY: Localizar por nombre parcial");
            System.out.println("5. FILTROS: Alumnos destacados por carrera");
            System.out.println("6. SALIR: Cerrar la aplicacion de forma segura");
            System.out.println("----------------------------------------------------");
            System.out.print("Ingrese el numero de su opcion: ");

            // VALIDACION DE MENU: Evita que el programa explote si escriben letras
            if (!teclado.hasNextInt()) {
                System.out.println("\nAVISO: Por favor, ingrese un numero entero valido entre 1 y 6.\n");
                teclado.next(); 
                continue;
            }
            opcionSeleccionada = teclado.nextInt();
            teclado.nextLine(); // Limpieza del buffer del teclado

            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("\n--- FORMULARIO DE NUEVO INGRESO ---");
                    System.out.print("-> Defina el ID unico: ");
                    String id = teclado.nextLine().trim();
                    System.out.print("-> Defina el Nombre Completo: ");
                    String nom = teclado.nextLine().trim();
                    
                    System.out.print("-> Defina la Edad (Anos): ");
                    if (!teclado.hasNextInt()) {
                        System.out.println("\nERROR: La edad debe ser un numero entero. Registro cancelado.\n");
                        teclado.nextLine();
                        continue;
                    }
                    int edad = teclado.nextInt();
                    teclado.nextLine();
                    
                    System.out.print("-> Defina la Carrera Universitaria: ");
                    String carr = teclado.nextLine().trim();
                    
                    System.out.print("-> Defina el Promedio General (0.00 - 10.00): ");
                    if (!teclado.hasNextDouble()) {
                        System.out.println("\nERROR: El promedio debe ser un numero decimal. Registro cancelado.\n");
                        teclado.nextLine();
                        continue;
                    }
                    double prom = teclado.nextDouble();
                    teclado.nextLine();

                    // Control de limites y consistencia de datos
                    if (id.isEmpty() || nom.isEmpty() || carr.isEmpty() || edad < 16 || prom < 0.0 || prom > 10.0) {
                        System.out.println("\nERROR CRITICO: Datos invalidos. Verifique campos vacios o rangos logicos.\n");
                    } else {
                        System.out.println();
                        baseDeDatos.registrarEstudiante(new Estudiante(id, nom, edad, carr, prom));
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("\n----------------------------------------------------------------------");
                    System.out.println("               VISUALIZACION DE CATALOGO ESTUDIANTIL                  ");
                    System.out.println("----------------------------------------------------------------------");
                    baseDeDatos.mostrarCatalogo();
                    System.out.println("----------------------------------------------------------------------\n");
                    break;

                case 3:
                    System.out.println("\n--- ALGORITMO DE BUSQUEDA LINEAL DIRECTA ---");
                    System.out.print("Escriba el ID exacto que desea buscar: ");
                    String llaveBusqueda = teclado.nextLine();
                    
                    Estudiante resultadoId = motorBusqueda.buscarPorId(baseDeDatos.obtenerColeccion(), llaveBusqueda);
                    if (resultadoId != null) {
                        System.out.println("\nREGISTRO ENCONTRADO:\n" + resultadoId + "\n");
                    } else {
                        System.out.println("\nAVISO: No existe ningun estudiante con el ID proporcionado.\n");
                    }
                    break;

                case 4:
                    System.out.println("\n--- ALGORITMO DE BUSQUEDA INTELIGENTE POR CADENA ---");
                    System.out.print("Escriba el nombre o las letras que desea rastrear: ");
                    String secuenciaTextual = teclado.nextLine();
                    
                    ArrayList<Estudiante> listaCoincidencias = motorBusqueda.buscarPorNombreParcial(baseDeDatos.obtenerColeccion(), secuenciaTextual);
                    if (listaCoincidencias.isEmpty()) {
                        System.out.println("\nAVISO: No se encontraron alumnos con ese patron.\n");
                    } else {
                        System.out.println("\nCOINCIDENCIAS DETECTADAS EN EL SISTEMA:");
                        listaCoincidencias.forEach(System.out::println);
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.println("\n--- REPORTE DE FILTRADO MULTIFACTORIAL ---");
                    System.out.print("Escriba la carrera de interes: ");
                    String carreraFiltro = teclado.nextLine();
                    System.out.print("Establezca el limite de promedio minimo destacado: ");
                    
                    if (!teclado.hasNextDouble()) {
                        System.out.println("\nERROR: El limite debe ser un numero decimal. Operacion cancelada.\n");
                        teclado.nextLine();
                        continue;
                    }
                    double valorLimite = teclado.nextDouble();
                    teclado.nextLine();

                    ArrayList<Estudiante> listaElite = motorBusqueda.filtrarDestacados(baseDeDatos.obtenerColeccion(), carreraFiltro, valorLimite);
                    if (listaElite.isEmpty()) {
                        System.out.println("\nAVISO: Ningun alumno cumple con los dos criterios a la vez.\n");
                    } else {
                        System.out.println("\nALUMNOS DE EXCELENCIA DETECTADOS:");
                        listaElite.forEach(System.out::println);
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("\n>>> Cerrando procesos activos en memoria... <<<");
                    System.out.println(">>> Sistema desconectado con exito. Tenga un buen dia. <<<\n");
                    break;

                default:
                    System.out.println("\nAVISO: Numero fuera de rango. Seleccione una opcion del 1 al 6.\n");
            }
        } while (opcionSeleccionada != 6);

        teclado.close();
    }
}
