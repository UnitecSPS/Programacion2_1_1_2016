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
public class DayOfWeek {
    private int ordinal;
    private String name;
    boolean circula;
    
    public static final DayOfWeek DOMINGO=new DayOfWeek(0, "DOMINGO",false);
    public static final DayOfWeek LUNES=new DayOfWeek(1, "LUNES",true);
    public static final DayOfWeek MARTES=new DayOfWeek(2, "MARTES", true);
    public static final DayOfWeek MIERCOLES=new DayOfWeek(3, "MIERCOLES",true);
    public static final DayOfWeek JUEVES=new DayOfWeek(4, "JUEVES",false);
    public static final DayOfWeek VIERNES=new DayOfWeek(5, "VIERNES",true);
    public static final DayOfWeek SABADO=new DayOfWeek(6, "SABADO",false);
    
    private DayOfWeek(int o, String n, boolean c){
        ordinal = o;
        name = n;
        circula = c;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public int ordinal(){
        return ordinal;
    }
}
