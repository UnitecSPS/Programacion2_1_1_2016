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
public class BarcoPesquero extends Barco {
    private int contadorPescados;
    
    public BarcoPesquero(String n){
        super(n);
        contadorPescados=0;
    }
    
    @Override
    public String toString(){
        return super.toString()+contadorPescados;
    }
    
    @Override
    public void agregar(){
        contadorPescados++;
    }
    
    public static void main(String[] args) {
        Barco b = new BarcoPesquero("Pancho");
    }
}
