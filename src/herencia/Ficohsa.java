/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class Ficohsa {
    public static void main(String[] args) {
        
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        
        cuentas.add(new CuentaBancaria(1, "Gino", 0.2));
        cuentas.add(new CuentaAhorro(2, "Rene"));
        cuentas.add(new CuentaCheques(3, "Samuel"));

        for(CuentaBancaria cb : cuentas){
            System.out.println(""+cb);
        }
        
        
    }
}
