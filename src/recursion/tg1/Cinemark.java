/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion.tg1;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class Cinemark {
    static Scanner lea = new Scanner(System.in);
    static SalaCine sala = new SalaCine();
    
    public static void main(String[] args) {
        int op;
        
        do{
            System.out.println("1- Sell Ticket");
            System.out.println("2- Print");
            System.out.println("3- Cancel Ticket");
            System.out.println("4- Close Event");
            System.out.println("5- Salir");
            System.out.println("Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    sellTicket();
                    break;
                case 2:
                    sala.printSala();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    sala.eventClose();
                    break;
            }
        }while(op!=5);
    }

    private static void sellTicket() {
        System.out.println("Nombre: ");
        String nom = lea.next();
        System.out.println("Fila (1-30): ");
        int nf = lea.nextInt();
        System.out.println("Columna (1-10): ");
        int nc = lea.nextInt();
        sala.sellTicket(nom, nf, nc);
    }

    private static void cancelTicket() {
        System.out.println("Referencia: ");
        int ref = lea.nextInt();
        
        if(sala.cancelTicketByReference(ref))
            System.out.println("Ticket Cancelado");
        else
            System.out.println("No se encontro asiento");    
    }
}
