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
public class Phone {
    protected int number;

    public Phone(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    
    public void call(int nd){
        System.out.println("calling..."+nd);
    }
    
    public void sms(int nd, String txt){
        System.out.println("Texting.."+txt+" to:"+nd);
    }
}
