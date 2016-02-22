/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;
/**
 *
 * @author René Rendón
 */
public class Twitter extends SocialClass{

    public Twitter(String u) {
        super(u);
    }

    @Override
    public void timeline() {
        for(String p: posts){
            System.out.println(p);
        }
    } 
}
