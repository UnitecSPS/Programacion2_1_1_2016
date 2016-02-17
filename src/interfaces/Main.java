/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class Main {
    public static void main(String[] args) {
        int op;
        Scanner lea = new Scanner(System.in);
        Storable store = new StorableEnArraylist();
        
        do{
            System.out.println("1- Agregar usuario");
            System.out.println("2- Ver Usuario");
            System.out.println("3- Salir");
            System.out.println("Escoja opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Nombre-Password");
                    store.saving(new User(lea.next(), lea.next()));
                    break;
                case 2:
                    System.out.println("Email: ");
                    System.out.println(store.getUser(lea.next()));
            }
        }while(op!=3);
    }
}
