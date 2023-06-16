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
public class Atico extends Vivienda{
  private double terraza;

  public Atico(double terraza, int numHabitaciones, int numBaños, int plazasGaraje, boolean ascensor, int planta, double superficie, String direccion, double precio) {
    super(numHabitaciones, numBaños, plazasGaraje, ascensor, planta, superficie, direccion, precio);
    this.terraza = terraza;
  }
  public double getTerraza() {
    return terraza;
  }

  public void setTerraza(double terraza) {
    this.terraza = terraza;
  }

  @Override
  public void verDatos() {
    super.verDatos();
    System.out.println("Terraza: "+terraza+" mts2");
  }

  @Override
  public double comision() {
    return super.comision()+terraza*20.0; 
  }

  @Override
  public double precioAlquiler() {
    return super.precioAlquiler()+terraza*10.0; 
  }
  
  
  
}
