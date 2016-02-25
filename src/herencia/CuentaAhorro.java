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
public final class CuentaAhorro extends CuentaBancaria {
    private Calendar ultimaModif;
    public static final double TASA_AHORRO = 0.03;
    
    public CuentaAhorro(int n, String c){
        super(n,c,0.03);
        ultimaModif = Calendar.getInstance();
    }

    public Calendar getUltimaModif() {
        return ultimaModif;
    }
    
    @Override
    public String toString(){
        return super.toString() + " status="+status();
    }
    
    public boolean status(){
        //TASA_AHORRO = 0.05;
        Calendar hoy = Calendar.getInstance();
        hoy.add(Calendar.MONTH, -6);
        return hoy.before(ultimaModif);
    }
    
    @Override
     public boolean retirar(double m){
         if(status()){
             return super.retirar(m);
         }
         return false;
     }
     
    @Override
    public void depositar(double m)throws InvalidAmountException{
        if(!status())
            m -= m*0.1;
        super.depositar(m);
    }
    
}
