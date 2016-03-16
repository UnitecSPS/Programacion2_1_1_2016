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
            tmp.next = obj;
        }
    }
    
    /**
     * Imprime todos los nodos de la lista
     */
    public void print(){
        Nodo tmp = inicio;
        while(tmp != null){
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
    
    /**
     * Remueve un objeto de la lista cuyo atributo name
     * es igual a n
     * @param n El nombre a buscar
     */
    public void remove(String n){
        if(!isEmpty()){
          if(inicio.name.equals(n)){
              inicio = inicio.next;
          }
          else{
              Nodo tmp = inicio;
              while(tmp.next != null){
                  if(tmp.next.name.equals(n)){
                      tmp.next = tmp.next.next;
                      break;
                  }
                  tmp = tmp.next;
              }
          }
        }
    }
    
    /**
     * Retorna la cantidad de elementos que tiene la lista
     * @return La cantidad
     */
    public int size(){
        return 0;
    }
    
    /**
     * Agrega un nuevo nodo en la posicion que se le indica.
     * Las posiciones comienzan desde 0.
     * @param index La posicion del arreglo
     * @param obj El nodo a agregar
     * @throws IndexOutOfBoundException si el index se pasa
     * del rango o es negativo.
     */
    public void add(int index,Nodo obj){
        
    }
    
}
