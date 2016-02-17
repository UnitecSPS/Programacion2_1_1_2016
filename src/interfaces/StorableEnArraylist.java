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
public class StorableEnArraylist implements Storable {
    ArrayList<User> users = new ArrayList<>();
    
    @Override
    public void saving(User u) {
        users.add(u);
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
