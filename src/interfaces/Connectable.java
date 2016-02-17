/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Serializable;

/**
 *
 * @author Aula
 */
public interface Connectable extends Serializable {
    int VERSION = 1;
    String getIp();
    Object sendingRequest();
    void receivingRequest(Object paquete);
    String agent();
}
