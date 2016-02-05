/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion.tg1;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class SalaCine {
    Ticket asientos[];
    int contador;
    
    public SalaCine(){
        asientos = new Ticket[300];
        contador = 0;
    }
    
    public int searchTicketByReference(int num){
        return searchTicketByReference(num,0);
    }

    private int searchTicketByReference(int num, int pos) {
        if(pos < 300){
            if(asientos[pos] != null && asientos[pos].getReferencia() == num)
                return pos;
            return searchTicketByReference(num,pos+1);
        }
        return -1;
    }
    
    public boolean isPalindromo(String n){
        return isPalindromo(n,0,n.length()-1);
    }

    private boolean isPalindromo(String n, int inicio, int fin) {
        if(inicio < fin){
            if(n.charAt(inicio) != n.charAt(fin))
                return false;
            return isPalindromo(n,inicio+1,fin-1);
        }
        return true;
    }
    
    public double income(){
        return income(0);
    }

    private double income(int pos) {
        if(pos < 300){
            if(asientos[pos] != null)
                return income(pos+1)+asientos[pos].getPrecio();
            return income(pos+1);
        }
        return 0;
    }
    
    public void reset(){
        reset(0);
        contador=0;
    }

    private void reset(int pos) {
        if(pos < 300){
            asientos[pos] = null;
            reset(pos+1);
        }
    }
    
    private int posicion(int nf,int na){
       if(nf>=1 && nf <=30 && na>=1 && na<=10){
           String coord = (nf-1)+""+(na-1);
           return Integer.parseInt(coord);
       } 
       return -1;
    }
    
    private double precioDelDia(String n){
        Calendar hoy = Calendar.getInstance();
        int dia = hoy.get(Calendar.DAY_OF_WEEK);
        double base = 100;
        
        if(dia == Calendar.TUESDAY)
            base /= 2;
        else if(dia == Calendar.THURSDAY){
            if(isPalindromo(n))
                base -= base * 0.3;
        }
        return base;
    }
    
    public void sellTicket(String n, int nf, int na){
        int pos = posicion(nf, na);
        
        if(pos > -1){
            if(asientos[pos]==null){
                contador++;
                double precio = precioDelDia(n);
                asientos[pos] = new Ticket(contador, precio);
            }
            else
                System.out.println("Asiento Ocupado");
        }
        else
            System.out.println("Asiento Incorrecto");
    }
    
    public void printSala(){
        printSala(0);
    }

    private void printSala(int pos) {
        if(pos < 300){
            if(asientos[pos] != null){
                System.out.print("[");
                asientos[pos].print();
                System.out.print("] ");
            }
            else
                System.out.print("[ Disponible ] ");
            
            if((pos+1) % 10 == 0)
                System.out.println("");
            
            printSala(pos+1);
        }
    }
    
    public boolean cancelTicketByReference(int num){
        int pos = searchTicketByReference(num);
        if(pos > -1){
            asientos[pos] = null;
            return true;
        }
        return false;
    }
    
    public void eventClose(){
        System.out.println("Ingresos: "+income());
        reset();
    }
}
