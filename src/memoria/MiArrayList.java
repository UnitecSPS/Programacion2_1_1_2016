/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Aula
 */
public class MiArrayList {
    Nodo inicio = null;
    
    public boolean isEmpty(){
        return inicio == null;
    }
    
    /**
     * Agregar un nuevo objecto al final de la lista
     * @param obj Es el objeto a agregar
     */
    public void add(Nodo obj){
        if(isEmpty()){
            inicio = obj;
        }
        else{
            //encontremos la cola
            Nodo tmp = inicio;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp = obj;
        }
    }
    
    /**
     * Imprime todos los nodos de la lista
     */
    public void print(){
        
    }
    
}
