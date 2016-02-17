/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

/**
 *
 * @author Aula
 */
public final class VideoGameItem extends BlockBusterItem {
    private String consola;
    
    public VideoGameItem(int c, String n, String co){
        super(c,n,30);
        consola = co;
    }
    
    @Override
    public String toString(){
        return super.toString() + consola + " Game";
    }
    
    @Override
    public double pagoRenta(int dias){
        return precio * dias;
    }
}
