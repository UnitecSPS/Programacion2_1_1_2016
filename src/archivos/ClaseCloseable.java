/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aula
 */
public class ClaseCloseable implements AutoCloseable {

    @Override
    public void close() throws IOException {
        System.out.println("Se llamo el Close");
    }
    
    public static void main(String[] args) {
        try(ClaseCloseable c = new ClaseCloseable()){
            System.out.println(5/0);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
