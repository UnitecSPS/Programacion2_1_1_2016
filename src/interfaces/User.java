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
public class User {
    public String email;
    public String pass;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", pass=" + pass + '}';
    }
    
    
}
