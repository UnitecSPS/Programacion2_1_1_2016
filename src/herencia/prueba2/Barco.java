/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.prueba2;

/**
 *
 * @author Aula
 */
public abstract class Barco {
    protected String nombre;
    
    public Barco(String n){
        nombre = n;
    }
    
    public static Barco getInstance(String n, String t){
        if(t.equalsIgnoreCase("pesquero"))
            return new BarcoPesquero(n);
        return new BarcoPasajero(n);
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    //modificado luego de abstract
    public abstract void agregar();
    public abstract double vaciarCobrar();
    
    public void print(){
        System.out.println(nombre);
    }
}
