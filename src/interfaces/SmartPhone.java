/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Aula
 */
public class SmartPhone extends Phone implements Connectable{
    private String ip;
    
    public SmartPhone(int number) {
        super(number);
        ip = "192.162.3.69";
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public Object sendingRequest() {
        return "Paquete";
    }

    @Override
    public void receivingRequest(Object paquete) {
        System.out.println("Receiving "+paquete);
    }

    @Override
    public String agent() {
        return "Mobile Web";
    }
    
}
