/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class FileTest {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        File f = new File(lea.nextLine());
        
        if(f.exists()){
            System.out.println("Existe!");
            //datos
            System.out.println("Nombre: "+f.getName());
            System.out.println("Path: "+f.getPath());
            System.out.println("Absoluta: "+f.getAbsolutePath());
            System.out.println("Parent: "+f.getAbsoluteFile().getParentFile().getName());
            System.out.println("bytes: "+f.length());
            
            if(f.isFile())
                System.out.println("Es un Archivo");
            else if(f.isDirectory())
                System.out.println("Es un Directorio");
            if(f.isHidden())
                System.out.println("Esta Hidden");
            
            System.out.println("Lo queres borrar? (si|no): ");
            if(lea.next().equalsIgnoreCase("si")){
                if(f.delete())
                    System.out.println("Se borro");
                else
                    System.out.println("No se puede borrar");
            }
                
        }
        else{
            System.out.println("No existe!");
            System.out.println("CREARLO? Ingrese DIR o FILE: ");
           
            switch(lea.next().toUpperCase()){
                case "DIR":
                    if( f.mkdirs() )
                        System.out.println("Se creo el directorio");
                    break;
                case "FILE":
                    try{
                        if( f.createNewFile() )
                            System.out.println("Se creo el archivo");
                    }
                    catch(IOException e){
                        System.out.println(e);
                    }
                    break;
            }
        }
    }
}
