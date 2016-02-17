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
public interface Storable {
    void saving(User u);
    User getUser(String e);
}
