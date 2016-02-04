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
public class Barco {
    protected String nombre;
    
    public Barco(String n){
        nombre = n;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    public void agregar(){
        System.out.println("Que lo haga la hija");
    }
}
