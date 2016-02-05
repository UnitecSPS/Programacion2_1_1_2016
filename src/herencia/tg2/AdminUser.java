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
public class AdminUser extends User {

    public AdminUser(String email, String password) {
        super(email, password);
    }

    @Override
    public String toString() {
        return super.toString()+"-AdminUser"; 
    }

    @Override
    public boolean validarAccion(String accion) {
        return true;
    }
    
    
}
