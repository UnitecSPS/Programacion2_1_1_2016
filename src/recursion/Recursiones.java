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
    
    static int powUp(int b, int e){
        if(e > 0)
            return powUp(b,e-1) * b;
        return 1;
    }
    
    static int powDown(int b,int e,int a){ 
        if(e>0)
            return powDown(b,e-1,b*a);
        return a;
    }
    
    static int mcd(int n1, int n2) {
        return mcd(n1,n2,2);
    }
    
    //En comentario estaria lo del down
    private static int mcd(int n1, int n2, int div/*,int ac*/) {
        if(n1 >= div && n2 >= div){
            if(n1 % div == 0 && n2 % div == 0)
                return mcd(n1/div, n2/div,div/*,ac*d*/) * div;
            return mcd(n1, n2, div + 1/*,ac*/);
        }
        return 1/*ac*/;
    }
    
    static int factorial(int n){
        if(n>1)
            return factorial(n-1)*n;
        return 1;
    }
    
    static void piramide(int filas){
        piramide(filas,1,1);
    }
    
    private static void piramide(int filas, int f, int c){
        if(f <= filas){
            if(c <= f){
                System.out.print("*");
                piramide(filas,f,c+1);
            }
            else{
                System.out.println("");
                piramide(filas,f+1,1);
            }
        }
    }
    
    static int fibonnaci(int n){
        if(n > 1)
            return fibonnaci(n-1)+fibonnaci(n-2);
        return n;
    }
}

















