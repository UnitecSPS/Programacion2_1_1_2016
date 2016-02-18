/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Aula
 */
public class TestDayofWeek {
    public static void main(String[] args) {
        DayOfWeek dia = DayOfWeek.LUNES;
        System.out.println(dia + " - ordinal: "+ dia.ordinal());
        
        if(dia == DayOfWeek.LUNES)
            System.out.println("SIIIII es Lunes!");
    }
}
