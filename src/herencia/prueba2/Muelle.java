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

//Creado despues de la prueba 2
public class Muelle {
    public static void main(String[] args) {
        //Barco barco = new Barco("Titanic");
        Barco barco = Barco.getInstance("Titanic", "pasajero");
        
    }
}
