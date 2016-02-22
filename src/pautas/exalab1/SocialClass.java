package pautas.exalab1;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author René Rendón
 */
public abstract class SocialClass {
    protected ArrayList<String> friends;
    protected ArrayList<String> posts;
    protected String username;
    
    public SocialClass(String u){
        friends=new ArrayList<>();
        posts=new ArrayList<>();
        username=u;
    }
    
    public boolean addFriend(String u){
        if(username.equals(u) || friends.contains(u))
            return false;
        friends.add(u);
        return true;
    }
    
    public void addPost(String msg){
        posts.add(msg);
    }
    
    public abstract void timeline();
    
    public void myProfile(){
        System.out.println(username);
        timeline();
        System.out.println("Amigos");
        for(int x=0; x<friends.size(); x++){
            System.out.print(friends.get(x)+" ");
            if((x+1)%10==0){
                System.out.println("");
            }
        }
    }
}
