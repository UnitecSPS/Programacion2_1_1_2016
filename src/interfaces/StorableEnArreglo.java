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
public class StorableEnArreglo implements Storable {
    User users[] = new User[100];
    int conta = 0;
    
    @Override
    public void saving(User u) {
        if(conta < 100)
            users[conta++] = u;
    }

    @Override
    public User getUser(String e) {
        for(User u : users){
            if(u!=null && u.email.contains(e))
                return u;
        }
        return null;
    }
    
}
