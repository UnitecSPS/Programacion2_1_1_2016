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
    }
}
