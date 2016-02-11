/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class CuentaBancaria {
    protected int numero;
    protected String cliente;
    protected double saldo;
    protected double tasa;
    protected Calendar creacion;
    
    public CuentaBancaria(int n, String c, double t){
        numero = n;
        cliente = c;
        saldo = 500;
        tasa = t;
        creacion = Calendar.getInstance();
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public final double getTasa() {
        return tasa;
    }

    public final Calendar getCreacion() {
        return creacion;
    }
    
    
    public  boolean retirar(double m){
        if(saldo > m){
            saldo -= m;
            return true;
        }
        return false;
    }
    
    public void depositar(double m){
        saldo += m;
    }

    @Override
    public String toString() {
        return "{" + "numero=" + numero + ", cliente=" + cliente + ", saldo=" + saldo + ", tasa=" + tasa + '}';
    }
    
    
}
