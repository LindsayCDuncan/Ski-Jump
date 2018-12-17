/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author linzi
 */
public class Jump {
    private int length;
    private List<Integer> scores;
    
    public Jump(){
        scores = new ArrayList<Integer>();
        length = 0;
    }
    
    public void setLength(){
        //Random number between 60 and 120
        int maxLength = 120;
        int minLength = 60;
        
        this.length = (int)(Math.random() * ((maxLength - minLength) + 1) + minLength);
    }
    
    public void setScores(){
        scores.clear();
        for (int i = 0; i < 5; i++){
            scores.add(getRandomScore());
        }
    }
    
    public int getRandomScore(){
        //Random number between 10 and 20
        int maxScore = 20;
        int minScore = 10;
        
        return (int)(Math.random() * ((maxScore - minScore) + 1) + minScore);
    }
    
    public int getLength(){
        return this.length;
    }
    
    public List getScores(){
        return scores;
    }
    
    public int calculatePoints(){
        //Points for a jump = length + the three median scores
        int points = 0;
        
        if(length != 0 && scores != null){
            Collections.sort(scores);
            
            //Exlude lowest value (index 0) and highest value(index size-1)
            for (int i = 1; i < scores.size() - 1; i++){
                points += scores.get(i);
            }
        }
        return points + length;
    }
    
    public String toString(){
        String str = "    length: " + this.length +"\n    judge votes: " + getScores();
        return str;
    }
            
}
