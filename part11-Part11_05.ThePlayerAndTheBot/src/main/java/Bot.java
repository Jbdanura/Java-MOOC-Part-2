/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jotabe
 */
public class Bot extends Player {
    
    public Bot(String name) {
        super(name); 
    }

    @Override
    public void play() {
        System.out.println("Bot is making a move...");
    }

    public void addMove(String move) {
        System.out.println("Bot added move: " + move);
    }
}
