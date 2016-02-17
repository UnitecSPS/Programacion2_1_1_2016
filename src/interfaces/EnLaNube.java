/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class EnLaNube {
    public static void main(String[] args) {
        ArrayList<Connectable> devices = new ArrayList<>();
        devices.add(new SmartPhone(995017852));
        devices.add(new Nintendo());
        
        System.out.println(devices.get(0).sendingRequest());
        System.out.println("Ip: "+ devices.get(1).getIp());
        
        for(Connectable c : devices)
            System.out.println(c.agent());
    }
}
