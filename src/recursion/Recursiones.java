/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Aula
 */
public class Recursiones {
    private Recursiones(){}
    
    static void printHastaN(int n){
        if(n>1){
            //System.out.println("Llamando print("+(n-1)+")");
            printHastaN(n-1);
            //System.out.println("Regresando de print("+(n-1)+")");
        }
        System.out.println(n);
    }
    
    static int sumarHastaNUp(int n){
        if( n > 1)
            return sumarHastaNUp(n-1)+n;
        return n;
    }
    
    static int sumarHastaNDown(int n){
        return sumarHastaNDown(n,0);
    }
    
    private static int sumarHastaNDown(int n, int suma){
        if(n>=1)
            return sumarHastaNDown(n-1, suma+n);
        return suma;
    }
}
