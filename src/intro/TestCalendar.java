/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Aula
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar hoy=Calendar.getInstance();//Obtengo la fecha actual, Clase abstracta
        System.out.println("Fecha Actual: "+hoy.getTime()+" ms: "+hoy.getTimeInMillis());
        //Custom date
        Calendar custom=Calendar.getInstance();
        custom.setTimeInMillis(1);
        System.out.println("La primer fecha de Calendar: "+custom.getTime());
        custom.setTimeInMillis(Long.MAX_VALUE);
        System.out.println("La ultima fecha de Calendar: "+custom.getTime());
        custom.set(1990, Calendar.AUGUST, 13);
        System.out.println("Bday Marlon: "+custom.getTime()+" y ha pasado: "+custom.getTimeInMillis()+"ms");
        //Comparar
        if(custom.before(hoy)){
            System.out.println("Si paso antes");
        }
        if(hoy.after(custom)){
            System.out.println("Si, hoy es despues del bday de Marlon");
        }
        if(hoy.getTimeInMillis()>=custom.getTimeInMillis()){
            System.out.println("Si, hoy es despues del bday de Marlon");
        }
        System.out.println("Compare hoy con custom: "+hoy.compareTo(custom));
        System.out.println("Compare custom con hoy: "+custom.compareTo(hoy));
        System.out.println("Compare hoy con hoy: "+hoy.compareTo(hoy));
        //Valores individuales
        System.out.println("Dia: "+custom.get(Calendar.DATE));
        System.out.println("Semana del año: "+custom.get(Calendar.WEEK_OF_YEAR));
        int month=custom.get(Calendar.MONTH);
        System.out.println("Mes: "+month);
        int diaEnSemana=custom.get(Calendar.DAY_OF_WEEK);
        System.out.println("diaEnSemana = " + diaEnSemana);
        //Agregar o quitar
        custom.add(Calendar.YEAR, 5);
        System.out.println("Custom mas 5 años: "+custom.getTime());
        custom.add(Calendar.MONTH, -10);
        System.out.println("Custom menos 10 meses: "+custom.getTime());
        //Nombres
        String mtxt=custom.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.forLanguageTag("es"));
        System.out.println("Mes = " + mtxt);
        String dmtxt=custom.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);
        System.out.println("Día de la semana = " + dmtxt);
    }
}
