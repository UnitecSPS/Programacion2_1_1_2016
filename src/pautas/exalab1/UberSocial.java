package pautas.exalab1;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author René Rendón
 */
public class UberSocial {
    static ArrayList<SocialClass> redes = new ArrayList<>();
        
    private static SocialClass buscar(String u, int pos){
        if(pos<redes.size()){
            SocialClass red = redes.get(pos);
            if(red.username.equals(u)){
                return red;
            }
            else
                return buscar(u,pos+1);
        }
        return null;
    }
    
    public static SocialClass buscar(String u){
        return buscar(u,0);
    }
        
    public static void agregarCuenta(String username, String tipo){
        if(buscar(username)==null){
            if(tipo.equalsIgnoreCase("Facebook")){
                redes.add(new Facebook(username));
                System.out.println("Usuario Agregado");
            }
            else if(tipo.equalsIgnoreCase("Twitter")){
                redes.add(new Twitter(username));
                System.out.println("Usuario Agregado");
            }
            else{
                System.out.println("Invalido");
            }
        }
        else{
            System.out.println("Usuario ya existe");
        }
    }
    
    public static void agregarPost(String user, String post){
        SocialClass red = buscar(user);
        if(red!=null){
            red.addPost(post);
        }
    }
    
    public static void agregarAmigo(String user1, String user2){
        SocialClass red1 = buscar(user1);
        SocialClass red2 = buscar(user2);
        
        if(red1 instanceof Facebook && red2 instanceof Facebook){
            red1.addFriend(user2);
            red2.addFriend(user1);
        }
        else if(red1 instanceof Twitter && red2 instanceof Twitter){
            red1.addFriend(user2);
        }
    }
    
    public static void agregarComment(String user, int postId, String autor, String comment){
        SocialClass red = buscar(user);
        if(red instanceof Facebook){
            ((Facebook)red).addComment(new Comment(postId,autor, comment));
        }
        else{
            System.out.println("Invalido");
        }
    }
    
    public static void profileFrom(String u){
        SocialClass red = buscar(u);
        if(red!=null){
            red.myProfile();
        }
    }
    
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        
        while(true){
            System.out.println("");
            System.out.println("1. Agregar Cuenta");
            System.out.println("2. Agregar Post");
            System.out.println("3. Agregar Amigo");
            System.out.println("4. Agregar Comment");
            System.out.println("5. Profile From");

            int opc=lea.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingrese usuario");
                    String u=lea.next();
                    System.out.println("Ingrese tipo");
                    String t=lea.next();
                    agregarCuenta(u, t);
                break;
                case 2:
                    System.out.println("Ingrese usuario");
                    String us=lea.next();
                    System.out.println("Ingrese post");
                    String p=lea.next();
                    agregarPost(us, p);
                break;
                case 3:
                    System.out.println("Ingrese usuario1");
                    String u1=lea.next();
                    System.out.println("Ingrese usuario2");
                    String u2=lea.next();
                    agregarAmigo(u1, u2);
                break;
                case 4:
                    System.out.println("Ingrese usuario");
                    String usu=lea.next();
                    System.out.println("Ingrese postId");
                    int pos=lea.nextInt();
                    System.out.println("Ingrese autor");
                    String au=lea.next();
                    System.out.println("Ingrese comentario");
                    String co=lea.next();
                    agregarComment(usu, pos, au, co);
                break;
                case 5:
                    System.out.println("Ingrese su usuario");
                    String usua=lea.next();
                    profileFrom(usua);
                break;
            }
        }
    }
}
