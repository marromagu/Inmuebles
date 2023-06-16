/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionarInmobiliaria;

/**
 *
 * @author JMRivera
 */
public class Local extends Inmueble {

    public Local(double superficie, String direccion, double precio) {
        super(superficie, direccion, precio);
    }

    public Local(String linea) {
        super(linea);
    }

    @Override
    public double precioAlquiler() {
        return getSuperficie() * 20.0;
    }

    @Override
    public double comision() {
        return precioAlquiler() * 2;
    }

    @Override
    public void verDatos() {
        System.out.println("Local:");
        super.verDatos();
    }

}
