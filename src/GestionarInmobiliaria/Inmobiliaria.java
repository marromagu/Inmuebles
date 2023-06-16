/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionarInmobiliaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author JMRivera
 */
public class Inmobiliaria {

    private String nombre;
    private String cif;
    private String direccion;
    private String propietario;
    private Inmueble[] inmuebles;
    private Cuenta cuenta;
    private int numeroInmuebles;

    public Inmobiliaria(String nombre, String cif, String direccion, String propietario, double saldo) {
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.propietario = propietario;
        this.inmuebles = new Inmueble[100];
        this.cuenta = new Cuenta(nombre, cif, 10, saldo);
        this.numeroInmuebles = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != "") {
            this.direccion = direccion;
        }
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        if (propietario != "") {
            this.propietario = propietario;
        }
    }

    public Inmueble[] getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(Inmueble[] inmuebles) {
        this.inmuebles = inmuebles;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getNumeroInmuebles() {
        return numeroInmuebles;
    }

    public void setNumeroInmuebles(int numeroInmuebles) {
        this.numeroInmuebles = numeroInmuebles;
    }

    public boolean altaInmueble(Inmueble nuevoInmueble) {
        if (numeroInmuebles < inmuebles.length && nuevoInmueble != null) {
            inmuebles[numeroInmuebles] = nuevoInmueble;
            numeroInmuebles++;
            return true;
        }
        return false;
    }

    public Inmueble devolverInmueble(int posicion) {
        Inmueble miInmueble = null;
        if (posicion >= 0 && posicion < numeroInmuebles) {
            miInmueble = inmuebles[posicion];
        }
        return miInmueble;
    }

    public boolean bajaInmueble(int posicion) {
        if (devolverInmueble(posicion) != null) {
            numeroInmuebles--;
            inmuebles[posicion] = inmuebles[numeroInmuebles];
            inmuebles[numeroInmuebles] = null;
            return true;
        }
        return false;
    }

    public boolean alquilar(int posicion) {
        Inmueble miInmueble = devolverInmueble(posicion);
        if (miInmueble != null) {
            double importe = miInmueble.precioAlquiler() + miInmueble.comision();
            cuenta.ingreso(importe);
            System.out.println("Ingresado: " + importe + " por el alquiler de:");
            miInmueble.verDatos();
            bajaInmueble(posicion);
            return true;
        }
        return false;
    }

    public Inmueble pedirDatos() {
        Inmueble miInmueble = null;
        int tipo;
        tipo = Entrada.leerEntero("Tipo\n 1.- Local \n 2.- Vivienda");
        if (tipo == 1 || tipo == 2) {
            double superficie = Entrada.leerDouble("Superficie: ");
            String direccion = Entrada.leerCadena("Dirección: ");
            double precio = Entrada.leerDouble("Precio: ");
            switch (tipo) {
                case 1:
                    miInmueble = new Local(superficie, direccion, precio);
                    break;
                case 2:
                    int tipoV = Entrada.leerEntero("Tipo\n 1.- Vivienda \n 2.- Ático");
                    int numHabitaciones = Entrada.leerEntero("Número de habitaciones: ");
                    int numBaños = Entrada.leerEntero("Número de baños: ");
                    int plazasGaraje = Entrada.leerEntero("Número de plazas de garaje: ");
                    int planta = Entrada.leerEntero("Planta: ");
                    boolean ascensor = Entrada.leerBoolean("¿Tiene ascensor?");
                    switch (tipoV) {
                        case 1:
                            miInmueble = new Vivienda(numHabitaciones, numBaños, plazasGaraje, ascensor, planta, superficie, direccion, precio);
                            break;
                        case 2:
                            double terraza = Entrada.leerDouble("Supercie de la terraza");
                            miInmueble = new Atico(terraza, numHabitaciones, numBaños, plazasGaraje, ascensor, planta, superficie, direccion, precio);
                            break;
                    }
                    break;
            }
        }
        return miInmueble;
    }

    public void verDatos() {
        System.out.println("Inmobiliaria " + nombre);
        System.out.println("CIF: " + cif);
        System.out.println("Dirección: " + direccion);
        System.out.println("Propietario: " + propietario);
        System.out.println("Número de inmuebles: " + numeroInmuebles);
        System.out.println("Saldo en cuenta: " + cuenta.getSaldo());
    }

    public void verDatosInmuebles() {
        System.out.println("Listado de inmuebles:\n");
        for (int i = 0; i < numeroInmuebles; i++) {
            inmuebles[i].verDatos();
            System.out.println("");
        }
    }

    public void leerDatos() {
        leerAticos();
        leerLocales();
        leerViviendas();
    }

    public void leerLocales() {
        try {
            double sup = 0, precio = 0;
            String dir = "";
            int i = 0;
            FileReader miFichero = new FileReader("Locales.txt");
            BufferedReader bf = new BufferedReader(miFichero);
            String linea = bf.readLine();
            while (linea != null) {
                switch (i) {
                    case 0:
                        sup = Double.parseDouble(linea);
                        i++;
                        break;
                    case 1:
                        dir = linea;
                        i++;
                        break;
                    case 2:
                        precio = Double.parseDouble(linea);
                        Local miLocal = new Local(sup, dir, precio);
                        altaInmueble(miLocal);
                        i = 0;
                        break;
                    default:
                }
                linea = bf.readLine();
            }
            bf.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void leerViviendas() {
        try {
            double sup = 0, precio = 0;
            int numHabitaciones = 0, numBaños = 0, plazasGarajes = 0, planta = 0, i = 0;
            boolean ascensor = false;
            String dir = "";
            FileReader miFichero = new FileReader("Viviendas.txt");
            BufferedReader bf = new BufferedReader(miFichero);
            String linea = bf.readLine();
            while (linea != null) {
                switch (i) {
                    case 0:
                        sup = Double.parseDouble(linea);
                        i++;
                        break;
                    case 1:
                        dir = linea;
                        i++;
                        break;
                    case 2:
                        precio = Double.parseDouble(linea);
                        i++;
                        break;
                    case 3:
                        numHabitaciones = Integer.parseInt(linea);
                        i++;
                        break;
                    case 4:
                        numBaños = Integer.parseInt(linea);
                        i++;
                        break;
                    case 5:
                        plazasGarajes = Integer.parseInt(linea);
                        i++;
                        break;
                    case 6:
                        ascensor = false;
                        switch (linea.charAt(0)) {
                            case 's':
                            case 'S':
                                ascensor = true;
                        }
                        i++;
                        break;
                    case 7:
                        planta = Integer.parseInt(linea);
                        Inmueble miInmueble = new Vivienda(numHabitaciones, numBaños, plazasGarajes, ascensor, planta, sup, dir, precio);
                        altaInmueble(miInmueble);
                        i = 0;
                        break;
                    default:
                }
                linea = bf.readLine();
            }
            bf.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void leerAticos() {
        try {
            double sup = 0, precio = 0, terraza = 0;
            int numHabitaciones = 0, numBaños = 0, plazasGarajes = 0, planta = 0, i = 0;
            boolean ascensor = false;
            String dir = "";
            FileReader miFichero = new FileReader("Aticos.txt");
            BufferedReader bf = new BufferedReader(miFichero);
            String linea = bf.readLine();
            while (linea != null) {
                switch (i) {
                    case 0:
                        sup = Double.parseDouble(linea);
                        i++;
                        break;
                    case 1:
                        dir = linea;
                        i++;
                        break;
                    case 2:
                        precio = Double.parseDouble(linea);
                        i++;
                        break;
                    case 3:
                        numHabitaciones = Integer.parseInt(linea);
                        i++;
                        break;
                    case 4:
                        numBaños = Integer.parseInt(linea);
                        i++;
                        break;
                    case 5:
                        plazasGarajes = Integer.parseInt(linea);
                        i++;
                        break;
                    case 6:
                        ascensor = false;
                        switch (linea.charAt(0)) {
                            case 's':
                            case 'S':
                                ascensor = true;
                        }
                        i++;
                        break;
                    case 7:
                        planta = Integer.parseInt(linea);
                        i++;
                        break;
                    case 8:
                        terraza = Double.parseDouble(linea);
                        Inmueble miInmueble = new Atico(terraza, numHabitaciones, numBaños, plazasGarajes, ascensor, planta, sup, dir, precio);
                        altaInmueble(miInmueble);
                        i = 0;
                        break;
                    default:
                }
                linea = bf.readLine();
            }
            bf.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void guardarDatos() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Inmobiliaria.txt");
            pw = new PrintWriter(fichero);

            for (Inmueble inm : inmuebles) {
                if (inm instanceof Local) {
                    pw.print(";Local;");
                    pw.print(inm.getSuperficie());
                    pw.print("#");
                    pw.print(inm.getDireccion());
                    pw.print("#");
                    pw.print(inm.getPrecio());
                    pw.print("#");
                }
                if (inm instanceof Vivienda) {
                    pw.print(";Vivienda;");
                    pw.print(inm.getSuperficie());
                    pw.print("#");
                    pw.print(inm.getDireccion());
                    pw.print("#");
                    pw.print(inm.getPrecio());
                    pw.print("#");
                    pw.print(((Vivienda) inm).getNumHabitaciones());
                    pw.print("#");
                    pw.print(((Vivienda) inm).getNumBaños());
                    pw.print("#");
                    pw.print(((Vivienda) inm).getPlazasGaraje());
                    pw.print("#");
                    pw.print(((Vivienda) inm).getPlanta());
                    pw.print("#");
                    pw.print(((Vivienda) inm).isAscensor());
                    pw.print("#");
                }
                if (inm instanceof Atico) {
                    pw.print(";Atico;");
                    pw.print(inm.getSuperficie());
                    pw.print("#");
                    pw.print(inm.getDireccion());
                    pw.print("#");
                    pw.print(inm.getPrecio());
                    pw.print("#");
                    pw.print(((Atico) inm).getNumHabitaciones());
                    pw.print("#");
                    pw.print(((Atico) inm).getNumBaños());
                    pw.print("#");
                    pw.print(((Atico) inm).getPlazasGaraje());
                    pw.print("#");
                    pw.print(((Atico) inm).getPlanta());
                    pw.print("#");
                    pw.print(((Atico) inm).isAscensor());
                    pw.print("#");
                    pw.print(((Atico) inm).getTerraza());
                    pw.print("#");
                }
            }

        } catch (Exception e) {
            System.out.println("Error grabando Inmobiliaria.txt");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.out.println("Error grabando Inmobiliaria.txt");
            }
        }
    }

    public void cargarDatos() {
        FileReader fichero = null;
        BufferedReader bf = null;
        Local miLocal;
        Vivienda miVivienda;
        Atico miAtico;
        int i = 0;
        try {
            fichero = new FileReader("Inmobiliaria.txt");
            bf = new BufferedReader(fichero);
            String linea = bf.readLine();
            Scanner s = new Scanner(linea).useDelimiter(";");
            while (linea != null) {
                String semiLinea = s.next();
                System.out.println(semiLinea);

                if ("Local".equals(semiLinea)) {
                    System.out.println("Local creao");
                    semiLinea = s.next();
                    miLocal = new Local(semiLinea);

                }
                if ("Vivienda".equals(semiLinea)) {
                    System.out.println("Vivienda creao");
                    semiLinea = s.next();
                   // miVivienda = new Vivienda(semiLinea);

                }
                if ("Atico".equals(semiLinea)) {
                    System.out.println("Atico creao");
                    semiLinea = s.next();
                    //miAtico = new Atico(semiLinea);
                }

            }

        } catch (Exception e) {
            System.out.println("Error cargando Inmobiliaria.txt");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.out.println("Error cargando Inmobiliaria.txt");
            }
        }
    }
}
