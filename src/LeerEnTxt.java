
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aula
 */
public class LeerEnTxt {
    public static void main(String[] args) {
       Scanner lea = new Scanner(System.in);
       
       do{
           System.out.println("Direccion: ");
           String path  = lea.next();
           
           
           try{
               //1- Metodo utilizando solamente FileReader
               File file = new File(path);
               FileReader fr = new FileReader(file);
               char buffer[] = new char[(int)file.length()];
               int bytes = fr.read(buffer);
               System.out.println("Se leyo: "+bytes+" bytes.");
               System.out.println("Contenido Metodo 1\n--------------");
               System.out.println(buffer);
//               for(char c : buffer)
//                   System.out.println(c);
               
               //2- Metodo utilizando la Scanner
               System.out.println("\nContenido Metodo 2\n---------------");
               Scanner lector = new Scanner(file);
               while(lector.hasNext()){
                   System.out.println(lector.nextLine());
               }
           }
           catch(IOException e){
               System.out.println(e);
           }
       }while(true);
    }
}
