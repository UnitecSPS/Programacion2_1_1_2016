/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class TestArraylist {
    public static void main(String[] args) {
       ArrayList<String> cads=new ArrayList<>();
        //Agregar valores
        cads.add("Barcelona");
        cads.add("Real Madrid");
        cads.add("Atletico");
        //Imprimir
        for(String s: cads){
            System.out.println(s);
        }
        //Extraer un valor individual
        System.out.println("[0]"+cads.get(0));
        //Tamaño
        System.out.println("Size: "+cads.size());
        //Remover
        cads.remove(1);
        System.out.println("\nLuego de remover la posición uno");
        for(String s: cads){
            System.out.println(s);
        }
        //Agregar en medio
        cads.add(1, "Sevilla");
        System.out.println("");
        for(int x=0; x<cads.size(); x++){
            System.out.println(cads.get(x));
        }
        //Busqueda
        if(cads.contains("Barcelona")){
            System.out.println("Si esta Barcelona");
        }
        //Ojo con los primitivos
        ArrayList<Integer> nums=new ArrayList<>();
        nums.add(5);
        ArrayList<Double> nums1;
        ArrayList<Character> nums2; 
    }
}
