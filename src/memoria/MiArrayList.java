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
        int cont = 0;
        Nodo mochilero = inicio;
        while(mochilero != null){
            cont++;
            mochilero = mochilero.next;
        }
        return cont;
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
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException(index+" invalid");
        
        if(index == 0){
            obj.next = inicio;
            inicio = obj;
        }
        else{
            Nodo tmp = inicio;
            for(int c=1;c < index;c++)
                tmp = tmp.next;
            obj.next = tmp.next;
            tmp.next = obj;
        }
    }
    
    /**
     * PRUEBA REDENTORA:
     * Busca un nodo dentro de la lista cuyo nombre es igual
     * al que se recibe de parametro. Si lo encuentra retorna
     * la posicion de ese nodo, comenzando desde 0. Sino, se
     * retorna -1.
     * @param name Nombre a buscar dentro de los nodos
     * @return La posicion si lo encuentra, -1 si no.
     */
    public int indexOf(String name){
        int pos=0;
        Nodo tmp = inicio;
        while(tmp != null){
            if(tmp.name.equals(name))
                return pos;
            pos++;
            tmp = tmp.next;
        }
        return -1;
    }
    
    public boolean contains(String name){
        return indexOf(name)>=0;
    }
    
    /**
     * Retorna el objeto nodo en esa posicion 
     * @param pos Posicion a buscar
     * @return El objeto nodo si lo encuentra
     * @throws IndexOutOfBoundException si el index es incorrecto
     */
    public Nodo get(int pos){
        return null;
    }
}
