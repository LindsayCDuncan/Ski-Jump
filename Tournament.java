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
public class Tournament {
    private List<Jumper> jumpers;
    Scanner scanner;
    
    public Tournament(Scanner scanner){
        jumpers = new ArrayList<Jumper>();
        this.scanner = scanner;
    }
    
    public void start(){
        System.out.println("Kumpula ski jumping week\n");
        
        System.out.println("Write the names of the participants one at a time; " +
                "an empty string brings you to the jumping phase.");        
        getNames();
        
        System.out.println("\nThe tournament begins!");        
        rounds();
        
        System.out.println("\nThanks!");
        
        //Final results must print in order of highest score
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        getTournyResults();       
    }
    
    public void getNames(){
        String input;
        while (true){
            System.out.print("  Participant name: ");
            input = scanner.nextLine();
            
            if(input.equals("")){
                break;
            }
            jumpers.add(new Jumper(input));            
        }
    }
    
    public void rounds(){
        String input;
        int roundNum = 1;
               
        while(true){
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            
            input = scanner.nextLine();
            if(!input.equals("jump")){
                break;
            }
            
            System.out.println("\nRound " + roundNum);
            jumpingOrder();
            calculateJump(roundNum);            
            printRoundResults(roundNum);
            roundNum++;
        }
    }
    
    public void jumpingOrder(){
        System.out.println("\nJumping order:");
        Collections.sort(jumpers);
        
        for(int i = 0; i < jumpers.size(); i++){
            System.out.println("  " + (i + 1) + ". " + jumpers.get(i));
        }
        System.out.println("");
    }
    
    public void calculateJump(int roundNum){
        Jump jump;
        String round = "Round " + roundNum;
        for(Jumper person : jumpers){
            jump = new Jump();
            jump.setLength();
            jump.setScores();
            
            person.addJump(round, jump);
            person.addPoints(round);
        }
    }
    
    public void printRoundResults(int roundNum){
        System.out.println("Results of round " + roundNum);
        for(Jumper person : jumpers){
            System.out.println("  " + person.getName());
            System.out.println(person.getJump("Round " + roundNum));
        }
    }
    
    public void getTournyResults(){
        System.out.println("\nTournament results: ");
        
        System.out.println("Position    Name");
        for(int i = 0; i < jumpers.size(); i++){
            System.out.println((i + 1) + "           " + jumpers.get(i) +
                    "\n            jump lengths: " + jumpers.get(i).printJumpLengths());

        }
    }   
}
