/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.tg2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class Tumblr {
    static ArrayList<User> users;
    static ArrayList<String> posts;
    static User currentUser;
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        init();
        int op;
        
        do{
            System.out.println("1- Login");
            System.out.println("2- Crear Post");
            System.out.println("3- Agregar Usuario");
            System.out.println("4- Ver Posts");
            System.out.println("5- Editar Posts");
            System.out.println("6- Log Out");
            System.out.println("7- Salir");
            System.out.println("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    login();
                    break;
                case 2:
                    crear();
                    break;
                case 3:
                    signup();
                    break;
                case 4:
                    timeline();
                    break;
                case 5:
                    edit();
                    break;
                case 6:
                    currentUser = null;
                    break;
            }
                    
        }while(op!=7);
    }

    private static void init() {
        currentUser = null;
        users = new ArrayList<>();
        posts = new ArrayList<>();
        users.add(new AdminUser("admin", "admin"));
        lea.useDelimiter("\n");
    }
    
    private static User searchUser(String email){
        for(User user : users){
            if(user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    private static void login() {
        if(currentUser == null){
            System.out.println("Email: ");
            String em = lea.next();
            System.out.println("Password: ");
            String pass = lea.next();
            
            User user = searchUser(em);
            
            if(user!=null && user.isMyPassword(pass))
                currentUser = user;
            else
                System.out.println("Usuario No Existe");
        }
        else
            System.out.println("Sesion Ya Iniciada");
    }

    private static void crear() {
        if(currentUser != null){
            if(currentUser.validarAccion("CREAR")){
                System.out.println("Ingrese Post: ");
                String post = lea.next();
                //armo el post y lo guardo en el arreglo
                posts.add("Por: "+currentUser.getEmail()+"\n"+post);
                
                if(currentUser instanceof ContentUser){
                    //saco el id para guardarlo
                    int postId = posts.size()-1;
                    ((ContentUser)currentUser).addPostId(postId);
                }
            }
            else
                System.out.println("No tienes Permiso");
        }
        else
            System.out.println("Por Favor Inicie Sesion");
    }

    private static void signup() {
        if(currentUser != null){
            if(currentUser.validarAccion("CREAR-USUARIO")){
                System.out.println("Email: ");
                String em = lea.next();
                
                if(searchUser(em) == null ){
                    System.out.println("Password: ");
                    String pass = lea.next();
                    System.out.println("Tipo: ");
                    String tipo = lea.next();
                    
                    if(tipo.equalsIgnoreCase("ADMIN"))
                        users.add(new AdminUser(em, pass));
                    else
                        users.add(new ContentUser(em, pass));
                    
                    System.out.println("Usuario Agregado");
                }
                else
                    System.out.println("Email Ya Existe");
            }
            else
                System.out.println("No tienes Permiso");
        }
        else
            System.out.println("Por Favor Inicie Sesion");
    }

    private static void timeline() {
        System.out.println("POSTS\n--------------");
        for(String post : posts){
            System.out.println(post+"\n");
        }
    }

    private static void edit() {
        if(currentUser != null){
            System.out.println("Id del Post: ");
            int id = lea.nextInt();
            
            if(currentUser.validarAccion("EDITAR-"+id)){
                System.out.println("Texto a Adicionar: ");
                String adicion = lea.next();
                String post = posts.get(id);
                posts.set(id, post+"\n"+adicion);
            }
            else
                System.out.println("No tiene Permiso");
        }
        else
            System.out.println("Por Favor Inicie Sesion");
    }
}
