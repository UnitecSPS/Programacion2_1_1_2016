/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestEnum {
    public static void main(String[] args) {
        
        for(DiasSemana dia : DiasSemana.values())
            System.out.println("-"+dia);
        
        //asignacion de elementos
        DiasSemana dia = DiasSemana.LUNES; 
        System.out.println(dia);
        //comparacion
        if( dia == DiasSemana.LUNES )
            System.out.println("Si es Lunes!");
        
        switch(dia){
            case LUNES:
                System.out.println("Si es Lunes ombe!");
                break;
            default:
                System.out.println("No es Lunes");
        }
        //ordinal
        if( dia.ordinal() == 1 )
            System.out.println("Ya te dije que es Lunes!");
        
        //Asignar del Teclado
        Scanner lea = new Scanner(System.in);
        String elemento = lea.next();
        dia = DiasSemana.valueOf(elemento.toUpperCase());
        System.out.println("dia: "+ dia.name());
        
        //circulas?
        System.out.println("Circulas?: " + dia.circula);
    }
}
