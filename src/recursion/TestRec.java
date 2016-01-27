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
            System.out.println("3- Potencia");
            System.out.println("4- Maximo Comun Divisor");
            System.out.println("");
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
                case 3:
                    System.out.println("Base: ");
                    int base = lea.nextInt();
                    System.out.println("Expo: ");
                    int expo = lea.nextInt();
                    res = Recursiones.powUp(base, expo);
                    System.out.println("Pot Up: "+ res);
                    res = Recursiones.powDown(base, expo, 1);
                    System.out.println("Pot Down: "+ res);
                    break;
                case 4:
                    System.out.println("N1: ");
                    int n1 = lea.nextInt();
                    System.out.println("N2: ");
                    int n2 = lea.nextInt();
                    res = Recursiones.mcd(n1,n2);
                    System.out.println("MCD: "+res);
                    break;
                    
            }
            
        }while(true);
    }
}
