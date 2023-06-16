/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionarInmobiliaria;

import java.util.Scanner;

/**
 *
 * @author JMRivera
 */
public class Vivienda extends Inmueble {

    private int numHabitaciones;
    private int numBaños;
    private int plazasGaraje;
    private int planta;
    private boolean ascensor;

    public Vivienda(int numHabitaciones, int numBaños, int plazasGaraje, boolean ascensor, int planta, double superficie, String direccion, double precio) {
        super(superficie, direccion, precio);
        this.numHabitaciones = numHabitaciones;
        this.numBaños = numBaños;
        this.plazasGaraje = plazasGaraje;
        this.planta = planta;
        this.ascensor = ascensor;
    }

    public Vivienda(String linea) {
        super(linea);
        Scanner s = new Scanner(linea).useDelimiter("#");
        this.numHabitaciones = s.nextInt();
        this.numBaños = s.nextInt();
        this.plazasGaraje = s.nextInt();
        this.planta = s.nextInt();
        switch (linea.charAt(0)) {
            case 's':
            case 'S':
                ascensor = true;
        }
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumBaños() {
        return numBaños;
    }

    public void setNumBaños(int numBaños) {
        this.numBaños = numBaños;
    }

    public int getPlazasGaraje() {
        return plazasGaraje;
    }

    public void setPlazasGaraje(int plazasGaraje) {
        this.plazasGaraje = plazasGaraje;
    }

    public boolean isAscensor() {
        return ascensor;
    }

    public void setAscensor(boolean ascensor) {
        this.ascensor = ascensor;
    }

    @Override
    public double precioAlquiler() {
        double alquiler;

        alquiler = super.getSuperficie() * 10.0 + numHabitaciones * 50 + numBaños * 10;
        if (!ascensor) {
            alquiler -= planta * 10;
        } else {
            alquiler += 50;
        }

        return alquiler;
    }

    @Override
    public double comision() {
        return super.getPrecio() * 0.015 + precioAlquiler() * 3;
    }

    @Override
    public void verDatos() {
        System.out.println("Vivienda:");
        super.verDatos();
        System.out.println("Habitaciones: " + numHabitaciones);
        System.out.println("Baños: " + numBaños);
        System.out.println("Plazas de garaje: " + plazasGaraje);
        System.out.println("Planta: " + planta);
        System.out.println("Ascensor: " + (ascensor ? "S" : "N"));
    }

}
