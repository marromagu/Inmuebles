/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GestionarInmobiliaria;

/**
 *
 * @author JMRivera
 */
public class GestionarInmobiliaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Inmobiliaria miInmobiliaria = new Inmobiliaria("Velázquez", "41-123456", "Feria 100", "José María Rivera Calvete", 1000.0);
        int opcion, modificar, posicion;
        Inmueble unInmueble;
        miInmobiliaria.cargarDatos();
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    miInmobiliaria.verDatos();
                    modificar = Entrada.leerCaracter("¿Quiere modificar los datos (s/n)?:");
                    if (modificar == 's') {
                        miInmobiliaria.setPropietario(Entrada.leerCadena("Nuevo propietario:"));
                        miInmobiliaria.setDireccion(Entrada.leerCadena("Nuevo dirección:"));
                    }
                    break;
                case 2:
                    unInmueble = miInmobiliaria.pedirDatos();
                    miInmobiliaria.altaInmueble(unInmueble);
                    break;
                case 3:
                    posicion = Entrada.leerEntero("Posición del inmueble a dar de baja");
                    if (miInmobiliaria.bajaInmueble(posicion)) {
                        System.out.println("Inmueble dado de baja.");
                    } else {
                        System.out.println("Error: dando de baja el inmueble: " + posicion);
                    }
                    break;
                case 4:
                    posicion = Entrada.leerEntero("Posición del inmueble a alquilar");
                    if (!miInmobiliaria.alquilar(posicion)) {
                        System.out.println("Error: alquilando el inmueble: " + posicion);
                    }
                    break;
                case 5:
                    posicion = Entrada.leerEntero("Posición del inmueble");
                    unInmueble = miInmobiliaria.devolverInmueble(posicion);
                    if (unInmueble != null) {
                        unInmueble.verDatos();
                    } else {
                        System.out.println("Error: mostrando datos del inmueble: " + posicion);
                    }
                    break;
                case 6:
                    miInmobiliaria.verDatosInmuebles();
                    break;
                case 7:
                    miInmobiliaria.leerDatos();
                    System.out.println("Leyendo...");
                    break;
                default:
            }

        } while (opcion != 0);
        miInmobiliaria.guardarDatos();
        System.out.println("Guardando datos...");
        System.out.println("Fin de la ejecución.");
    }

    public static int menu() {
        int op;
        System.out.println("Menu");
        System.out.println("");
        System.out.println("1.- Ver/modificar los datos de la inmobiliaria.");
        System.out.println("2.- Dar de alta un inmueble.");
        System.out.println("3.- Dar de baja un inmueble.");
        System.out.println("4.- Alquilar un inmueble.");
        System.out.println("5.- Ver los datos de un inmueble.");
        System.out.println("6.- Ver los datos de todos los inmuebles.");
        System.out.println("7.- Leer datos de los txt separados.");
        System.out.println("0.- Salir.");
        op = Entrada.leerEntero("\nElija opción:");

        return op;
    }

}
