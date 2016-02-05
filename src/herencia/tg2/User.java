/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.tg2;

/**
 *
 * @author Aula
 */
public class User {
    protected String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    
    public boolean isMyPassword(String pass){
        return password.equals(pass);
    }
    
    public boolean validarAccion(String accion){
        return false;
    }
    
    @Override
    public String toString(){
        return email;
    }
}
