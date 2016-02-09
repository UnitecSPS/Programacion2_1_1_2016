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
        
        Barco barco = Barco.getInstance("Titanic", "pasajero");
        
        //funciones on-demand
        Barco b = new Barco("Poseidon"){
            
            void test(){
                System.out.println("Solo de prueba");
            }
            
            @Override
            public void agregar(){
                test();
            }
            
            @Override
            public double vaciarCobrar(){
                return 0;
            }
        };
        
        Barco c = new Barco("Carpatia") {

            @Override
            public void agregar() {
                System.out.println("Rescatando sobrevivientes del Titanic");
            }

            @Override
            public double vaciarCobrar() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        b.agregar();
        c.agregar();
    }
}
