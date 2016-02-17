/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author Aula
 */
public class Nintendo implements Connectable, Closeable {
    
    public void playGame(String g){
        System.out.println("Loading game..."+g);
    }
    
    public void turnOn(){
        System.out.println("Turning on");
    }

    @Override
    public String getIp() {
        return "189.156.25.36";
    }

    @Override
    public Object sendingRequest() {
        System.out.println("Connecting to Nintendo Store");
        return true;
    }

    @Override
    public void receivingRequest(Object paquete) {
        System.out.println("Downloading "+paquete);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Closing Nintendo");
    }

    @Override
    public String agent() {
        return "Nintengo WebKit";
    }
}
