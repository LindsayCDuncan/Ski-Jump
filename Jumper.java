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
public class Jumper implements Comparable<Jumper>{
    private String name;
    private int totalPoints;
    private Map<String, Jump> jumps;
    
    public Jumper(String name) {
        this.name = name;
        this.totalPoints = 0;
        jumps = new HashMap<String, Jump>();
    }
    
    public void addPoints(String round){
        //Add points from round's jump to total points
        if (jumps.containsKey(round)){
            this.totalPoints += jumps.get(round).calculatePoints();
        }
    }
    
    public void addJump(String round, Jump jump){
        if(!jumps.containsKey(round)){
            jumps.put(round, jump);
        }
    }
    
    public int getLength(String round){
        Jump jump;
        if(jumps.containsKey(round)){
            jump = jumps.get(round);
            return jump.getLength();
        }
        return 0;
    }
    
    public Jump getJump(String round){
        if (jumps.containsKey(round)){
            return jumps.get(round);
        }
        return null;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getPoints(){
        return this.totalPoints;
    }
    
    public String toString(){
        String str = this.name + " (" + this.totalPoints + " points)";
        return str;
    }
    
    public void addLengthsToList(ArrayList<Integer> jumpLengths){
        //Add jump lengths to array list for easier printing manipulation
        String round = "";
        int size = jumps.size();
        if(!jumps.isEmpty()){
            
            for (int i = 0; i < size; i++){
                round = "Round " + (i + 1);
                jumpLengths.add(jumps.get(round).getLength());
            }
        }       
    }
    
    public String printJumpLengths(){
        //Print formatted jump lengths according to exercise
        ArrayList<Integer> jumpLengths = new ArrayList<Integer>();
        addLengthsToList(jumpLengths);
        String jumpStr = "";

        for(int i = 0; i < jumpLengths.size(); i++){
            if(i != jumpLengths.size() -1){
                jumpStr += jumpLengths.get(i) + " m, ";
            }
            else{
                jumpStr += jumpLengths.get(i) + " m";
            }
        }
        return jumpStr;
    }

    @Override
    public int compareTo(Jumper o) {
        int value = this.getPoints() - o.getPoints();
        if(value == 0) {
            value = (this.getName().compareToIgnoreCase(o.getName()));
        }
        return value;
    }
}
