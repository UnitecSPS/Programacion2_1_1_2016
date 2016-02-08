/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.prueba2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class BarcoPasajero extends Barco {
    ArrayList<String> pasajeros;
    
    public BarcoPasajero(String n) {
        super(n);
        pasajeros = new ArrayList<>();
    }

    @Override
    public void agregar() {
        Scanner lea = new Scanner(System.in);
        pasajeros.add(lea.next());
    }

    @Override
    public double vaciarCobrar() {
        double total = 250 * pasajeros.size();
        pasajeros.clear();
        return total;
    }
    
}
