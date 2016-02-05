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
public class CuentaCheques extends CuentaBancaria {

    public CuentaCheques(int n, String c) {
        super(n, c, 0);
    }

    @Override
    public String toString() {
        return "CuentaCheques{" + '}';
    }

}
