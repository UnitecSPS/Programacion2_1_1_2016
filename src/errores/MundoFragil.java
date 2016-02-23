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
public class MundoFragil {
    public static void main(String[] args) {
        System.out.println("Iniciando Main");
        a();
        System.out.println("Finalizando Main");
    }

    private static void a() {
        System.out.println("Iniciando A");
        
        try{
            System.out.println("Iniciando Try");
            b();
            System.out.println("Finalizando Try");
        }
        catch(InputMismatchException e){
            System.out.println("Por favor ingrese un numero.");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Por favor ingrese una posicion valida.");
        }
        catch(ArithmeticException e){
            System.out.println("Por favor no divida entre cero");
        }
        catch(Exception e){
            String clase = e.getStackTrace()[0].getClassName();
            int line = e.getStackTrace()[0].getLineNumber();
            System.out.println("Error: "+ e+" en "+clase+":"+line);
        }
        
        System.out.println("Finalizando A");
    }

    private static void b() {
        System.out.println("Iniciando B");
        //codigos fragiles--------------------
        Scanner lea = null;//new Scanner(System.in);
        int arr[] = { 2,0,1,6 };
        int pos = lea.nextInt();
        double div = 10 / arr[pos];
        System.out.println("Division 10/"+arr[pos]+": "+ div );
        //-----------------------------------
        System.out.println("Finalizando B");
    }
}
