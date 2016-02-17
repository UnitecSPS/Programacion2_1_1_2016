/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class MovieItem extends BlockBusterItem {
    private boolean estreno;
    
    public MovieItem(int c, String n, double p){
        super(c,n,p);
        estreno = true;
    }
    
    @Override
    public double pagoRenta(int dias){
        if(estreno && dias > 2)
            return precio + (50*(dias-2));
        else if(!estreno && dias > 5)
            return precio + (30*(dias-5));
        return precio;
    }
    
    public final void reEvaluarEstado(){
        Calendar hace5Meses = Calendar.getInstance();
        hace5Meses.add(Calendar.MONTH, -5);
        
        if(hace5Meses.after(fecha))
            estreno = false;
    }
}
