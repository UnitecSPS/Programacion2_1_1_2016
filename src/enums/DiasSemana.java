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
public enum DiasSemana {
    
    DOMINGO(false), LUNES(true), MARTES(true), MIERCOLES(true), 
        JUEVES(false), VIERNES(true), SABADO(false);
    
    boolean circula;
    
    private DiasSemana(boolean c){
        circula = c;
    }
}
