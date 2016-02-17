/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public abstract class BlockBusterItem {
    protected int codigo;
    protected String nombre;
    protected double precio;
    protected Calendar fecha;
    
    public BlockBusterItem(int c, String n, double p){
        codigo = c;
        nombre = n;
        precio = p;
        fecha = Calendar.getInstance();
    }
    
    @Override
    public String toString(){
        return codigo+nombre+precio;
    }
    
    public abstract double pagoRenta(int dias);
}
