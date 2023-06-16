/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionarInmobiliaria;

/**
 *
 * @author jmrivera
 */
public class Cuenta {
    
    private String nombreCliente;
    private String numeroCuenta;
    private double tipoInteres;
    private double saldo;

    public Cuenta() {
        this.nombreCliente = "";
        this.numeroCuenta = "";
        this.tipoInteres = 0.0;
        this.saldo = 0.0;
    }

    public Cuenta(String nombreCliente, String numeroCuenta, double tipoInteres, double saldo) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldo = saldo;
    }

    public Cuenta(Cuenta copiaCuenta) {
        this.nombreCliente = copiaCuenta.getNombreCliente();
        this.numeroCuenta = copiaCuenta.getNumeroCuenta();
        this.tipoInteres = copiaCuenta.tipoInteres;
        this.saldo = copiaCuenta.getSaldo();
    }

    /**
     * Get the value of saldo
     *
     * @return the value of saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Set the value of saldo
     *
     * @param saldo new value of saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Get the value of tipoInteres
     *
     * @return the value of tipoInteres
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * Set the value of tipoInteres
     *
     * @param tipoInteres new value of tipoInteres
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }


    /**
     * Get the value of nombreCliente
     *
     * @return the value of nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Set the value of nombreCliente
     *
     * @param nombreCliente new value of nombreCliente
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Get the value of numeroCuenta
     *
     * @return the value of numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Set the value of numeroCuenta
     *
     * @param numeroCuenta new value of numeroCuenta
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre Cliente = ").append(nombreCliente);
        sb.append("\nNúmero cuenta = ").append(numeroCuenta);
        sb.append("\nTipo de interés = ").append(tipoInteres);
        sb.append("\nSaldo = ").append(saldo);
        return sb.toString();
    }
    
    /**
     * Realiza un ingreso en la cuenta por la cantidad indicada 
     * si es mayor que 0
     * 
     * @param cantidad a ingresar 
     * @return devuelve true si la operación se ha podido realizar 
     * o false en caso contrario
     */
    public boolean ingreso(double cantidad){
        boolean operacionRealizada = false;
        if (cantidad > 0){
            saldo += cantidad;
            operacionRealizada = true;
        }
        return operacionRealizada;
    }
    
    /**
     * Realiza un reintegro en la cuenta por la cantidad indicada 
     * si es mayor que 0 y hay saldo suficiente
     * 
     * @param cantidad a ingresar 
     * @return devuelve true si la operación se ha podido realizar 
     * o false en caso contrario
     */
    public boolean reintegro(double cantidad){
        boolean operacionRealizada = false;
        if (cantidad > 0 && saldo >= cantidad){
            saldo -= cantidad;
            operacionRealizada = true;
        }
        return operacionRealizada;
    }
    
    /**
     * Realiza una transferencia hacia la cuenta destino por la cantidad importe
     * si hay saldo suficiente en la cuenta origen, la del objeto
     * 
     * @param cuentaDestino
     * @param importe a transferir
     * @return devuelve true si la operación se ha podido realizar 
     * o false en caso contrario
     */
    public boolean transferencia(Cuenta cuentaDestino, double importe){
        boolean operacionRealizada = false;
        if (importe > 0 && saldo >= importe){
            operacionRealizada = cuentaDestino.ingreso(importe);
            // Está resuelto de esta manera 
            // para que veáis el uso del operador ?:
            saldo = operacionRealizada?(saldo-importe):saldo;
        }
        return operacionRealizada;
    }
    /**
     * Realiza una transferencia hacia la cuenta destino por la cantidad importe
     * si hay saldo suficiente en la cuenta origen, la del objeto
     * 
     * @param cuentaDestino
     * @param importe a transferir
     * @return devuelve true si la operación se ha podido realizar 
     * o false en caso contrario
     */
    public boolean transferencia2(Cuenta cuentaDestino, double importe){
        boolean operacionRealizada = false;
        if (reintegro(importe)){
            operacionRealizada = cuentaDestino.ingreso(importe);
        }
        return operacionRealizada;
    }
}
