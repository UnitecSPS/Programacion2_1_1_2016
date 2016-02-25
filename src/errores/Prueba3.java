/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class Prueba3 {
    static Scanner lea = new Scanner(System.in);

    public static int getGrade(){
        int n;
        do{
            try{
                n = lea.nextInt();
                if(n < 0 || n > 100)
                    throw new InvalidGradeException();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese un valor entero.");
                String x = lea.nextLine();
                System.out.println("PRUEBA: Liberando a "+x);
            }
                
        }while(true);
        
        return n;
    }
    
    public static int getGradeRec(){

        try{
            int n = lea.nextInt();
            if(n < 0 || n > 100)
                throw new InvalidGradeException();
            return n;
        }
        catch(InputMismatchException e){
            System.out.println("Ingrese un valor entero.");
            String x = lea.nextLine();
            System.out.println("PRUEBA: Liberando a "+x);
            return getGradeRec();
        }
                
    }
    
    public static void main(String[] args) {
        System.out.println("Nota: "+ getGrade());
        System.out.println("Nota rec: "+ getGradeRec());
    }
}
