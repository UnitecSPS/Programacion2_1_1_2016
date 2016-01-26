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
            System.out.println("2- Sumar hasta N");
            System.out.println("Escoja opcion: ");
            
            switch(lea.nextInt()){
                case 1:
                    System.out.println("Hasta donde?: ");
                    Recursiones.printHastaN(lea.nextInt());
                    break;
                case 2:
                    System.out.println("Hasta donde?: ");
                    int n = lea.nextInt();
                    int res = Recursiones.sumarHastaNUp(n);
                    System.out.println("Suma Up: " + res);
                    res = Recursiones.sumarHastaNDown(n);
                    System.out.println("Suma Up: " + res);
                    break;
            }
            
        }while(true);
    }
}
