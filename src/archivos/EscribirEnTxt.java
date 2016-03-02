/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class EscribirEnTxt {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("Path: ");
            String path = lea.next();
            System.out.println("Appendo si o no?: ");
            String app = lea.next().toLowerCase();
            
            try{
                FileWriter fw = new FileWriter(path, app.equals("si"));
                
                String data;
                do{
                    data = lea.nextLine();
                    if(!data.equals(":wq"))
                        fw.write(data+"\r\n");
                        
                }while(!data.equals(":wq"));
                
                fw.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
            
        }while(true);
    }
}
