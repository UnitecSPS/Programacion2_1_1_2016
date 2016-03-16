/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Aula
 */
public class TestLista {
    public static void main(String[] args) {
        MiArrayList lista = new MiArrayList();
        lista.add(new Nodo("Martin"));
        lista.add(new Nodo("Marcial"));
        lista.add(new Nodo("Marlon"));
        lista.add(new Nodo("Mario"));
        lista.add(new Nodo("Maria"));
        lista.add(new Nodo("Manolas"));
        lista.print();
        //borrar--------------------------
        lista.remove("Martin");
        lista.remove("Mario");
        lista.remove("Manolas");
        lista.remove("Magdalena");
        System.out.println("\nDespues de los removes\n-----------");
        lista.print();

    }
}
