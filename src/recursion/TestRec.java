/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestRec {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("1- Print Hasta N");
            System.out.println("Escoja opcion: ");
            
            switch(lea.nextInt()){
                case 1:
                    System.out.println("Hasta donde?: ");
                    Recursiones.printHastaN(lea.nextInt());
                    break;
            }
            
        }while(true);
    }
}
