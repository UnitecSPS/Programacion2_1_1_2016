/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Aula
 */
public class Banco {
    public static void main(String[] args) {
        //UPCASTING
        CuentaBancaria ca = new CuentaAhorro(1,"Maria");
        
        if(ca instanceof CuentaAhorro)
            System.out.println("Si soy Ahorro!");
        if(ca instanceof CuentaBancaria)
            System.out.println("Si soy CuentaBancaria!");
        
        System.out.println(ca.toString());
        
        //ca.retirar(m)
        
        //downcasting indirecto
        
        CuentaAhorro cah = (CuentaAhorro)ca;
        cah.setCliente("Celeste");
        System.out.println("status: " + cah.status());
        System.out.println("ca: " + ca);
        
        //downcasting directo
        boolean s = ((CuentaAhorro)ca).status();
        System.out.println(s);
    }
}
