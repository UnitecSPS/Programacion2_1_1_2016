/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class BlockBuster {
    private ArrayList<BlockBusterItem> items;
    static final int MOVIE = 1;
    static final int GAME = 2;
    
    public BlockBuster(){
        items = new ArrayList<>();
    }
    
    public BlockBusterItem buscar(int c, int t){
        for(BlockBusterItem item : items){
            if(item.codigo == c){
                if( t == MOVIE && item instanceof MovieItem ||
                    t ==  GAME && item instanceof VideoGameItem)
                        return item;
            }
        }
        return null;
    }
    
    public void agregar(int c, String n, int t){
        if(buscar(c,t) == null){
            Scanner lea = new Scanner(System.in);
            
            if(t == MOVIE)
                items.add(new MovieItem(c, n, lea.nextDouble()));
            else
                items.add(new VideoGameItem(c, n, lea.next()));
        }
    }
    
    public void rentar(int c, int t, int dias){
        BlockBusterItem item = buscar(c,t);
        if(item != null)
            System.out.println(item+". Pagar: "+item.pagoRenta(dias));
    }
    
    public void auditarMovies(int pos){
        if(pos < items.size()){
            BlockBusterItem item = items.get(pos);
            if(item instanceof MovieItem)
                ((MovieItem)item).reEvaluarEstado();
            auditarMovies(pos+1);
        }
    }
    
    //pos = 0 y conta = 0 al inicio
    public void list(int t, int pos, int conta){
        if(pos < items.size()){
            BlockBusterItem item = items.get(pos);
            if(t==MOVIE && item instanceof MovieItem ||
               t==GAME && item instanceof VideoGameItem){
                
                System.out.println(item);
                list(t,pos+1,conta+1);
            }
            else
                list(t,pos+1,conta);
        }
        else{
            System.out.println(conta);
        }
    }
}
