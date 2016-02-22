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
public class Facebook extends SocialClass implements Commentable{
    ArrayList<Comment> comments;
    
    public Facebook(String u){
        super(u);
        comments=new ArrayList<>();
    }

    @Override
    public boolean addComment(Comment c) {
        if(c.postId >=0 && c.postId < posts.size()){
            return false;
        }
        comments.add(c);
        return true;
    }
    
    @Override
    public void timeline() {
        for(int x=0; x<posts.size(); x++){
            System.out.println(posts.get(x));
            for(Comment c: comments){
                if(c.postId==x){
                    c.print();
                }
            }
        }
    }    
}
