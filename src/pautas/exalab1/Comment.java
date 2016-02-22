
package pautas.exalab1;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author René Rendón
 */
public final class Comment {
    int postId;
    String autor;
    String comentario;
    Calendar fecha;
    
    public Comment(int p, String a, String c){
        postId=p;
        autor=a;
        comentario=c;
        fecha=Calendar.getInstance();
    }
    
    public void print(){
        System.out.println("  -"+autor+"-"+fecha.getTime()+"\n  -"+comentario);
    }
}
