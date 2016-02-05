/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion.tg1;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class Ticket {
    private int referencia;
    private Calendar fecha;
    private double precio;

    public Ticket(int referencia, double precio) {
        this.referencia = referencia;
        this.precio = precio;
        fecha = Calendar.getInstance();
    }

    public int getReferencia() {
        return referencia;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void print(){
        System.out.print(referencia+"-"+precio+"-"+
                fecha.getTime());
    }
}
