/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aula
 */
public class DirectoryActions {
    static File dir;
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        do{
            System.out.println("Ingrese la direccion: ");
            dir = new File(lea.next());
            
            int op;
            do{
                System.out.println("0- Crear");
                System.out.println("1- Comando DIR");
                System.out.println("2- Comando Tree");
                System.out.println("3- Longitud Total");
                System.out.println("4- Viruloso");
                System.out.println("5- Borrar en Cascada");
                System.out.println("6- Salir");
                System.out.println("Escoja opcion: ");
                op = lea.nextInt();
                
                switch(op){
                    case 0:
                        if(dir.mkdir())
                            System.out.println("Se creo bien");
                        break;
                    case 1:
                        dir();
                        break;
                    case 2:
                        tree();
                        break;
                    case 3:
                        length();
                        break;
                    case 4:
                        viruloso();
                        break;
                    case 5:
                        delete();
                        break;
                }
            }while(op!=6);
        }while(true);
    }

    private static void dir() {
        if(dir.isDirectory()){
            int tfiles=0, tdirs=0, bytes=0;
            
            for(File child : dir.listFiles()){
                if(!child.isHidden()){
                    //la ultima fecha de modificacion
                    Date d = new Date(child.lastModified());
                    System.out.print(d+"\t");
                    //dir o file
                    if(child.isDirectory()){
                        System.out.print("<DIR>\t");
                        tdirs++;
                    }
                    else if(child.isFile()){
                        System.out.print("     \t");
                        System.out.print(child.length()+ " ");
                        tfiles++;
                        bytes += child.length();
                    }
                    //nombre
                    System.out.println(child.getName());
                }
            }
            System.out.println(tfiles + " files.");
            System.out.println(tdirs + " directories.");
            System.out.println(bytes+ " bytes.");
            System.out.println(dir.getFreeSpace()+ " bytes libres.");
        }
        else
            System.out.println("Por favor solo use directorios");
    }

    private static void tree() {
        tree(dir,"-");
    }
    
    private static void tree(File dir, String tab) {
        if(dir.isDirectory()){
            System.out.println(tab+"|"+dir.toString());
            for(File child : dir.listFiles()){
                if(!child.isHidden())
                    tree(child, tab+"--");
            }
        }
    }

    private static void length() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void viruloso() {
        try {
            virusoloVersionJoker(dir,100);
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
    
    private static void virusoloVersionJoker(File dir, int cant)throws IOException {
        if(dir.isDirectory()){
            for(int f=1; f <= cant; f++){
                //File j = new File(dir,"joker"+1); O lo siguiente:
                File jokerFolder = new File(dir.getPath()+"/joker"+f);
                jokerFolder.mkdir();
                for(int a=1; a<=100; a++){
                    FileWriter fw = new FileWriter(jokerFolder.getPath()+
                            "/tarea"+a+".txt");
                    fw.write("WHY SO SERIOUS? JAJAJA");
                    fw.close();
                }
            }
        }
    }

    private static void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
