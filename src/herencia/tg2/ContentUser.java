/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.tg2;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class ContentUser extends User {
    private ArrayList<Integer> postIds;
    
    public ContentUser(String email, String password) {
        super(email, password);
        postIds = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString()+"-ContentUser"; 
    }

    @Override
    public boolean validarAccion(String accion) {
        if(accion.equals("CREAR-USUARIO"))
            return false;
        else if(accion.equals("CREAR"))
            return true;
        else{
            //es el de editar
            String info[] = accion.split("-");
            int idPost = Integer.parseInt(info[1]);
            return postIds.contains(idPost);
        }
    }
    
    public void addPostId(int pid){
        if(!postIds.contains(pid))
            postIds.add(pid);
    }
}
