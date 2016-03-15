/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Aula
 */
public class ConceptoBasico {
    public static void main(String[] args) {
        Nodo a = new Nodo("Marlon");
        Nodo b = a;
        b.name = "Ruben";
        
        System.out.println(a);
        System.out.println(b);
        
        if( a == b )
            System.out.println("Es Cierto!");
        
        String x = "hola";
        String y = "hola";
        
        if(x == y)
            System.out.println("Son Iguales las Strings");
        else
            System.out.println("No Son Iguales las Strings");
    }
}
