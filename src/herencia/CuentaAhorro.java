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
public class CuentaAhorro extends CuentaBancaria {
    private boolean status;
    private Calendar ultimaModif;
    
    public CuentaAhorro(int n, String c){
        super(n,c,0.03);
        status = true;
        ultimaModif = Calendar.getInstance();
    }

    public boolean isStatus() {
        return status;
    }

    public Calendar getUltimaModif() {
        return ultimaModif;
    }
    
    
}
