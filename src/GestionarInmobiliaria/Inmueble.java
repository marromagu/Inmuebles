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
public abstract class Inmueble {

    private double superficie;
    private String direccion;
    private double precio;

    public Inmueble(double superficie, String direccion, double precio) {
        this.superficie = superficie;
        this.direccion = direccion;
        this.precio = precio;
    }

    public Inmueble(String linea) {
        Scanner s = new Scanner(linea).useDelimiter("#");
        this.superficie = s.nextDouble();
        this.direccion = s.next();
        this.precio = s.nextDouble();
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void verDatos() {
        System.out.println("superficie " + superficie + " mts2");
        System.out.println("direccion " + direccion);
        System.out.println("precio " + precio + " euros");
        System.out.println("alquiler: " + precioAlquiler());
        System.out.println("comisión: " + comision());
    }

    public abstract double precioAlquiler();

    public abstract double comision();
}
